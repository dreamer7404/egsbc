package com.egsbc.main.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("testDao")
public class TestDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<HashMap<String, Object>> getTest(String sql) throws Exception {
		return sqlSession.selectList("TestDao.getTest", sql);
    }
	
}
