package com.egsbc.configuration.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.SipRealmGroupVO;
import com.egsbc.configuration.SipRealmVO;
import com.egsbc.configuration.SipServerGroupVO;
import com.egsbc.configuration.SipServerVO;
import com.egsbc.configuration.SipServiceRuleVO;
import com.egsbc.configuration.SipServiceVO;
import com.egsbc.configuration.SipTrunkGroupVO;
import com.egsbc.configuration.SipTrunkVO;
import com.egsbc.configuration.service.VoIPService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class VoIPController {

	@Resource(name="voIPService")
	 private VoIPService voIPService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	/*
	 * get SipServiceName List
	 */
	 @RequestMapping(value = "/getSipServiceName", method = {RequestMethod.POST})
	 public ModelAndView getSipServiceName() throws Exception {
		 List<String> list = voIPService.getSipServiceName();
		 return new ModelAndView ("jsonView", "data", list);
	 }
	 
	 /*
	 * get getSipServiceRule List
	 */
	 @RequestMapping(value = "/getSipServiceRule", method = {RequestMethod.POST})
	 public ModelAndView getSipServiceRule(SipServiceRuleVO vo) throws Exception {
		 List<Integer> list =new ArrayList<Integer>();
		 if(vo.getIsStatic()==1) list.add(0);
		 if(vo.getIsDomain()==1) list.add(1);
		 if(vo.getIsPrefix()==1) list.add(2);
		 vo.setRuleTypeList(list);
		 
		 return new ModelAndView ("jsonView", "data", voIPService.getSipServiceRule(vo));
	 }
	 
	 /*
	  * getSipServiceSourceTargetGroup
	  */
	 @RequestMapping(value = "/getSipServiceSourceTargetGroup", method = {RequestMethod.POST})
	 public ModelAndView getSipServiceSourceTargetGroup() throws Exception {
		 //return new ModelAndView ("jsonView", "data", voIPService.getSipServiceSourceTargetGroup());
		 
		 List[] arr = voIPService.getSipServiceSourceTargetGroup();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("sourceGroup", arr[0]);
		 mav.addObject("targetGroup", arr[1]);
		 return mav;
	 }
	
	 
	 /*
	 * get SipRealm List
	 */
	 @RequestMapping(value = "/getSipRealm", method = {RequestMethod.POST})
	 public ModelAndView getSipRealm() throws Exception {
		 List<SipRealmVO> list = voIPService.getSipRealm();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get SipRealmName List
	 */
	 @RequestMapping(value = "/getSipRealmNameList", method = {RequestMethod.POST})
	 public ModelAndView getSipRealmName(@RequestParam int elemType) throws Exception {
		 List<String> list = voIPService.getSipRealmNameList(elemType);
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	 * get SipRealmGroup List
	 */
	 @RequestMapping(value = "/getSipRealmGroup", method = {RequestMethod.POST})
	 public ModelAndView getSipRealmGroup() throws Exception {
		 List<SipRealmGroupVO> list = voIPService.getSipRealmGroup();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get SipRealmGroupName List
	 */
	 @RequestMapping(value = "/getSipRealmGroupNameList", method = {RequestMethod.POST})
	 public ModelAndView getSipRealmGroupNameList() throws Exception {
		 List<String> list = voIPService.getSipRealmGroupNameList();
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	 * get SipServer List
	 */
	 @RequestMapping(value = "/getSipServer", method = {RequestMethod.POST})
	 public ModelAndView getSipServer() throws Exception {
		 List<SipServerVO> list = voIPService.getSipServer();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get SipServerNameList
	 */
	 @RequestMapping(value = "/getSipServerNameList", method = {RequestMethod.POST})
	 public ModelAndView getSipServerNameList(@RequestParam int elemType) throws Exception {
		 List<String> list = voIPService.getSipServerNameList(elemType);
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	 * get SipServer Group List
	 */
	 @RequestMapping(value = "/getSipServerGroup", method = {RequestMethod.POST})
	 public ModelAndView getSipServerGroup() throws Exception {
		 List<SipServerGroupVO> list = voIPService.getSipServerGroup();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get SipServerGroupName List
	 */
	 @RequestMapping(value = "/getSipServerGroupNameList", method = {RequestMethod.POST})
	 public ModelAndView getSipServerGroupNameList() throws Exception {
		 List<String> list = voIPService.getSipServerGroupNameList();
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	 * get SipService List
	 */
	 @RequestMapping(value = "/getSipService", method = {RequestMethod.POST})
	 public ModelAndView getSipService(@ModelAttribute SipServiceVO vo) throws Exception {
		 List<SipServiceVO> list = voIPService.getSipService(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get SipTrunk
	 */
	 @RequestMapping(value = "/getSipTrunk", method = {RequestMethod.POST})
	 public ModelAndView getSipTrunk() throws Exception {
		 List<SipTrunkVO> list = voIPService.getSipTrunk();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get SipTrunkGroup
	 */
	 @RequestMapping(value = "/getSipTrunkGroup", method = {RequestMethod.POST})
	 public ModelAndView getSipTrunkGroup() throws Exception {
		 List<SipTrunkGroupVO> list = voIPService.getSipTrunkGroup();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 /*
	 * get SipTrunkNameList
	 */
	 @RequestMapping(value = "/getSipTrunkNameList", method = {RequestMethod.POST})
	 public ModelAndView getSipTrunkNameList() throws Exception {
		 List<String> list = voIPService.getSipTrunkNameList();
		 return new ModelAndView("jsonView", "data", list);
	 }
	
	 
	 
	 /*
	  * take Routing
	  */
	 @RequestMapping(value = "/takeRouting", method = {RequestMethod.POST})
	 public ModelAndView takeRouting(@ModelAttribute SipServiceRuleVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createRouting(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_SERVICE_RULE, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take Realm
	  */
	 @RequestMapping(value = "/takeRealm", method = {RequestMethod.POST})
	 public ModelAndView takeRealm(@ModelAttribute SipRealmVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createRealm(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_REALM,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take RealmGroup
	  */
	 @RequestMapping(value = "/takeRealmGroup", method = {RequestMethod.POST})
	 public ModelAndView takeRealmGroup(@ModelAttribute SipRealmGroupVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createRealmGroup(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_REALM_GROUP,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take Server
	  */
	 @RequestMapping(value = "/takeServer", method = {RequestMethod.POST})
	 public ModelAndView takeServer(@ModelAttribute SipServerVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createServer(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_SERVER,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take ServerGroup
	  */
	 @RequestMapping(value = "/takeServerGroup", method = {RequestMethod.POST})
	 public ModelAndView takeServerGroup(@ModelAttribute SipServerGroupVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createServerGroup(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_SERVER_GROUP,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take Service
	  */
	 @RequestMapping(value = "/takeService", method = {RequestMethod.POST})
	 public ModelAndView takeService(@ModelAttribute SipServiceVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createService(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_SERVICE,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 /*
	  * take Trunk
	  */
	 @RequestMapping(value = "/takeTrunk", method = {RequestMethod.POST})
	 public ModelAndView takeTrunk(@ModelAttribute SipTrunkVO vo, BindingResult bindingResult) throws Exception {
		 
		 if(bindingResult.hasErrors()){
	        for (FieldError error : bindingResult.getFieldErrors()) {
	           System.out.println("FIELD: " + error.getField() + " , MSG : " + error.getDefaultMessage());
	        }
		 }
		 
		 byte[] body = voIPService.createTrunk(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_TRUNK,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 /*
	  * take TrunkGroup
	  */
	 @RequestMapping(value = "/takeTrunkGroup", method = {RequestMethod.POST})
	 public ModelAndView takeTrunkGroup(@ModelAttribute SipTrunkGroupVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = voIPService.createTrunkGroup(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SIP_TRUNK_GROUP,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
}
