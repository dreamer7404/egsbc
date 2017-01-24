package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.system.PrimitiveSysDupVO;
import com.egsbc.system.PrimitiveSysProcessVO;

@Repository("controlDao")
public class ControlDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
//	public List<PrimitiveSysDupVO> getPrimitiveSysDup(short side) throws Exception {
//		return sqlSession.selectList("ControlDao.getPrimitiveSysDup", side);
//    }
	
	public List<PrimitiveSysProcessVO> getPrimitiveSysProcess() throws Exception {
		return sqlSession.selectList("ControlDao.getPrimitiveSysProcess");
    }
	
}
