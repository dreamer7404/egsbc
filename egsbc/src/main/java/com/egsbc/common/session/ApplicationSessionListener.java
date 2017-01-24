package com.egsbc.common.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationSessionListener implements HttpSessionListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationSessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
//		logger.info("Session Created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
//		logger.info("Session Destroyed");
	}

}
