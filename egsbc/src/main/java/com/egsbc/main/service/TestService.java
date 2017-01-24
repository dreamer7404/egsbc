package com.egsbc.main.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



@Service("testService")
public class TestService {
	
	@Resource(name="testDao")
	private TestDao testDao;
	

	public List<HashMap<String, Object>> getTest(String sql) throws Exception {
		return testDao.getTest(sql);
	}
}
