package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.SipConfigExtVO;
import com.egsbc.configuration.SipConfigServiceVO;
import com.egsbc.configuration.SipConfigStackVO;
import com.egsbc.configuration.SipConfigTimerVO;


@Repository("advancedSipDao")
public class AdvancedSipDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<SipConfigStackVO> getSipConfigStack() throws Exception {
		return sqlSession.selectList("AdvancedSipDao.getSipConfigStack");
    } 
	
	public List<SipConfigTimerVO> getSipConfigTimer() throws Exception {
		return sqlSession.selectList("AdvancedSipDao.getSipConfigTimer");
    } // 
	
	public List<SipConfigServiceVO> getSipConfigService() throws Exception {
		return sqlSession.selectList("AdvancedSipDao.getSipConfigService");
    }
	
	public List<SipConfigExtVO> getSipConfigExt() throws Exception {
		return sqlSession.selectList("AdvancedSipDao.getSipConfigExt");
    }
}
