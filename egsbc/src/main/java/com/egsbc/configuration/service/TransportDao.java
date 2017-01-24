package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.TransportVO;

@Repository("transportDao")
public class TransportDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<TransportVO> getSipTransport() throws Exception {
		return sqlSession.selectList("TransportDao.getSipTransport");
    }
	public List<TransportVO> getMediaTransport() throws Exception {
		return sqlSession.selectList("TransportDao.getMediaTransport");
    }
	public List<TransportVO> getNatTransport() throws Exception {
		return sqlSession.selectList("TransportDao.getNatTransport");
    }
	
	public List<String> getMediaTransportName() throws Exception {
    	return sqlSession.selectList("TransportDao.getMediaTransportName");
    }
	public List<String> getSipTransportName(int svcType) throws Exception {
    	return sqlSession.selectList("TransportDao.getSipTransportName", svcType);
    } 
}
