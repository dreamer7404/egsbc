package com.egsbc.configuration.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.egsbc.configuration.EasyConfigurationVO;
import com.egsbc.configuration.SipRealmGroupVO;
import com.egsbc.configuration.SipRealmVO;
import com.egsbc.configuration.SipServerGroupVO;
import com.egsbc.configuration.SipServerVO;
import com.egsbc.configuration.SipServiceRuleVO;
import com.egsbc.configuration.SipServiceVO;
import com.egsbc.configuration.SipTrunkGroupVO;
import com.egsbc.configuration.SipTrunkVO;
import com.egsbc.utils.Bytes;

@Service("voIPService")
public class VoIPService {

	@Resource(name="voIPDao")
	private VoIPDao voIPDao;
	
	public List<SipServiceVO> getSipService(SipServiceVO vo) throws Exception {
		return voIPDao.getSipService(vo);
	}
	public List<SipServiceRuleVO> getSipServiceRule(SipServiceRuleVO vo) throws Exception {
		return voIPDao.getSipServiceRule(vo);
	}
	

	public List<String> getSipServiceName() throws Exception {
		return voIPDao.getSipServiceName();
	}

	public List<SipRealmVO> getSipRealm() throws Exception {
		return voIPDao.getSipRealm();
	}
	public List<String> getSipRealmNameList(int elemType) throws Exception {
		return voIPDao.getSipRealmNameList(elemType);
    }
	
	

	public List<SipRealmGroupVO> getSipRealmGroup() throws Exception {
		return voIPDao.getSipRealmGroup();
	}
	public List<String> getSipRealmGroupNameList() throws Exception {
		return voIPDao.getSipRealmGroupNameList();
	}

	public List<SipServerVO> getSipServer() throws Exception {
		return voIPDao.getSipServer();
	}
	public List<String> getSipServerNameList(int elemType) throws Exception {
		return voIPDao.getSipServerNameList(elemType);
    }
	 public List<String> getSipServerGroupNameList() throws Exception {
		 return voIPDao.getSipServerGroupNameList();
	 }
	 

	public List<SipServerGroupVO> getSipServerGroup() throws Exception {
		List<SipServerGroupVO> groupList = voIPDao.getSipServerGroup();  
		
		List<SipServerVO> serverList = voIPDao.getSipServer();
		
		SipServerVO serverVO = null;
		
		for(int i=0; i< groupList.size(); i++){
			SipServerGroupVO groupVO = groupList.get(i); 

			serverVO = getServerVO(serverList, groupVO.getElem0());
			if(serverVO != null){
				groupVO.setPollingStatus0(serverVO.getPollingStatus());
				groupVO.setPollingTime0(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem1());
			if(serverVO != null){
				groupVO.setPollingStatus1(serverVO.getPollingStatus());
				groupVO.setPollingTime1(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem2());
			if(serverVO != null){
				groupVO.setPollingStatus2(serverVO.getPollingStatus());
				groupVO.setPollingTime2(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem3());
			if(serverVO != null){
				groupVO.setPollingStatus3(serverVO.getPollingStatus());
				groupVO.setPollingTime3(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem4());
			if(serverVO != null){
				groupVO.setPollingStatus4(serverVO.getPollingStatus());
				groupVO.setPollingTime4(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem5());
			if(serverVO != null){
				groupVO.setPollingStatus5(serverVO.getPollingStatus());
				groupVO.setPollingTime5(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem6());
			if(serverVO != null){
				groupVO.setPollingStatus6(serverVO.getPollingStatus());
				groupVO.setPollingTime6(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem7());
			if(serverVO != null){
				groupVO.setPollingStatus7(serverVO.getPollingStatus());
				groupVO.setPollingTime7(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem8());
			if(serverVO != null){
				groupVO.setPollingStatus8(serverVO.getPollingStatus());
				groupVO.setPollingTime8(serverVO.getPollingTime());
			}
			serverVO = getServerVO(serverList, groupVO.getElem9());
			if(serverVO != null){
				groupVO.setPollingStatus9(serverVO.getPollingStatus());
				groupVO.setPollingTime9(serverVO.getPollingTime());
			}
		}
		return voIPDao.getSipServerGroup();
	}
	private SipServerVO getServerVO(List<SipServerVO> serverList, String groupElem){
		 for(SipServerVO vo : serverList){
			 if(vo.getName().equals(groupElem)){
				 return vo;
			 }
		 }
		 return null;
	 }
	
	 public List<SipTrunkVO> getSipTrunk() throws Exception {
		 return voIPDao.getSipTrunk();
	 }
	 
	 public List<SipTrunkGroupVO> getSipTrunkGroup() throws Exception{
		 
		List<SipTrunkGroupVO> groupList = voIPDao.getSipTrunkGroup();  // TrunkGroupVO 가져오기
		
		List<SipTrunkVO> trunkList = voIPDao.getSipTrunk(); // TrunkVO 가져오기
		
		SipTrunkVO trunkVO = null;
		
		for(int i=0; i< groupList.size(); i++){
			SipTrunkGroupVO groupVO = groupList.get(i); 

			trunkVO = getTrunkVO(trunkList, groupVO.getElem0());
			if(trunkVO != null){
				groupVO.setPollingStatus0(trunkVO.getPollingStatus());
				groupVO.setPollingTime0(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem1());
			if(trunkVO != null){
				groupVO.setPollingStatus1(trunkVO.getPollingStatus());
				groupVO.setPollingTime1(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem2());
			if(trunkVO != null){
				groupVO.setPollingStatus2(trunkVO.getPollingStatus());
				groupVO.setPollingTime2(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem3());
			if(trunkVO != null){
				groupVO.setPollingStatus3(trunkVO.getPollingStatus());
				groupVO.setPollingTime3(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem4());
			if(trunkVO != null){
				groupVO.setPollingStatus4(trunkVO.getPollingStatus());
				groupVO.setPollingTime4(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem5());
			if(trunkVO != null){
				groupVO.setPollingStatus5(trunkVO.getPollingStatus());
				groupVO.setPollingTime5(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem6());
			if(trunkVO != null){
				groupVO.setPollingStatus6(trunkVO.getPollingStatus());
				groupVO.setPollingTime6(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem7());
			if(trunkVO != null){
				groupVO.setPollingStatus7(trunkVO.getPollingStatus());
				groupVO.setPollingTime7(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem8());
			if(trunkVO != null){
				groupVO.setPollingStatus8(trunkVO.getPollingStatus());
				groupVO.setPollingTime8(trunkVO.getPollingTime());
			}
			trunkVO = getTrunkVO(trunkList, groupVO.getElem9());
			if(trunkVO != null){
				groupVO.setPollingStatus9(trunkVO.getPollingStatus());
				groupVO.setPollingTime9(trunkVO.getPollingTime());
			}
			
		}
		 
		 return groupList;
	 }
	 
	 private SipTrunkVO getTrunkVO(List<SipTrunkVO> trunkList, String groupElem){
		 for(SipTrunkVO vo : trunkList){
			 if(vo.getName().equals(groupElem)){
				 return vo;
			 }
		 }
		 return null;
	 }
	 
	 public List<String> getSipTrunkNameList() throws Exception {
		 return voIPDao.getSipTrunkNameList();
	 }
		 
	

	
	@SuppressWarnings("rawtypes")
	public List[]  getSipServiceSourceTargetGroup() throws Exception {
		 
		List<SipServiceVO> list = voIPDao.getSipServiceSourceTargetGroup();
		List<String> sourceList = new ArrayList<String>();
		List<String> targetList = new ArrayList<String>();
		
		
		for(SipServiceVO vo : list){
			String[] arrSource = vo.getSourceGroup().split(",");
			for(int i=0; i<arrSource.length; i++){
				if(!hasValue(sourceList, arrSource[i]) && StringUtils.isNotBlank(arrSource[i])){
					sourceList.add(arrSource[i]);
				}
			}
			
			String[] arrTarget = vo.getTargetGroup().split(",");
			for(int i=0; i<arrTarget.length; i++){
				if(!hasValue(targetList, arrTarget[i]) && StringUtils.isNotBlank(arrTarget[i])){
					targetList.add(arrTarget[i]);
				}
			}
		}
		
		 return new List[] { sourceList, targetList };

	}
	
	private boolean hasValue(List<String> list, String compareValue){
		for(String s : list){
			if(s.equals(compareValue)){
				return true;
			}
		}
		return false;
	}
	
	
	//====================== easy ========================================
	 public List<SipRealmVO> getSipRealmByGroupByService() throws Exception {
		 return voIPDao.getSipRealmByGroupByService();
	 }
	 
	 public List<SipServerVO> getSipServerByGroupByService() throws Exception {
		 return voIPDao.getSipServerByGroupByService();
	 }
	
	public List<SipTrunkVO> getSipTrunkRGroupByGroupByService() throws Exception {
	   return voIPDao.getSipTrunkRGroupByGroupByService();
    }
    public List<SipTrunkVO> getSipTrunkLGroupByGroupByService() throws Exception {
    	 return voIPDao.getSipTrunkLGroupByGroupByService();
    }
    
    public SipTrunkVO getSipTrunkByElem1(String name) throws Exception {
    	return voIPDao.getSipTrunkByElem1(name);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * create Routing
	 */
	public byte[] createRouting(SipServiceRuleVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getIdx());
			list.add(vo.getServiceName());
			list.add(vo.getRuleType());
			list.add(vo.getRule());
			list.add(vo.getReferField());
			list.add(vo.getSourceGroup());
			list.add(vo.getTargetGroup());
			list.add(vo.getReverseFlag());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	/*
	 * create Realm
	 */
	public byte[] createRealm(SipRealmVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getElemType());
			list.add(vo.getDomain());
			list.add(vo.getGroupName());
			list.add(vo.getSigTransName());
			list.add(vo.getMediaTransName());
			list.add(vo.getMediaPassFlag());
			list.add(vo.getSrtpFlag());
			list.add(vo.getRegPeriod());
			list.add(vo.getRegPeriodNat());
			list.add(vo.getRegPeriodBypass());
			list.add(vo.getSessionFlag());
			list.add(vo.getSessionExpires());
			list.add(vo.getSessionMinse());
			list.add(vo.getDeregDeactFlag());
			list.add(vo.getEndPointType());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * create RealmGroup
	 */
	public byte[] createRealmGroup(SipRealmGroupVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getServiceName());
			list.add(vo.getElem0());
			list.add(vo.getElem1());
			list.add(vo.getElem2());
			list.add(vo.getElem3());
			list.add(vo.getElem4());
			list.add(vo.getElem5());
			list.add(vo.getElem6());
			list.add(vo.getElem7());
			list.add(vo.getElem8());
			list.add(vo.getElem9());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * create Server
	 */
	public byte[] createServer(SipServerVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getElemType());
			list.add(vo.getDomain());
			list.add(vo.getGroupName());
			list.add(vo.getServerIPType());
			list.add(vo.getServerIP());
			list.add(vo.getServerPort());
			list.add(vo.getSigTransName());
			list.add(vo.getMediaTransName());
			list.add(vo.getSrtpFlag());
			list.add(vo.getRegPeriod());
			list.add(vo.getMaxCps());
			list.add(vo.getMaxSession());
			list.add(vo.getMaxRps());
			list.add(vo.getPollingStatus());
			list.add(vo.getPollingTime());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * create ServerGroup
	 */
	public byte[] createServerGroup(SipServerGroupVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getServiceName());
			list.add(vo.getOpModeServerGroup());
			list.add(vo.getPollFlag());
			list.add(vo.getElem0());
			list.add(vo.getElem1());
			list.add(vo.getElem2());
			list.add(vo.getElem3());
			list.add(vo.getElem4());
			list.add(vo.getElem5());
			list.add(vo.getElem6());
			list.add(vo.getElem7());
			list.add(vo.getElem8());
			list.add(vo.getElem9());
			list.add(vo.getActivateElemName());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * create Service
	 */
	public byte[] createService(SipServiceVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getMode());
			list.add(vo.getlGroup0());
			list.add(vo.getlGroup1());
			list.add(vo.getlGroup2());
			list.add(vo.getlGroup3());
			list.add(vo.getlGroup4());
			list.add(vo.getlGroup5());
			list.add(vo.getlGroup6());
			list.add(vo.getlGroup7());
			list.add(vo.getlGroup8());
			list.add(vo.getlGroup9());
			
			list.add(vo.getrGroup0());
			list.add(vo.getrGroup1());
			list.add(vo.getrGroup2());
			list.add(vo.getrGroup3());
			list.add(vo.getrGroup4());
			list.add(vo.getrGroup5());
			list.add(vo.getrGroup6());
			list.add(vo.getrGroup7());
			list.add(vo.getrGroup8());
			list.add(vo.getrGroup9());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * create Trunk
	 */
	public byte[] createTrunk(SipTrunkVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getElemType());
			list.add(vo.getDomain());
			list.add(vo.getGroupName());
			list.add(vo.getPeerIpType());
			list.add(vo.getPeerIp());
			list.add(vo.getPeerPort());
			list.add(vo.getSigTransName());
			list.add(vo.getMediaTransName());
			list.add(vo.getMediaPassFlag());
			list.add(vo.getSrtpFlag());
			list.add(vo.getRegPeriod());
			list.add(vo.getRegisterFlag());
			list.add(vo.getRegisterUserId());
			list.add(vo.getRegisterDomain());
			list.add(vo.getRegisterAuthId());
			list.add(vo.getRegisterAuthPw());
			list.add(vo.getPolicySpamFlag());
			list.add(vo.getMaxCps());
			list.add(vo.getMaxSession());
			list.add(vo.getPollingStatus());
			list.add(vo.getPollingTime());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * create TrunkGroup
	 */
	public byte[] createTrunkGroup(SipTrunkGroupVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getServiceName());
			list.add(vo.getOpModeTrunkGroup());
			list.add(vo.getPollFlag());
			list.add(vo.getPollResFlag());
			list.add(vo.getElem0());
			list.add(vo.getElem1());
			list.add(vo.getElem2());
			list.add(vo.getElem3());
			list.add(vo.getElem4());
			list.add(vo.getElem5());
			list.add(vo.getElem6());
			list.add(vo.getElem7());
			list.add(vo.getElem8());
			list.add(vo.getElem9());
			list.add(vo.getActivateElemName());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	
	/*
	 * create RealmServer
	 */
	public byte[] createRealmServer(EasyConfigurationVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			// Realm
			list.add(vo.getRlmName());
			list.add(vo.getRlmElemType());
			list.add(vo.getRlmDomain());
			list.add(vo.getRlmGroupName());
			list.add(vo.getRlmSigTransName());
			list.add(vo.getRlmMediaTransName());
			list.add(vo.getRlmMediaPassFlag());
			list.add(vo.getRlmSrtpFlag());
			list.add(vo.getRlmRegPeriod());
			list.add(vo.getRlmRegPeriodNat());
			list.add(vo.getRlmRegPeriodBypass());
			list.add(vo.getRlmSessionFlag());
			list.add(vo.getRlmSessionExpires());
			list.add(vo.getRlmSessionMinse());
			list.add(vo.getRlmDeregDeactFlag());
			list.add(vo.getRlmEndPointType());
			
			// server
			list.add(vo.getSvrName());
			list.add(vo.getSvrElemType());
			list.add(vo.getSvrDomain());
			list.add(vo.getSvrGroupName());
			list.add(vo.getSvrServerIPType());
			list.add(vo.getSvrServerIP());
			list.add(vo.getSvrServerPort());
			list.add(vo.getSvrSigTransName());
			list.add(vo.getSvrMediaTransName());
			list.add(vo.getSvrSrtpFlag());
			list.add(vo.getSvrRegPeriod());
			list.add(vo.getSvrMaxCps());
			list.add(vo.getSvrMaxSession());
			list.add(vo.getSvrMaxRps());
			list.add(vo.getSvrPollingStatus());
			list.add(vo.getSvrPollingTime());
			
			// 추가
			list.add(vo.getDummyIndex());
			list.add(vo.getSvrPollFlag());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	/*
	 * create Trunking
	 */
	public byte[] createTrunking(EasyConfigurationVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			// Realm
			list.add(vo.getRlmName());
			list.add(vo.getRlmElemType());
			list.add(vo.getRlmDomain());
			list.add(vo.getRlmGroupName());
			list.add(vo.getRlmPeerIpType());
			list.add(vo.getRlmPeerIp());
			list.add(vo.getRlmPeerPort());
			list.add(vo.getRlmSigTransName());
			list.add(vo.getRlmMediaTransName());
			list.add(vo.getRlmMediaPassFlag());
			list.add(vo.getRlmSrtpFlag());
			list.add(vo.getRlmRegPeriod());
			list.add(vo.getRlmRegisterFlag());
			list.add(vo.getRlmRegisterUserId());
			list.add(vo.getRlmRegisterDomain());
			list.add(vo.getRlmRegisterAuthId());
			list.add(vo.getRlmRegisterAuthPw());
			list.add(vo.getRlmPolicySpamFlag());
			list.add(vo.getRlmMaxCps());
			list.add(vo.getRlmMaxSession());
			list.add(vo.getRlmPollingStatus());
			list.add(vo.getRlmPollingTime());
			
			
			// server T_ELEM0
			list.add(vo.getSvrName());
			list.add(vo.getSvrElemType());
			list.add(vo.getSvrDomain());
			list.add(vo.getSvrGroupName());
			list.add(vo.getSvrPeerIpType());
			list.add(vo.getSvrPeerIp());
			list.add(vo.getSvrPeerPort());
			list.add(vo.getSvrSigTransName());
			list.add(vo.getSvrMediaTransName());
			list.add(vo.getSvrMediaPassFlag());
			list.add(vo.getSvrSrtpFlag());
			list.add(vo.getSvrRegPeriod());
			list.add(vo.getSvrRegisterFlag());
			list.add(vo.getSvrRegisterUserId());
			list.add(vo.getSvrRegisterDomain());
			list.add(vo.getSvrRegisterAuthId());
			list.add(vo.getSvrRegisterAuthPw());
			list.add(vo.getSvrPolicySpamFlag());
			list.add(vo.getSvrMaxCps());
			list.add(vo.getSvrMaxSession());
			list.add(vo.getSvrPollingStatus());
			list.add(vo.getSvrPollingTime());
			
			// server T_ELEM1
			list.add(vo.getSvrName());
			list.add(vo.getSvrElemType());
			list.add(vo.getSvrDomain());
			list.add(vo.getSvrGroupName());
			list.add(vo.getSvrPeerIpType());
			list.add(vo.getSvrPeerIp2()); // T_ELEM1  2개외 나머지는 상관없음.
			list.add(vo.getSvrPeerPort2()); // T_ELEM1  2개외 나머지는 상관없음.
			list.add(vo.getSvrSigTransName());
			list.add(vo.getSvrMediaTransName());
			list.add(vo.getSvrMediaPassFlag());
			list.add(vo.getSvrSrtpFlag());
			list.add(vo.getSvrRegPeriod());
			list.add(vo.getSvrRegisterFlag());
			list.add(vo.getSvrRegisterUserId());
			list.add(vo.getSvrRegisterDomain());
			list.add(vo.getSvrRegisterAuthId());
			list.add(vo.getSvrRegisterAuthPw());
			list.add(vo.getSvrPolicySpamFlag());
			list.add(vo.getSvrMaxCps());
			list.add(vo.getSvrMaxSession());
			list.add(vo.getSvrPollingStatus());
			list.add(vo.getSvrPollingTime());
			
			// 추가
			list.add(vo.getDummyIndex());
			list.add(vo.getSvrPollFlag());
			list.add(vo.getSvrSelfResponseFlag());
			
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}		
	
}
