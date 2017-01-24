package com.egsbc.security;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.context.SecurityContextHolder;

import com.egsbc.system.UserVO;
import com.egsbc.system.service.UserDao;

public class CustomFilter implements Filter {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private String ajaxHeader = "AJAX";

	public String getAjaxHeader() {
		return ajaxHeader;
	}

	public void setAjaxHeader(String ajaxHeader) {
		this.ajaxHeader = ajaxHeader;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse res = (HttpServletResponse) response;
	     
	     
	     
//	     String header = req.getHeader("X-Ajax-call");
//	     
//	     if(header != null){
//	    	 if(header.equals("true")){
//	    		 chain.doFilter(req, res);
//	    	 }else{
//	    		//res.sendError(HttpServletResponse.SC_UNAUTHORIZED); // 401 unauthorized
//	    		 res.sendError(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
//	    		 //res.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 Not found
//	    		 //res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 Internal Server Error
//	    	 }
//	     }else{
//	    	 chain.doFilter(req, res);
//	     }
		
	//	if (isAjaxRequest(req)) {
	     
	     
            try {
                   chain.doFilter(req, res);
            } catch (AccessDeniedException e) {
                   res.sendError(HttpServletResponse.SC_FORBIDDEN); // 403
            } catch (AuthenticationException e) {
                   res.sendError(HttpServletResponse.SC_UNAUTHORIZED); // 401
            }
	     
	     
	 //   } else {
	//            chain.doFilter(req, res);
	 //   }
	}
	

	private boolean isAjaxRequest(HttpServletRequest req) {
		return req.getHeader(ajaxHeader) != null && req.getHeader(ajaxHeader).equals(Boolean.TRUE.toString());
	}
}
