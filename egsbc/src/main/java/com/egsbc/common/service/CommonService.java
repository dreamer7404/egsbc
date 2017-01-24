package com.egsbc.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service("commonService")
public class CommonService {
	
	public List<String> setErrorList(int errorCode, String errorMsg) throws Exception {
		List<String> list = new ArrayList<String>();
		
		list.add(String.valueOf(errorCode));
		list.add(errorMsg);
		
		return list;
	}
}
