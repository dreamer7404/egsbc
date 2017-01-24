package com.egsbc.common.logger;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.common.IPCMsgVO;
import com.egsbc.security.CustomUserDetails;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.service.UserService;
import com.egsbc.utils.Global;

/**
 * 
 *  실행순서
 * 
 * @Before
 * @Around (대상 메소드 수행 전)
 * 대상 메소드
 * @Around (대상 메소드 수행 후)
 * @After(finally)
 * @AfterReturning 
 *
 */

@Aspect
public class LoggerAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Resource(name="userService")
	 private UserService userService;
	
	static String name = "";
    static String type = "";
    static String[] opModeArray = {"", "", "add", "modify", "delete", "apply", "upload", "download", "execute"};

    
    @Around("execution(* com.egsbc..web.*Controller.take*(..))")
    public ModelAndView loggingAroundTake(ProceedingJoinPoint joinPoint) throws Throwable {
    	
    	ModelAndView mav = new ModelAndView();
		
    	try{
    		
    		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
	    	String[] argNames = codeSignature.getParameterNames();
	    	
	    	// take.. Method
	    	if(codeSignature.toShortString().indexOf(".take") > -1){
		    	for(int i = 0; i<argNames.length; i++){
		    		
		    		if(argNames[i].equals("vo")){
		    			String actionDesc = "";
		    			short actionResult = 0;
		    			String errorReason = "";
		    			
		    			// details
		    			CustomUserDetails details =  (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		    			
		    			Object[] args = joinPoint.getArgs();
		    			
		    			IPCMsgVO obj = (IPCMsgVO)args[i];
		    			short opMode = obj.getOpMode();
		    			
		    			mav = (ModelAndView) joinPoint.proceed();
		    			
		    			@SuppressWarnings("unchecked")
						List<String> list = (List<String>) mav.getModel().get("result");
		    			if(list.size() > 1){
		    				actionResult = Short.parseShort(list.get(0));
		    				if(actionResult != 0){
		    					errorReason = list.get(1);
		    				}
		    			}
		    			
		    			// actionDesc
		    			actionDesc = opModeArray[opMode] + " " + codeSignature.getName().substring(4);
		    			
		    			// insert command history
						userService.addUserActionHistory(
								new UserActionHistoryVO(
										details.getUsername(), 
										Global.HISTORY_COMMAND, 
										actionDesc, 
										actionResult, 
										errorReason));
		    	    	
		    			break;
		    		}
		    	}
	    	}
	    		
		}catch(Exception e){
			e.getStackTrace();
		}
    	
    	if(mav.getModel().get("result")==null)
    		return (ModelAndView) joinPoint.proceed();
    	else 
    		return mav;
    }
    

    @Around("execution(* com.egsbc..service.*Dao.*(..)) "+
    		"&& !execution(* com.egsbc..service.*Dao.get*(..)) "+
    		"&& !execution(* com.egsbc..service.*Dao.setUserStatus(..)) "+
    		"&& !execution(* com.egsbc..service.*Dao.addUserActionHistory(..))")
    public Object loggingAroundDao(ProceedingJoinPoint joinPoint) throws Throwable {
    	
    	Object retVal = null;
		
    	try{
    		
    		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
	    	name = codeSignature.toShortString();
	    	short actionResult = 0;
	    	 
	    	CustomUserDetails details =  (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
	    	retVal =  joinPoint.proceed();
	    	actionResult = ((Integer)retVal).shortValue();
	    	
	    	
	    	if(actionResult > 0){
	    		actionResult = 0;
	    	}
	    	
			// insert command history
			userService.addUserActionHistory(
					new UserActionHistoryVO(
							details.getUsername(), 
							Global.HISTORY_COMMAND, 
							codeSignature.getName(), 
							actionResult, 
							""));
	    	
    	}catch(Exception e){
			e.getStackTrace();
		}
    	
    	if(retVal==null)
    		return joinPoint.proceed();
    	else 
    		return retVal;
    }
    
}
