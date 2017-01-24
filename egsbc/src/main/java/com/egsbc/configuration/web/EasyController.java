package com.egsbc.configuration.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.EasyConfigurationVO;
import com.egsbc.configuration.SipRealmVO;
import com.egsbc.configuration.SipServerVO;
import com.egsbc.configuration.SipTrunkVO;
import com.egsbc.configuration.service.VoIPService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class EasyController {
	
	private static final Logger logger = LoggerFactory.getLogger(EasyController.class);


	
	@Resource(name="voIPService")
	 private VoIPService voIPService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	
	/*
	 * getEasy
	 */
	 @RequestMapping(value = "/getEasy", method = {RequestMethod.POST})
	 public ModelAndView getEasy() throws Exception {
		 
		 List<EasyConfigurationVO> list = new ArrayList<EasyConfigurationVO>();
		 EasyConfigurationVO vo = null;
		 
		 
		 //----------------------- Server/Realm ----------------------------------------------------------
		 
		 // Realm
		 List<SipRealmVO> realmList = voIPService.getSipRealmByGroupByService();
		 for(SipRealmVO realmVO : realmList){	 
			 vo = new EasyConfigurationVO();
			 vo.setMode((short)0);
			 vo.setServiceName(realmVO.getServiceName());
			 
			 vo.setRlmName(realmVO.getName());
			 vo.setRlmDomain(realmVO.getDomain());
			 vo.setRlmSigTransName(realmVO.getSigTransName());
			 vo.setRlmMediaTransName(realmVO.getMediaTransName());
			 vo.setRlmRegPeriod(realmVO.getRegPeriod());
			 
			 vo.setRlmElemType(realmVO.getElemType());
			 vo.setRlmGroupName(realmVO.getGroupName());
			 vo.setRlmMediaPassFlag(realmVO.getMediaPassFlag());
			 vo.setRlmSrtpFlag(realmVO.getSrtpFlag());
			 vo.setRlmRegPeriodNat(realmVO.getRegPeriodNat());
			 vo.setRlmRegPeriodBypass(realmVO.getRegPeriodBypass());
			 vo.setRlmSessionFlag(realmVO.getSessionFlag());
			 vo.setRlmSessionExpires(realmVO.getSessionExpires());
			 vo.setRlmSessionMinse(realmVO.getSessionMinse());
			 vo.setRlmDeregDeactFlag(realmVO.getDeregDeactFlag());
			 vo.setRlmEndPointType(realmVO.getEndPointType());
			 
			 list.add(vo);
		 }
		 
		 // Server
		 List<SipServerVO> serverList = voIPService.getSipServerByGroupByService();
		 for(SipServerVO serverVO : serverList){
			 for(EasyConfigurationVO vo2 : list){
				 if(vo2.getMode() == 0 && vo2.getServiceName().equals(serverVO.getServiceName()) ){
					 
					 vo2.setSvrPollFlag(serverVO.getPollFlag()); // 추가
					 
					 vo2.setSvrName(serverVO.getName());
					 vo2.setSvrDomain(serverVO.getDomain());
					 vo2.setSvrSigTransName(serverVO.getSigTransName());
					 vo2.setSvrMediaTransName(serverVO.getMediaTransName());
					 vo2.setSvrRegPeriod(serverVO.getRegPeriod());
					 
					 vo.setSvrElemType(serverVO.getElemType());
					 vo.setSvrGroupName(serverVO.getGroupName());
					 vo.setSvrServerIPType(serverVO.getServerIPType());
					 vo.setSvrServerIP(serverVO.getServerIP());
					 vo.setSvrServerPort(serverVO.getServerPort());
					 vo.setSvrSrtpFlag(serverVO.getSrtpFlag());
					 vo.setSvrMaxCps(serverVO.getMaxCps());
					 vo.setSvrMaxSession(serverVO.getMaxSession());
					 vo.setSvrMaxRps(serverVO.getMaxRps());
					 vo.setSvrPollingStatus(serverVO.getPollingStatus());
					 vo.setSvrPollingTime(serverVO.getPollingTime());
					
					 break;
				 }
			 }
		 }
		 
		 
		 //----------------------- Trunking ----------------------------------------------------------
		 
		// Trunk R_GROUP0
		 List<SipTrunkVO> trunkList = voIPService.getSipTrunkRGroupByGroupByService();
		 for(SipTrunkVO trunkVO : trunkList){	 
			 vo = new EasyConfigurationVO();
			 vo.setMode((short)1);
			 vo.setServiceName(trunkVO.getServiceName());
			 
			 vo.setRlmName(trunkVO.getName());
			 vo.setRlmDomain(trunkVO.getDomain());
			 vo.setRlmSigTransName(trunkVO.getSigTransName());
			 vo.setRlmMediaTransName(trunkVO.getMediaTransName());
			 vo.setRlmRegPeriod(trunkVO.getRegPeriod());
			 
			 vo.setRlmElemType(trunkVO.getElemType());
			 vo.setRlmGroupName(trunkVO.getGroupName());
			 vo.setRlmPeerIpType(trunkVO.getPeerIpType());
			 vo.setRlmPeerIp(trunkVO.getPeerIp());
			 vo.setRlmPeerPort(trunkVO.getPeerPort());
			 vo.setRlmMediaPassFlag(trunkVO.getMediaPassFlag());
			 vo.setRlmSrtpFlag(trunkVO.getSrtpFlag());
			 vo.setRlmRegisterFlag(trunkVO.getRegisterFlag());
			 vo.setRlmRegisterUserId(trunkVO.getRegisterUserId());
			 vo.setRlmRegisterDomain(trunkVO.getRegisterDomain());
			 vo.setRlmRegisterAuthId(trunkVO.getRegisterAuthId());
			 vo.setRlmRegisterAuthPw(trunkVO.getRegisterAuthPw());
			 vo.setRlmPolicySpamFlag(trunkVO.getPolicySpamFlag());
			 vo.setRlmMaxCps(trunkVO.getMaxCps());
			 vo.setRlmMaxSession(trunkVO.getMaxSession());
			 vo.setRlmPollingStatus(trunkVO.getPollingStatus());
			 
//			 if(trunkVO.getElem1() != null && !trunkVO.getElem1().equals("")){
//				 SipTrunkVO sipTrunkVO = voIPService.getSipTrunkByElem1(trunkVO.getElem1());
//				 if(sipTrunkVO != null){
//					 vo.setRlmPeerIp2(sipTrunkVO.getPeerIp());
//					 vo.setRlmPeerPort2(sipTrunkVO.getPeerPort());
//					 vo.setRlmSigTransName2(sipTrunkVO.getSigTransName());
//				 }
//			 }
			 
			 list.add(vo);
		 }
		 
		 
		// Trunk L_GROUP0
		 trunkList = voIPService.getSipTrunkLGroupByGroupByService();
		 for(SipTrunkVO trunkVO : trunkList){	 
			 for(EasyConfigurationVO vo2 : list){
				 if(vo2.getMode() == 1 && vo2.getServiceName().equals(trunkVO.getServiceName()) ){
					 vo2.setSvrName(trunkVO.getName());
					 vo2.setSvrDomain(trunkVO.getDomain());
					 vo2.setSvrSigTransName(trunkVO.getSigTransName());
					 vo2.setSvrMediaTransName(trunkVO.getMediaTransName());
					 vo2.setSvrRegPeriod(trunkVO.getRegPeriod());
					 vo2.setSvrElemType(trunkVO.getElemType());
					 vo2.setSvrGroupName(trunkVO.getGroupName());
					 vo2.setSvrPeerIpType(trunkVO.getPeerIpType());
					 
					 vo2.setSvrPeerIp(trunkVO.getPeerIp());
					 vo2.setSvrPeerPort(trunkVO.getPeerPort());
					 
					 vo2.setSvrMediaPassFlag(trunkVO.getMediaPassFlag());
					 vo2.setSvrSrtpFlag(trunkVO.getSrtpFlag());
					 vo2.setSvrRegisterFlag(trunkVO.getRegisterFlag());
					 vo2.setSvrRegisterUserId(trunkVO.getRegisterUserId());
					 vo2.setSvrRegisterDomain(trunkVO.getRegisterDomain());
					 vo2.setSvrRegisterAuthId(trunkVO.getRegisterAuthId());
					 vo2.setSvrRegisterAuthPw(trunkVO.getRegisterAuthPw());
					 vo2.setSvrPolicySpamFlag(trunkVO.getPolicySpamFlag());
					 vo2.setSvrMaxCps(trunkVO.getMaxCps());
					 vo2.setSvrMaxSession(trunkVO.getMaxSession());
					 vo2.setSvrPollingStatus(trunkVO.getPollingStatus());
					 
					 if(trunkVO.getElem1() != null && !trunkVO.getElem1().equals("")){
						 SipTrunkVO sipTrunkVO = voIPService.getSipTrunkByElem1(trunkVO.getElem1());
						 if(sipTrunkVO != null){
							 vo.setSvrPeerIp2(sipTrunkVO.getPeerIp());
							 vo.setSvrPeerPort2(sipTrunkVO.getPeerPort());
							 vo.setSvrSigTransName2(sipTrunkVO.getSigTransName());
						 }
					 }
					 
					 break;
				 }
			 }
		 }
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 
	 /*
	  * take RealmServer
	  */
	 @RequestMapping(value = "/takeRealmServer", method = {RequestMethod.POST})
	 public ModelAndView takeRealmServer(@ModelAttribute EasyConfigurationVO vo,  BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = voIPService.createRealmServer(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_EASY_REALMSERVER,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 /*
	  * take Trunking
	  */
	 @RequestMapping(value = "/takeTrunking", method = {RequestMethod.POST}) 
	 public ModelAndView takeTrunking(HttpServletRequest req, @ModelAttribute EasyConfigurationVO vo,  BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = voIPService.createTrunking(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_EASY_TRUNKING,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
}
