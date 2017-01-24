package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.NatServiceVO;

@Repository("natServiceDao")
public class NatServiceDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<NatServiceVO> getNatService() throws Exception {
		return sqlSession.selectList("NatServiceDao.getNatService");
    }
}
