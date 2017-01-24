package com.egsbc.main.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.egsbc.alarm.AlarmCountVO;
import com.egsbc.alarm.service.AlarmService;
import com.egsbc.security.CustomUserDetails;
import com.egsbc.security.service.CustomUserDetailsService;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserConfigVO;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.ControlService;
import com.egsbc.system.service.UserService;
import com.egsbc.utils.Global;
import com.egsbc.ws.ChartVO;


@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	@Resource(name="controlService")
	private ControlService controlService;
	
	@Resource(name="userService")
	 private UserService userService;
	
	@Resource(name="customUserDetailsService")
	private CustomUserDetailsService customUserDetailsService;
	
	@Resource(name="alarmService")
	private AlarmService alarmService;
	
	@Autowired
	private SessionRegistry sessionRegistry;
	

	
	// for websocket
//	@Autowired 
//	private SimpMessagingTemplate template;
	private TaskScheduler scheduler = new ConcurrentTaskScheduler();
	private SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA ); 
	private Thread thread;
	
	
	
	 @RequestMapping(value = "/main")
	 public String main() {
		 return "main";
	 }
	 
	 @RequestMapping(value = "/home")
	 public String home(HttpServletRequest request, Authentication authentication) throws Exception {
		 
		 // 로그인상태저장
		 //UserDetails details = (UserDetails)authentication.getDetails();
		 CustomUserDetails details = (CustomUserDetails)authentication.getDetails();
		 userService.setUserStatus(new UserVO(details.getUsername(), Global.USER_STATUS_LOGIN, request.getRemoteAddr()));
		 
		 return "home";
	 }
	 @RequestMapping(value = "/home2")
	 public ModelAndView home2(HttpServletRequest request, Authentication authentication) throws Exception {
		 
		 ModelAndView mav = new ModelAndView();
		 
		 UserDetails details = (UserDetails)authentication.getDetails();
		 
		 UserVO userVO = userService.getUser(details.getUsername());
		 
		 List<UserConfigVO> list = userService.getManagerConfigure();
		 if(list.size()==1){
			 short sleepModeByNoActionDuration = list.get(0).getSleepModeByNoActionDuration();
			 short forceLogoutByNoActionDuration = list.get(0).getForceLogoutByActionDuration();
			 
			 // stayLoggedIn이 체크되어있으면 lock안함.=> (sleepModeByNoActionDuration=0)
			 if(userVO.getStayLoggedIn() == 1){
				 sleepModeByNoActionDuration = 0;
				 forceLogoutByNoActionDuration = 0;
			 }
			 mav.addObject("sleepModeByNoActionDuration", sleepModeByNoActionDuration);
			 mav.addObject("forceLogoutByNoActionDuration", forceLogoutByNoActionDuration);
			 
		 }
		
		 mav.setViewName("home2");
		 mav.addObject("userVO", userVO);
		 	
		 return mav;
	 }
	 
	 @RequestMapping(value = "/form-elements")
	 public String formEments() {
		 return "form-elements";
	 }
	 
	 @RequestMapping(value = "/form-templates")
	 public String formTemplates() {
		 return "form-templates";
	 }
	 
	 @RequestMapping(value = "/test01")
	 public String test01() {
		 logger.info("[test01]");
		 return "test01";
	 }
	 
	 @RequestMapping(value = "/testDateRangePicker")
	 public String testDateRangePicker() {
		 return "testDateRangePicker";
	 }
	 
	 /***************************************************************************************************
	  * 
	  * 	Error
	  * 
	  ****************************************************************************************************/
	 @RequestMapping(value = "/error/bizError")
	 public String bizError() {
		 return "error/bizError";
	 }
	 
	 
	 
	 /***************************************************************************************************
	  * 
	  * 	Register 처음관리자 PW변경
	 * @throws Exception 
	  * 
	  ****************************************************************************************************/
	 
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	 public String register(UserVO vo, RedirectAttributes redirectAttributes ) throws Exception {
		 
		 // "admin" 입력아니면 실패
		 if(!vo.getId().equals("admin")){
			 return "registerFailure";
		 }
		 
		 String inputPw = customUserDetailsService.digest(vo.getId(), vo.getPw());
		 
		 // PW가 "admin" 그대로면 실패
		 UserVO userVO = userService.getUser(vo.getId());
		 if(userVO == null || userVO.getPw().equals(inputPw)){
			 return "registerFailure";
		 }
		 
		 // PW변경
		 userVO.setPw(inputPw);
		 int result = userService.changeUserPw(userVO);
		 if(result == 1){
//			 redirectAttributes.addAttribute("id", userVO.getId());  
//			 redirectAttributes.addAttribute("pw", userVO.getPw());
//			 return "redirect:loginProcess";
			 return "login";
		 }else{
			 return "registerFailure";
		 }
	 }
	 
	 
	 /***************************************************************************************************
	  * 
	  * 	Login
	 * @throws Exception 
	  * 
	  ****************************************************************************************************/
	 /*
	  * before Login
	  */
	 @RequestMapping(value="/getUserSessionSize", method=RequestMethod.POST)
	 public ModelAndView loginBefore(String username) throws Exception {
		 
		 List<SessionInformation> userSessions = sessionRegistry.getAllSessions(username, false);
//	     for (SessionInformation userSession : userSessions){
//	            userSession.expireNow();
//	     }
		 
		 UserVO userVO = new UserVO();
		 userVO.setId(username);
	        
		 return new ModelAndView("jsonView", "result", userSessions.size()); 
	 }
	 
	 
	 
	 
	 /*
	  * 로그아웃 -  login
	  */
	 @RequestMapping(value = "/login")
	 public String login( HttpServletRequest request) throws Exception {
//		 if(userService.isFirstTime()){
//			 return "register";
//		 }
		 return "login";
	 }
	 
	 
	 
	 /*
	 * login success
	 */
	@RequestMapping(value="/loginSuccess", method=RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request, Authentication authentication) throws Exception {
		
		CustomUserDetails details = (CustomUserDetails)authentication.getDetails();
		
		// 최초접속(admin/admin)인지 확인
		if(details.getUsername().equals("admin")){
			if(details.getPassword().equals(customUserDetailsService.digest(details.getUsername(), "admin"))){
				return "register"; 
			}
		}
			
		
		// set login
		userService.setUserStatus(new UserVO(details.getUsername(), Global.USER_STATUS_LOGIN, request.getRemoteAddr()));
		
		// add UserActionHistory
		userService.addUserActionHistory(new UserActionHistoryVO(details.getUsername(), Global.HISTORY_LOGIN, "login ok", (short)0, ""));
		
		return "redirect:/home"; 
	}
	
	
	/*
	 * loginFailure Page
	 */
	@RequestMapping("/loginFailure")
    public String loginFailure() throws Exception {
//		 if(userService.isFirstTime()){
//			 return "register";
//		 }
        return "loginFailure";
    }
	
	/*
	 * loginDup Page
	 */
	@RequestMapping("/loginDup")
    public String loginDup() throws Exception {
//		 if(userService.isFirstTime()){
//			 return "register";
//		 }
        return "loginDup";
    }
	
	
	
	
	/*
	 * getAlarmStatus 
	 */
	@RequestMapping(value = "/getAlarmStatus", method = RequestMethod.POST)
    public ModelAndView getAlarmStatus(short alarmLevel) throws Exception {
		
		AlarmCountVO alarmCountVO = null;
//		List<AlarmDataVO> alarmDataList = null;
		
//		AlarmTriggerVO alarmTriggerVO = alarmService.getAlarmTrigger();
//		
//		if(alarmTriggerVO != null && alarmTriggerVO.getAlarmOccured() == 1){
			
			//---------------- get Alarm Count --------------------------------------
			alarmCountVO = new AlarmCountVO();
			
			List<HashMap<String, Object>> mapList = alarmService.getAlarmCount();
			
			for(Map<String, Object> map : mapList){
				
				String level = map.get("alarmLevel").toString();
				int cnt = Integer.parseInt(map.get("cnt").toString());
				
				if(level.equals("1")){
					alarmCountVO.setInformationCnt(cnt);
				}else if(level.equals("2")){
					alarmCountVO.setMinorCnt(cnt);
				}else if(level.equals("3")){
					alarmCountVO.setMajorCnt(cnt);
				}else if(level.equals("4")){
					alarmCountVO.setCriticalCnt(cnt);
				}
			}
			
			//---------------- get Alarm List  -------------------------------------- 
			String lastAlarmDatetime = alarmService.getLastAlarmDatetime();
//			if(!StringUtils.isEmpty(lastAlarmDatetime2)){
//				lastAlarmDatetime2 = lastAlarmDatetime2.substring(0, 19);
//				if(!lastAlarmDatetime2.equals(lastAlarmDatetime)){
//					alarmDataList = alarmService.getAlarmData(alarmLevel);
//				}
//			}
			
			
			//---------------- trigger set 0  -------------------------------------- 
//			alarmService.setAlarmTrigger(new AlarmTriggerVO((short)0));
			
//		}
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("alarmCount", alarmCountVO);
		mav.addObject("lastAlarmDatetime", lastAlarmDatetime);
		return mav;
	}
	
	
	/*
	 * getAlarmCount 
	 */
	
	@RequestMapping(value = "/getAlarmCount", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getAlarmCount() throws Exception {
		
		AlarmCountVO alarmCountVO = new AlarmCountVO();
		
		List<HashMap<String, Object>> mapList = alarmService.getAlarmCount();
		
		for(Map<String, Object> map : mapList){
			
			String alarmLevel = map.get("alarmLevel").toString();
			int cnt = Integer.parseInt(map.get("cnt").toString());
			
			if(alarmLevel.equals("1")){
				alarmCountVO.setInformationCnt(cnt);
			}else if(alarmLevel.equals("2")){
				alarmCountVO.setMinorCnt(cnt);
			}else if(alarmLevel.equals("3")){
				alarmCountVO.setMajorCnt(cnt);
			}else if(alarmLevel.equals("4")){
				alarmCountVO.setCriticalCnt(cnt);
			}
		}
		
		return new ModelAndView("jsonView", "result", alarmCountVO);
	}
	
	
	/*
	 * --------------------------------------------------------------------------------------
	 * 
	 * 		heartbeat
	 * 
	 * --------------------------------------------------------------------------------------
	 */
	@RequestMapping(value = "/heartbeat", method = RequestMethod.POST)
    public ModelAndView heartbeat() throws Exception {
		
		int alive = 0;
		
		CustomUserDetails details =  (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		for(Object principal  : sessionRegistry.getAllPrincipals()){
			if(principal.equals(details.getUsername())){
				alive = 1;
			}
		}
		
		return new ModelAndView("jsonView", "result", alive);
    }
	/*
	 * --------------------------------------------------------------------------------------
	 * 
	 * 		logoutForce
	 * 
	 * --------------------------------------------------------------------------------------
	 */
	@RequestMapping("/logoutForce")
    public ModelAndView logoutForce(HttpServletRequest request, Authentication authentication, String id) throws Exception {
		
		int result = 0;
		
		List<SessionInformation> sessions = sessionRegistry.getAllSessions(id, false);
		for(SessionInformation si: sessions){
			if(si.getPrincipal().equals(id)){
				// expired
				si.expireNow();
				
				result = 1;
			}
		}
		
		return  new ModelAndView("jsonView", "result", result);
    }
	
	/*
	 * --------------------------------------------------------------------------------------
	 * 
	 * 		lock
	 * 
	 * --------------------------------------------------------------------------------------
	 */
	
	// lock일때 
	@RequestMapping(value = "/lock", method = RequestMethod.POST)
    public ModelAndView lock(HttpServletRequest request, String url, Authentication authentication) throws Exception {
		request.getSession().setAttribute("prePage", url);
		return new ModelAndView("jsonView", "page", "lockPage");
    }
	
	// lockPage
	@RequestMapping(value = "/lockPage", method = {RequestMethod.GET, RequestMethod.GET})
    public ModelAndView lockPage(String id) throws Exception {
		
		ModelAndView mav = new ModelAndView("lockPage");
		mav.addObject("userId", id);
		
		List<UserConfigVO> list = userService.getManagerConfigure();
		if(list.size()==1){
			short forceLogoutDuration = list.get(0).getForceLogoutByActionDuration();
			short sleepDuration = list.get(0).getSleepModeByNoActionDuration();
			forceLogoutDuration = (short) (forceLogoutDuration - sleepDuration);
			 
			 mav.addObject("forceLogoutByNoActionDuration", forceLogoutDuration);
		}
		
		
		// set status
		userService.setUserStatus(new UserVO(id, Global.USER_STATUS_TEMP_BLOCKED_BY_LIMIT, ""));
		 
		// add UserActionHistory
		userService.addUserActionHistory(new UserActionHistoryVO(id, Global.HISTORY_TEMP_BLOCKED, "temp blocked", (short)0, ""));
			
		 
		return mav;
    }
	
	
	// lock에서 password 넘길때
	@RequestMapping(value = "/checkPw", method = RequestMethod.POST)
    public ModelAndView checkPw(HttpServletRequest request, Authentication authentication, @RequestParam String pw) throws Exception {
		
		String prePage = "";
		CustomUserDetails details =  (CustomUserDetails)authentication.getDetails();
		
		if(pw != null && !pw.equals("")){
			
			pw = customUserDetailsService.digest(details.getUsername(), pw);
			
			if(pw.equals(details.getPassword())){
				prePage = (String) request.getSession().getAttribute("prePage");
				
				request.getSession().setAttribute("prePage", null);
			}
		}
		
		return new ModelAndView("jsonView", "prePage", prePage);
    }
	
	
	
	/*
	 * --------------------------------------------------------------------------------------
	 * 
	 * 		STOMP
	 * 
	 * --------------------------------------------------------------------------------------
	 */
	
	@PostConstruct
	private void broadcastTimePeriodically() {
		
		// timer
//		scheduler.scheduleAtFixedRate(new Runnable() {
//			@Override public void run() {
////				template.convertAndSend("/topic/datetime", formatter.format (new Date()));
//			}
//	    }, 1000);
		
		
		// status
//		scheduler.scheduleAtFixedRate(new Runnable() {
//			@Override public void run() {
//				List<PrimitiveSysDupVO> list = null;
//				
//				try {
//					list = controlService.getPrimitiveSysDup();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//				template.convertAndSend("/topic/status", list);
//			}
//	    }, 5000);
		
		
		/*
		 *  Client Socket
		 */
//		thread = new Thread(new ConcreteRunnable(template));
//		thread.start();
		
	}
	
}





class ConcreteRunnable implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(ConcreteRunnable.class);
	
	private SimpMessagingTemplate template;
	
	private ServerSocket serverSocket = null;
	private int port = 3000;
    
    
	public ConcreteRunnable(SimpMessagingTemplate template){
		logger.info("************ 0 *************");
		this.template = template; 
	}
	
	
	@Override
	public void run() {
		
		try{
			serverSocket = new ServerSocket(port);
		
			while(true){
				
				
				 Socket socket = null;
				
				try {
					
					 
					 // accept
					 socket = serverSocket.accept();
					 logger.info("[OK] Chart Socket : connectd from " + socket.getInetAddress());
					 
					 InputStream in = socket.getInputStream();
					 
					 BufferedReader  br = new BufferedReader(new InputStreamReader(in));
					 String msg = null;
					 
					 
					 
					 while((msg = br.readLine()) != null){
						 
						if(msg.length() == 0){
							logger.info("[ERROR] Chart Socket : received data length is zero!");
							continue;
						}
						 
						String[] arr = msg.split("\\|");
						if(arr.length < 8){
							logger.info("[ERROR] Chart Socket : received data length less than 8 (received length is " + arr.length);
							continue;
						}
						
						//---------- parsing ------------------------------
						 
						ChartVO chartVO = new ChartVO();
						chartVO.setChartIndex(Short.parseShort(arr[0]));
						chartVO.setChartTitle(arr[1]); 
						
						int cnt = Integer.parseInt(arr[2]);
						int needCnt = 4 + (4 * cnt);
						
						if(arr.length != needCnt){
							logger.info("[ERROR] Chart Socket : received data length is Not proper length (need length is " + needCnt + ", but received length is " + arr.length);
							continue;
						}
						
						chartVO.setDataCnt(cnt); 
						
						int idx = 3;
						chartVO.setLegendArray(getStringArray(arr, idx, cnt)); 
						
						idx += cnt;
						chartVO.setColorArray(getStringArray(arr, idx, cnt));
						
						idx += cnt;
						chartVO.setDateTime(arr[idx].substring(14, 19));
						
						idx += 1;
						chartVO.setDataArray(getStringArray(arr, idx, cnt));
						
						idx += cnt;
						chartVO.setUnitArray(getStringArray(arr, idx, cnt));
						
						template.convertAndSend("/topic/chart", chartVO);
						
					 }
					 
				}catch(IOException e){
					logger.info("############# IPC ERROR(Chart 1) : " + getRootCause(e).getMessage());
				}finally{
		        	if(socket != null){
		        		try {
		        			socket.close();
		    			} catch (IOException e) {}
		        	}
		        }
			}
	        	
		}catch(IOException e){
			logger.info("############# IPC ERROR(Chart 2) : " + getRootCause(e).getMessage());
		}finally{
        	if(serverSocket != null){
        		try {
        			serverSocket.close();
    			} catch (IOException e) {}
        	}
        }
		
		
		
		//===================== test ================================================
//		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA ); 
//		Random generator = new Random();   
//		
//		while(true){
//			
//			
//			String dateTime = formatter.format (new Date());
//			long num1 = generator.nextInt(25) + 10;    // 10 ~ 35  
//         	long num2 = generator.nextInt(50) + 35;    // 20 ~ 85  
//			
//         	ChartVO chartVO = new ChartVO();
//         	chartVO.setChartIndex((short) 0);
//         	chartVO.setChartTitle("title1");
//         	chartVO.setDataCnt(2);
//         	chartVO.setLegendArray("series1"+","+"series2");
//         	chartVO.setColorArray("#6595B4"+","+"#7E9D3A");
//         	chartVO.setDateTime(dateTime.substring(14, 19));
//         	chartVO.setDataArray(num1+","+num2);
//         	chartVO.setUnitArray("Count"+","+"Kbps");
//         	
//         	template.convertAndSend("/topic/chart", chartVO);
//         	
//         	
//         	num1 = generator.nextInt(25) + 10;    // 10 ~ 35  
//         	num2 = generator.nextInt(50) + 35;    // 20 ~ 85  
//         	chartVO = new ChartVO();
//         	chartVO.setChartIndex((short) 1);
//         	chartVO.setChartTitle("title2");
//         	chartVO.setDataCnt(2);
//         	chartVO.setLegendArray("series1"+","+"series2");
//         	chartVO.setColorArray("#6595B4"+","+"#7E9D3A");
//         	chartVO.setDateTime(dateTime.substring(14, 19));
//         	chartVO.setDataArray(num1+","+num2);
//         	chartVO.setUnitArray("Count"+","+"Mbps");
//         	template.convertAndSend("/topic/chart", chartVO);
//         	
//         	num1 = generator.nextInt(25) + 10;    // 10 ~ 35  
//         	num2 = generator.nextInt(50) + 35;    // 20 ~ 85  
//         	chartVO = new ChartVO();
//         	chartVO.setChartIndex((short) 2);
//         	chartVO.setChartTitle("title3");
//         	chartVO.setDataCnt(2);
//         	chartVO.setLegendArray("series1"+","+"series2");
//         	chartVO.setColorArray("#6595B4"+","+"#7E9D3A");
//         	chartVO.setDateTime(dateTime.substring(14, 19));
//         	chartVO.setDataArray(num1+","+num2);
//         	chartVO.setUnitArray("Count"+","+"Mbps");
//         	template.convertAndSend("/topic/chart", chartVO);
//         	
//         	num1 = generator.nextInt(25) + 10;    // 10 ~ 35  
//         	num2 = generator.nextInt(50) + 35;    // 20 ~ 85  
//         	chartVO = new ChartVO();
//         	chartVO.setChartIndex((short) 3);
//         	chartVO.setChartTitle("title4");
//         	chartVO.setDataCnt(2);
//         	chartVO.setLegendArray("series1"+","+"series2");
//         	chartVO.setColorArray("#6595B4"+","+"#7E9D3A");
//         	chartVO.setDateTime(dateTime.substring(14, 19));
//         	chartVO.setDataArray(num1+","+num2);
//         	chartVO.setUnitArray("Count"+","+"Mbps");
//         	template.convertAndSend("/topic/chart", chartVO);
//         	
//			
//         	try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		
		
		
//		}
			
	}

	private static Throwable getRootCause(Throwable throwable) {
	    if (throwable.getCause() != null)
	        return getRootCause(throwable.getCause());

	    return throwable;
	}	
	
	private String getStringArray(String[] arr, int start, int cnt){
		String s = "";
		for(int i=0; i<cnt; i++){
			if(s != "") s += ",";
			s += arr[start++];
		} 
		return s;
	}

}
