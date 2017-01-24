package com.egsbc.main.service;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.egsbc.main.LocalInfoVO;



@Service("localInfoService")
public class LocalInfoService {
	
	@Resource(name="localInfoDao")
	private LocalInfoDao localInfoDao;
	

	public LocalInfoVO getDupInfo() throws Exception {
		return localInfoDao.getDupInfo();
	}
}
