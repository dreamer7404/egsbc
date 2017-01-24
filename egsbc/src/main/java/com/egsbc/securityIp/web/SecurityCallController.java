package com.egsbc.securityIp.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.PrimitiveConfigVO;
import com.egsbc.securityIp.GeoIpConfigVO;
import com.egsbc.securityIp.GeoIpDateVO;
import com.egsbc.securityIp.GeoIpExcludeVO;
import com.egsbc.securityIp.GeoIpNationVO;
import com.egsbc.securityIp.GeoIpVO;
import com.egsbc.securityIp.SecCallOverseasVO;
import com.egsbc.securityIp.SecCallPatternVO;
import com.egsbc.securityIp.SecImSignaturesVO;
import com.egsbc.securityIp.SecImSignaturesValVO;
import com.egsbc.securityIp.SecOverviewVO;
import com.egsbc.securityIp.SecUserAgentVO;
import com.egsbc.securityIp.service.SecurityCallService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;
import com.mysql.jdbc.StringUtils;

@Controller
public class SecurityCallController {
	
	@Resource(name="securityCallService")
	private SecurityCallService securityCallService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	
	 /*
	  * getSecOverview
	  */
	 @RequestMapping(value = "/getSecOverview", method = {RequestMethod.POST})
	 public ModelAndView getSecOverview() throws Exception {
		 SecOverviewVO vo = securityCallService.getSecOverview();
		 return new ModelAndView("jsonView", "result", vo);
	 }
	 
	 /*
	  * takeSecOverview
	  */
	 @RequestMapping(value = "/takeSecOverview", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecOverview(@ModelAttribute SecOverviewVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecOverview(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_OVERVIEW, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 /*
	  * getGeoIpConfig
	  */
	 
	 @RequestMapping(value = "/getGeoIpConfig", method = {RequestMethod.POST})
	 public ModelAndView getGeoIpConfig() throws Exception {
		 
		 List<PrimitiveConfigVO> list = securityCallService.getGeoIpConfig();
		 GeoIpConfigVO vo = convertGeoIpConfig(list);
		 vo.setGeoUpdateDate(securityCallService.getSecurityGeoIp());
		 
		 return new ModelAndView("jsonView", "result", vo);
	 }
	 
	 private GeoIpConfigVO convertGeoIpConfig(List<PrimitiveConfigVO> list){
		 GeoIpConfigVO geoIpConfigVO = new GeoIpConfigVO();
		 for(PrimitiveConfigVO vo : list){
			 if(vo.getArgString().equals("GEO_IP_OPER_MODE") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 geoIpConfigVO.setGeoIpOperMode(Short.parseShort(vo.getValueString()));
			 }
			 else if(vo.getArgString().equals("GEO_IP_OPER_TIME") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 geoIpConfigVO.setGeoIpDbUpdateTime(Short.parseShort(vo.getValueString()));
			 }
			 else if(vo.getArgString().equals("GEO_IP_AVAILABLE_TIME") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 geoIpConfigVO.setGeoIpDbAvailableTerm(Short.parseShort(vo.getValueString()));
			 }
		 }
		 return geoIpConfigVO;
	 }
	 
	
	/*
	 * getGeoIpList
	 */
	 @RequestMapping(value = "/getGeoIpList", method = {RequestMethod.POST})
	 public ModelAndView getGeoIpList(HttpServletRequest request) throws Exception {
		 List<GeoIpVO> list = securityCallService.getGeoIpList(request);
		 return new ModelAndView("jsonView", "result", list);
	 }
	 
	
	 
	 /*
	  * testLoopup
	  */
	 @RequestMapping(value = "/testLookup", method = {RequestMethod.POST})
	 public ModelAndView testLoopup(String ip) throws Exception {
		 String result = sendingMsgFromStream("geoiplookup "+ip);
		 return new ModelAndView("jsonView", "result", result);
	 }
	 
	 
	 /*
	 *	sending message from stream 
	 */
	
	private String sendingMsgFromStream(String cmd) {
		ProcessBuilder  processBuilder = null;
		String s="";
		try {
			processBuilder = new ProcessBuilder("/bin/bash", "-c",  cmd);
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();
			
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
			s = inputStream.readLine();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*
	 * getNationCodeList
	 */
	 @RequestMapping(value = "/getNationCodeList", method = {RequestMethod.POST})
	 public ModelAndView getNationCodeList(String nationCode) throws Exception {
		 List<GeoIpDateVO> list = securityCallService.getNationCodeList(nationCode);
		 return new ModelAndView("jsonView", "result", list);
	 }
	 
	 /*
	  * takeGeoIp ahnks
	  */
	 @RequestMapping(value = "/takeGeoIp", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeGeoIp(@ModelAttribute GeoIpConfigVO vo, SecOverviewVO secOverviewVO, BindingResult bindingResult) throws Exception {
		 
		 byte[] body = null;
		 
		 if(vo.getOpMode() == 8){ // refresh now
			 body = new byte[0];
		 
		 }else if(vo.getOpMode() == 5){ // apply
			 
			 List<GeoIpNationVO> list = new ArrayList<>();
				
			 // set GeoIpNationVO List
			 String[] arrStr = vo.getGeoIpArray().split("@");
			 for(int i=0; i<arrStr.length; i++){
				 String[] arrItem = arrStr[i].split("\\|");
				 if(arrItem.length == 2){
					 list.add(new GeoIpNationVO(arrItem[0], Short.parseShort(arrItem[1])));
				 }
			 }
			 vo.setList(list);
			 
			 body = securityCallService.createGeoIp(vo, secOverviewVO);
		 }
		 
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_GEO_IP, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 
	 /*
	  * getSecGeoExcludeList
	  */
	 @RequestMapping(value = "/getSecGeoExcludeList", method = {RequestMethod.POST})
	 public ModelAndView getSecGeoExcludeList() throws Exception {
		 List<GeoIpExcludeVO> list = securityCallService.getSecGeoExcludeList();
		 return new ModelAndView("jsonView", "result", list);
	 }
	 
	 
	 
	  /*
	  * takeGeoIpExclude
	  */
	 @RequestMapping(value = "/takeGeoIpExclude", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeGeoIpExclude(@ModelAttribute GeoIpExcludeVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createGeoIpExclude(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_GEO_IP, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * getUserAgent
	  */
	 
	 @RequestMapping(value = "/getSecUserAgent", method = {RequestMethod.POST})
	 public ModelAndView getSecUserAgent() throws Exception {
		 List<SecUserAgentVO> list = securityCallService.getSecUserAgent();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	  * takeSecUserAgent
	  */
	 @RequestMapping(value = "/takeSecUserAgent", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecUserAgent(@ModelAttribute SecUserAgentVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecUserAgent(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_UAGENT, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * getSecCallPattern
	  */
	 @RequestMapping(value = "/getSecCallPattern", method = {RequestMethod.POST})
	 public ModelAndView getCallPattern() throws Exception {
		 SecCallPatternVO vo = securityCallService.getSecCallPattern();
		 return new ModelAndView("jsonView", "result", vo);
	 }
	 
	 /*
	  * takeSecCallPattern
	  */
	 @RequestMapping(value = "/takeSecCallPattern", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecCallPattern(@ModelAttribute SecCallPatternVO vo, SecOverviewVO secOverviewVO,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecCallPattern(vo, secOverviewVO);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_CALL_PATTERN, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * "getSecCallOverseas"
	  */
	 @RequestMapping(value = "/getSecCallOverseas", method = {RequestMethod.POST})
	 public ModelAndView getSecCallOverseas() throws Exception {
		 List<SecCallOverseasVO> list = securityCallService.getSecCallOverseas();
		 
//		 ModelAndView mav = new ModelAndView("jsonView");
//		 mav.addObject("draw", 1);
//		 mav.addObject("recordsTotal", list.size());
//		 mav.addObject("recordsFiltered", list.size());
//		 mav.addObject("data", list);
//		 return mav;
		 
		 return new ModelAndView("jsonView", "list", list);
	 }
	 
	/*
	 * takeSecCallOverseas
	 */
	 @RequestMapping(value = "/takeSecCallOverseas", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecCallOverseas(@ModelAttribute SecCallOverseasVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecCallOverseas(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_CALL_OVERSEAS, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * getSecCallOverseasUser
	  */
	 
	 @RequestMapping(value = "/getSecCallOverseasUser", method = {RequestMethod.POST})
	 public ModelAndView getSecCallOverseasUser() throws Exception {
		 List<SecCallOverseasVO> list = securityCallService.getSecCallOverseasUser();
		 
//		 ModelAndView mav = new ModelAndView("jsonView");
//		 mav.addObject("draw", 1);
//		 mav.addObject("recordsTotal", list.size());
//		 mav.addObject("recordsFiltered", list.size());
//		 mav.addObject("data", list);
//		 return mav;
		 
		 return new ModelAndView("jsonView", "list", list);
	 }
	 
	 /*
	 * takeSecCallOverseasUser
	 */
	 @RequestMapping(value = "/takeSecCallOverseasUser", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecCallOverseasUser(@ModelAttribute SecCallOverseasVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecCallOverseasUser(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_CALL_OVERSEAS_USER, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * getSecCallGapping
	  */
	 
	 @RequestMapping(value = "/getSecCallGapping", method = {RequestMethod.POST})
	 public ModelAndView getSecCallGapping() throws Exception {
		 List<SecCallOverseasVO> list = securityCallService.getSecCallGapping();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * takeSecCallOverseasUser
	 */
	 @RequestMapping(value = "/takeSecCallGapping", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecCallGapping(@ModelAttribute SecCallOverseasVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecCallGapping(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_CALL_GAPPING, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 /*
	  * getSecImSignatureHdr
	  */
	 @RequestMapping(value = "/getSecImSignatureHdr", method = {RequestMethod.POST})
	 public ModelAndView getSecImSignatureHdr() throws Exception {
		 SecImSignaturesVO vo = securityCallService.getSecImSignatureHdr();
		 return new ModelAndView("jsonView", "result", vo);
	 }
	 /*
	  * getSecImSignatureVal
	  */
	 @RequestMapping(value = "/getSecImSignatureVal", method = {RequestMethod.POST})
	 public ModelAndView getSecImSignatureVal() throws Exception {
		 List<SecImSignaturesValVO> list = securityCallService.getSecImSignatureVal();
		 return new ModelAndView("jsonView", "result", list);
	 }
	 
	 /*
	  * takeSecImSignature
	  */
	 @RequestMapping(value = "/takeSecImSignature", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecImSignature(@ModelAttribute SecImSignaturesVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecImSignature(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_IM_SIGNATURE_HDR, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 } 
	 
	 
	 /*
	  * takeSecImSignatureVal
	  */
	 
	 @RequestMapping(value = "/takeSecImSignatureVal", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSecImSignatureVal(@ModelAttribute SecImSignaturesValVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securityCallService.createSecImSignatureVal(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_POLICY_IM_SIGNATURE_VAL, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
}
