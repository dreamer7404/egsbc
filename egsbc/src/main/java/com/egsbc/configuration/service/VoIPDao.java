package com.egsbc.configuration.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.SipRealmGroupVO;
import com.egsbc.configuration.SipRealmVO;
import com.egsbc.configuration.SipServerGroupVO;
import com.egsbc.configuration.SipServerVO;
import com.egsbc.configuration.SipServiceRuleVO;
import com.egsbc.configuration.SipServiceVO;
import com.egsbc.configuration.SipTrunkGroupVO;
import com.egsbc.configuration.SipTrunkVO;

@Repository("voIPDao")
public class VoIPDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<String> getSipServiceName() throws Exception {
		return sqlSession.selectList("VoIPDao.getSipServiceName");
    }
	public List<SipServiceRuleVO> getSipServiceRule(SipServiceRuleVO vo) throws Exception {
		return sqlSession.selectList("VoIPDao.getSipServiceRule", vo);
    } 
	public List<SipServiceVO> getSipService(SipServiceVO vo) throws Exception {
		return sqlSession.selectList("VoIPDao.getSipService", vo);
    } 
	
	
	
	public List<SipServiceVO> getSipServiceSourceTargetGroup() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipServiceSourceTargetGroup");
    }
	
	public List<SipRealmVO> getSipRealm() throws Exception {
		return sqlSession.selectList("VoIPDao.getSipRealm");
    }
	public List<String> getSipRealmNameList(int elemType) throws Exception {
    	return sqlSession.selectList("VoIPDao.getSipRealmNameList", elemType);
    }
    
    public List<SipRealmGroupVO> getSipRealmGroup() throws Exception {
		return sqlSession.selectList("VoIPDao.getSipRealmGroup");
    }
    public List<String> getSipRealmGroupNameList() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipRealmGroupNameList");
    }
    
    public List<SipServerVO> getSipServer() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipServer");
    } 
    public List<String> getSipServerNameList(int elemType) throws Exception {
    	return sqlSession.selectList("VoIPDao.getSipServerNameList", elemType);
    }
    
    public List<SipServerGroupVO> getSipServerGroup() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipServerGroup");
    }
    public List<String> getSipServerGroupNameList() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipServerGroupNameList");
    }
    
   
    public List<SipTrunkVO> getSipTrunk() throws Exception {
		return sqlSession.selectList("VoIPDao.getSipTrunk");
    }
    public List<SipTrunkGroupVO> getSipTrunkGroup() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipTrunkGroup");
    }
    public List<String> getSipTrunkNameList() throws Exception {
    	return sqlSession.selectList("VoIPDao.getSipTrunkNameList");
    }
    
    //=========================== easy ============================================
    
    public List<SipRealmVO> getSipRealmByGroupByService() throws Exception {
		return sqlSession.selectList("VoIPDao.getSipRealmByGroupByService");
    }
    public List<SipServerVO> getSipServerByGroupByService() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipServerByGroupByService");
      }
    
    
    public List<SipTrunkVO> getSipTrunkRGroupByGroupByService() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipTrunkRGroupByGroupByService");
      }
    public List<SipTrunkVO> getSipTrunkLGroupByGroupByService() throws Exception {
  		return sqlSession.selectList("VoIPDao.getSipTrunkLGroupByGroupByService");
      }
    public SipTrunkVO getSipTrunkByElem1(String name) throws Exception {
  		return sqlSession.selectOne("VoIPDao.getSipTrunkByElem1", name);
      }
    
   
}
