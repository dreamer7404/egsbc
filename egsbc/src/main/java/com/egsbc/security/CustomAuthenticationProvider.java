package  com.egsbc.security;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;

import com.egsbc.security.service.CustomUserDetailsService;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserConfigVO;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.UserService;
import com.egsbc.utils.Global;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {  
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	private Pattern pattern;
	private Matcher matcher;
	
	private final String USERNAME_PATTERN  = "^[A-Za-z0-9_-]{4,20}$";
	private final String PASSWORD_PATTERN  =  "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[@#$%]).{6,20})";
	  
	
	@Resource(name="customUserDetailsService")
	private CustomUserDetailsService customUserDetailsService;
	
	@Resource(name="userService")
	private UserService userService;
	
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
  
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	
    	/*
    	 * id, pw 가져오기
    	 */
    	String id = "";
    	short stayLoggedIn = 0;
    	
    	String[] arr =  authentication.getPrincipal().toString().split("\\|");
    	if(arr.length == 2){
    		id = arr[0];
    		stayLoggedIn = Short.parseShort(arr[1]);
    	}
        String pw = (String)authentication.getCredentials(); 
        
        /*
         * id, pw Validation 체크
         */
        if(!(id.equals("admin") && pw.equals("admin"))){  // 최초접속이 아니면...(최초접속이면 /loginSuccess 에서 register로 redirect한다.)
        	
        	// id
	        pattern = Pattern.compile(USERNAME_PATTERN);
	        matcher = pattern.matcher(id);
	        
	        if(!matcher.matches()){
	        	logger.info("[ERROR] USERNAME matcher.matches() : " + matcher.matches());
				throw new BadCredentialsException("Bad credentials");
	        }
        	
	        // pw 
	        pattern = Pattern.compile(PASSWORD_PATTERN);
	        matcher = pattern.matcher(pw);
	        if(!matcher.matches()){
	        	logger.info("[ERROR] PASSWORD matcher.matches() : " + matcher.matches());
				throw new BadCredentialsException("Bad credentials");
	        }
        }
        
        
         
		try {
			//String testPw = customUserDetailsService.digest("admin", "admin");
			
			CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(id);
			if(customUserDetails != null){
				
				// compare pw 
				if(!customUserDetails.getPassword().equals(customUserDetailsService.digest(id, pw))){
					
					List<UserConfigVO> userConfigList = userService.getManagerConfigure();
					if(userConfigList.size()==1){
						short limitLoginFailCount = userConfigList.get(0).getLimitLoginFailCount(); // 로그인실패 한계수
						short userLoginCount = customUserDetails.getLoginFailCount(); // 사용자 로그인실패수
						if(++userLoginCount >= limitLoginFailCount){ // limit 이상이면
							// set status=3, blocked=NOW()
							UserVO userVO = new UserVO();
							userVO.setId(id);
							userVO.setStatus(Global.USER_STATUS_TEMP_BLOCKED_BY_LIMIT); // status=blockedByLimit
							userService.setUserStatus(userVO);
							
							// add UserActionHistory
							userService.addUserActionHistory(new UserActionHistoryVO(id, Global.USER_STATUS_TEMP_BLOCKED_BY_LIMIT, "blocked by limit", (short)0, ""));
						}else{
							// set LoginFailCount = LoginFailCount + 1
							UserVO userVO = new UserVO();
							userVO.setId(id);
							userVO.setLoginFailCount((short)1);
							userService.setUserStatus(userVO);
							
							// add UserActionHistory
							userService.addUserActionHistory(new UserActionHistoryVO(id, Global.USER_STATUS_LOGIN, "login fail : wrong pw", (short)0, ""));
						}
					}
					
					logger.info("패스워드가 틀립니다.");
					throw new BadCredentialsException("Bad credentials");
				}
				
				// blocked by limit (로그인 5번실패후 로그인 못하는 시간)
				if(customUserDetails.getStatus()==Global.USER_STATUS_TEMP_BLOCKED_BY_LIMIT){
					
					int isOver = userService.isBlockedLimitTimeOver(new UserVO(id));
					if(isOver==0){ // 아직 Block by Limit 시간 이내
						// add UserActionHistory
						userService.addUserActionHistory(new UserActionHistoryVO(customUserDetails.getUsername(), Global.USER_STATUS_LOGIN, "login fail : blocked by limit", (short)0, ""));
						 logger.info("사용자의 BLOCKED by limit의 Duration 이 안지났습니다..");
						 throw new BadCredentialsException("Bad credentials");
					}
					
				// blocked by Force
				}else if(customUserDetails.getStatus()==Global.USER_STATUS_FORCED_BLOCKED){
					// add UserActionHistory
					userService.addUserActionHistory(new UserActionHistoryVO(customUserDetails.getUsername(), Global.USER_STATUS_LOGIN, "login fail : blocked", (short)0, ""));

					 logger.info("사용자가 강제로  BLOCK되어서 로그인이 안됩니다.");
					 throw new BadCredentialsException("Bad credentials");
				}
				
				
				// check IP ACL
				String remoteAddr="";
				Object details = authentication.getDetails();
				if (details instanceof WebAuthenticationDetails){
					
					remoteAddr = ((WebAuthenticationDetails) details).getRemoteAddress();
					if(remoteAddr != null && !remoteAddr.equals("")){
						
						String aclEnable = userService.getManagerUserAclEnable(remoteAddr);
						if(aclEnable == null || aclEnable.equals("0")){
							// add UserActionHistory
							String str = (aclEnable == null)? "No ACL" : "ACL Disabled";
							userService.addUserActionHistory(new UserActionHistoryVO(customUserDetails.getUsername(), Global.USER_STATUS_LOGIN, "login fail : " + str, (short)0, ""));

							 logger.info("사용자 ACL이 Disable입니다.");
							 throw new BadCredentialsException("Bad credentials");
						}
					}
				}
				
				
				// stayLoggedIn
				 UserVO userVO = new UserVO();
				 userVO.setId(id);
				 userVO.setStayLoggedIn(stayLoggedIn);
				 userService.setUserStatusStayLoggedIn(userVO);
				
				
				// set role
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				roles.add(new SimpleGrantedAuthority(getRole(3))); //getRole(userVO.getLevel())));
				
				// return token
				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, pw, roles);
				result.setDetails(customUserDetails);
				return result;  
				
				
			}else{
				logger.info("아디디가 없습니다.");
				throw new BadCredentialsException("Bad credentials");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			 logger.info("사용자 크리덴셜 정보가 틀립니다. 에러가 발생합니다.");
			throw new BadCredentialsException("Bad credentials");
		}
        
    }
    
    private String getRole(int auth){ 
    	if (auth == 1)
    		return "ROLE_SYSTEM";
    	else if (auth == 2)
    		return "ROLE_ADMIN";
    	else 
    		return "ROLE_USER";
    }
    
    



}
