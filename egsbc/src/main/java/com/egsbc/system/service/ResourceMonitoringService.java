package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.system.AlarmCodeChangeVO;
import com.egsbc.system.AlarmCodeVO;

@Service("resourceMonitoringService")
public class ResourceMonitoringService {
	
	@Resource(name="resourceMonitoringDao")
	private ResourceMonitoringDao resourceMonitoringDao;
	
	
	public List<AlarmCodeVO> getResourceMonitoring() throws Exception {
		return resourceMonitoringDao.getResourceMonitoring();
	}
	
	public int chgResourceMonitoring(AlarmCodeChangeVO vo) throws Exception {
		return resourceMonitoringDao.chgResourceMonitoring(vo);
	}
	
}
