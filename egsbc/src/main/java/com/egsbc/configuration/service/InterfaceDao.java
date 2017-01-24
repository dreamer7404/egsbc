package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.PrimitiveNwIntfVO;


@Repository("interfaceDao")
public class InterfaceDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<PrimitiveNwIntfVO> getInterface() throws Exception {
		return sqlSession.selectList("InterfaceDao.getInterface");
    }
	
	public List<String> getInterfaceNameList() throws Exception {
		return sqlSession.selectList("InterfaceDao.getInterfaceNameList");
    }
	public List<PrimitiveNwIntfVO> getInterfaceAliasList() throws Exception {
		return sqlSession.selectList("InterfaceDao.getInterfaceAliasList");
    }
	public List<String> getInterfaceNameListForAdd() throws Exception {
		return sqlSession.selectList("InterfaceDao.getInterfaceNameListForAdd");
    }
	
	public List<String> getInterfaceAliasForNat() throws Exception {
		return sqlSession.selectList("InterfaceDao.getInterfaceAliasForNat");
    }
}
