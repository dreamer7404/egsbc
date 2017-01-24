package com.egsbc.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.UserService;
import com.egsbc.utils.Global;

@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	@Resource(name="userService")
	private UserService userService;
 
    @Override
    public void onLogoutSuccess
      (HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
      throws IOException, ServletException {
    	
    	// set logout
    	try {
    		String id = authentication.getPrincipal().toString();
			userService.setUserStatus(new UserVO(id, Global.USER_STATUS_LOGOUT, ""));
			
			// add UserActionHistory
			CustomUserDetails details = (CustomUserDetails)authentication.getDetails();
			userService.addUserActionHistory(new UserActionHistoryVO(details.getUsername(), Global.HISTORY_LOGOUT, "logout", (short)0, ""));
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	setDefaultTargetUrl("/login");
        super.onLogoutSuccess(request, response, authentication);
    }

}
