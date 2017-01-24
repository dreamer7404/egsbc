package com.egsbc.main.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("mainDao")
public class MainDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
}
