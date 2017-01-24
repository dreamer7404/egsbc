package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.system.AlarmCodeChangeVO;
import com.egsbc.system.AlarmCodeVO;

@Repository("resourceMonitoringDao")
public class ResourceMonitoringDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public List<AlarmCodeVO> getResourceMonitoring() throws Exception {
		return sqlSession.selectList("ResourceMonitoringDao.getResourceMonitoring");
    }
	
	public int chgResourceMonitoring(AlarmCodeChangeVO vo) throws Exception {
		return sqlSession.update("ResourceMonitoringDao.chgResourceMonitoring", vo);
    }
	
	
}
