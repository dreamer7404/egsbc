package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.StaticACLVO;

@Repository("staticACLDao")
public class StaticACLDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<StaticACLVO> getStaticACL(int usageACL) throws Exception {
		return sqlSession.selectList("StaticACLDao.getStaticACL", usageACL);
    }
	
	public String getPrimitiveConfig(String argString) throws Exception {
		return sqlSession.selectOne("StaticACLDao.getPrimitiveConfig", argString);
    }
}
