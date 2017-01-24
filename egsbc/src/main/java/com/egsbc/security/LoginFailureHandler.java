package com.egsbc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.egsbc.main.web.MainController;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		
		 logger.debug("로그인에 실패하였습니다.");
	        HttpSession session=request.getSession();
	        int cnt=0;
	        if(session!=null){
	            Object o=session.getAttribute("BadCredentialsCnt");
	            if(o!=null)cnt=(Integer)o;
	        }
	         
	        session.setAttribute("BadCredentialsCnt", ++cnt);
	        logger.debug("{}회 로그인에 실패하였습니다.", cnt);
	         
	        // 접속 실패 로그인 포워딩
	        response.sendRedirect(request.getContextPath()+"/login");
	         
	        // 3회 실패시 
	        if(cnt>=3){
	            // DB 처리
	             
	        }


	}

}
