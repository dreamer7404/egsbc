package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.system.PolicyCheckValidityVO;
import com.egsbc.system.PolicyDataBackupVO;
import com.egsbc.system.PolicyDataDeleteVO;

@Repository("policyDataDao")
public class PolicyDataDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public PolicyDataBackupVO getPolicyDataBackup() throws Exception {
		return sqlSession.selectOne("PolicyDataDao.getPolicyDataBackup");
    }
	
	public int setPolicyDataBackup(PolicyDataBackupVO vo) throws Exception {
		return sqlSession.update("PolicyDataDao.setDataBackup", vo);
	}
	
	
	public PolicyDataDeleteVO getPolicyDataDelete() throws Exception {
		return sqlSession.selectOne("PolicyDataDao.getPolicyDataDelete");
	}
	public int setPolicyDataDelete(PolicyDataDeleteVO vo) throws Exception {
		return sqlSession.update("PolicyDataDao.setPolicyDataDelete", vo);
	}
	public int setPolicyFileDelete(PolicyDataDeleteVO vo) throws Exception {
		return sqlSession.update("PolicyDataDao.setPolicyFileDelete", vo);
	}
	
	public PolicyCheckValidityVO getPolicyCheckValidity() throws Exception {
		return sqlSession.selectOne("PolicyDataDao.getPolicyCheckValidity");
	}
	public int setPolicyCheckValidity(PolicyCheckValidityVO vo) throws Exception {
		return sqlSession.update("PolicyDataDao.setPolicyCheckValidity", vo);
	}
}
