package com.egsbc.security;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.util.Assert;

public class URLAuthorizeProcessor implements BeanPostProcessor, InitializingBean {
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(securityMetadataSource,"securityMetadataSource cannot be null");

	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		 if (bean instanceof FilterSecurityInterceptor) {
	            ((FilterSecurityInterceptor)bean).setSecurityMetadataSource(securityMetadataSource);
	        }
	        return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
	public void setProgramURLSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    } 


}
