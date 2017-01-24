package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.SipConfigCertificationVO;
import com.egsbc.configuration.TlsCertFileInfoVO;
import com.egsbc.configuration.TlsConfigVO;

@Repository("certificationDao")
public class CertificationDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<TlsConfigVO> getTlsConfig() throws Exception {
		return sqlSession.selectList("CertificationDao.getTlsConfig");
    }
	
	public List<TlsCertFileInfoVO> getTlsCertFileInfo() throws Exception {
		return sqlSession.selectList("CertificationDao.getTlsCertFileInfo");
    }
	
	public TlsCertFileInfoVO getTlsCertFileInfoApplied () throws Exception {
		return sqlSession.selectOne("CertificationDao.getTlsCertFileInfoApplied");
	}
	
	
	public List<SipConfigCertificationVO> getSipConfigCertification() throws Exception {
		return sqlSession.selectList("CertificationDao.getSipConfigCertification");
    }
	
}
