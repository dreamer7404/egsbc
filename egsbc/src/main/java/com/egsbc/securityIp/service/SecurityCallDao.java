package com.egsbc.securityIp.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.PrimitiveConfigVO;
import com.egsbc.securityIp.GeoIpDateVO;
import com.egsbc.securityIp.GeoIpExcludeVO;
import com.egsbc.securityIp.GeoIpVO;
import com.egsbc.securityIp.SecCallOverseasVO;
import com.egsbc.securityIp.SecCallPatternVO;
import com.egsbc.securityIp.SecGeoIpVO;
import com.egsbc.securityIp.SecImSignaturesVO;
import com.egsbc.securityIp.SecImSignaturesValVO;
import com.egsbc.securityIp.SecOverviewVO;
import com.egsbc.securityIp.SecUserAgentVO;

@Repository("securityCallDao")
public class SecurityCallDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public SecOverviewVO getSecOverview() throws Exception {
		return sqlSession.selectOne("SecurityCallDao.getSecOverview");
    }
	
	public List<SecGeoIpVO> getSecGeoIp() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecGeoIp");
    }
	
	public List<PrimitiveConfigVO> getGeoIpConfig() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getGeoIpConfig");
    }
	
	
	public String getSecurityGeoIp() throws Exception {
		return sqlSession.selectOne("SecurityCallDao.getSecurityGeoIp");
    }
	
	public List<GeoIpVO> getGeoIpList() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getGeoIpList");
    }
	
	public int setGeoIp(GeoIpVO vo) throws Exception {
		return sqlSession.insert("SecurityCallDao.setGeoIp", vo);
	}
	
	public List<GeoIpDateVO> getNationCodeList(String nationCode)  throws Exception {
		return sqlSession.selectList("SecurityCallDao.getNationCodeList", nationCode);
	}
	
	public List<GeoIpExcludeVO> getSecGeoExcludeList()  throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecGeoExcludeList");
	}
	
	
	public List<SecUserAgentVO> getSecUserAgent() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecUserAgent");
    }
	
	public SecCallPatternVO getSecCallPattern() throws Exception {
		return sqlSession.selectOne("SecurityCallDao.getSecCallPattern");
    }
	
	public List<SecCallOverseasVO> getSecCallOverseas() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecCallOverseas");
    }
	
	public List<SecCallOverseasVO> getSecCallOverseasUser() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecCallOverseasUser");
    }
	
	public List<SecCallOverseasVO> getSecCallGapping() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecCallGapping");
    }
	
	public SecImSignaturesVO getSecImSignatureHdr() throws Exception {
		return sqlSession.selectOne("SecurityCallDao.getSecImSignatureHdr");
	}
	public List<SecImSignaturesValVO> getSecImSignatureVal() throws Exception {
		return sqlSession.selectList("SecurityCallDao.getSecImSignatureVal");
	}
	
}
