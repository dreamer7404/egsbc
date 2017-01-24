package com.egsbc.main.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.main.LocalInfoVO;

@Repository("localInfoDao")
public class LocalInfoDao {
	
	@Resource(name="sqlSession3")
	private SqlSession sqlSession3;
	
	public LocalInfoVO getDupInfo() throws Exception {
		return sqlSession3.selectOne("LocalInfoDao.getDupInfo");
    }
	
}
