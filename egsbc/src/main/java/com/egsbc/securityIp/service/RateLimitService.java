package com.egsbc.securityIp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.securityIp.RateLimitVO;

@Service("rateLimitService")
public class RateLimitService {

	@Resource(name="rateLimitDao")
	private RateLimitDao rateLimitDao;
	
	
	public List<RateLimitVO> getRateLimit() throws Exception {
		return rateLimitDao.getRateLimit();
	}
	
	public int setRateLimit(RateLimitVO vo) throws Exception {
		return rateLimitDao.setRateLimit(vo);
	}
	
}
