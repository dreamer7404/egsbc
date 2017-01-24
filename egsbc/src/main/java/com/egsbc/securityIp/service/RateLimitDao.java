package com.egsbc.securityIp.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.securityIp.RateLimitVO;

@Repository("rateLimitDao")
public class RateLimitDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public List<RateLimitVO> getRateLimit() throws Exception {
		return sqlSession.selectList("RateLimitDao.getRateLimit");
    }
	
	public int setRateLimit(RateLimitVO vo) throws Exception {
		return sqlSession.update("RateLimitDao.setRateLimit", vo);
	}
	
}
