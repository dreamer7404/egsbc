package com.egsbc.securityIp.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.securityIp.SecSpamCallVO;
import com.egsbc.securityIp.SecSpamImVO;
import com.egsbc.securityIp.SecSpamVO;

@Repository("securitySpamDao")
public class SecuritySpamDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public SecSpamVO getSecSpam() throws Exception {
		return sqlSession.selectOne("SecuritySpamDao.getSecSpam");
    }
	
	public SecSpamCallVO getSecSpamCall() throws Exception {
		return sqlSession.selectOne("SecuritySpamDao.getSecSpamCall");
    }
	
	public SecSpamImVO getSecSpamIm() throws Exception {
		return sqlSession.selectOne("SecuritySpamDao.getSecSpamIm");
    }
	
	
	
}
