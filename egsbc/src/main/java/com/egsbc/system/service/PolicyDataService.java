package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.system.AlarmCodeVO;
import com.egsbc.system.PolicyCheckValidityVO;
import com.egsbc.system.PolicyDataBackupVO;
import com.egsbc.system.PolicyDataDeleteVO;

@Service("policyDataService")
public class PolicyDataService {
	
	@Resource(name="policyDataDao")
	private PolicyDataDao policyDataDao;
	
	
	public PolicyDataBackupVO getPolicyDataBackup() throws Exception {
		return policyDataDao.getPolicyDataBackup();
	}
	
	public int setPolicyDataBackup(PolicyDataBackupVO vo) throws Exception {
		return policyDataDao.setPolicyDataBackup(vo);
	}
	
	
	public PolicyDataDeleteVO getPolicyDataDelete() throws Exception {
		return policyDataDao.getPolicyDataDelete();
	}
	public int setPolicyDataDelete(PolicyDataDeleteVO vo) throws Exception {
		return policyDataDao.setPolicyDataDelete(vo);
	}
	public int setPolicyFileDelete(PolicyDataDeleteVO vo) throws Exception {
		return policyDataDao.setPolicyFileDelete(vo);
	}
	
	public PolicyCheckValidityVO getPolicyCheckValidity() throws Exception {
		return policyDataDao.getPolicyCheckValidity();
	}
	
	public int setPolicyCheckValidity(PolicyCheckValidityVO vo) throws Exception {
		return policyDataDao.setPolicyCheckValidity(vo);
	}
}
