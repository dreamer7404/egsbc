package com.egsbc.main.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;



@Service("mainService")
public class MainService {
	
	@Resource(name="mainDao")
	private MainDao mainDao;
	

}
