package com.egsbc.system.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.PrimitiveConfigVO;
import com.egsbc.configuration.StaticACLVO;
import com.egsbc.system.NtpConfigVO;
import com.egsbc.system.NtpDateVO;
import com.egsbc.system.NtpServerVO;
import com.egsbc.system.NtpVO;
import com.egsbc.system.UserEmailServerVO;
import com.egsbc.system.service.CoreSetService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;
import com.egsbc.ws.MsgVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.StringUtils;

@Controller
public class CoreSetController {
	
	@Resource(name="coreSetService")
	private CoreSetService coreSetService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;

	/*
	  * getConfigNtp
	  */
	 @RequestMapping(value = "/getConfigNtp", method = RequestMethod.POST)
	 public ModelAndView getConfigNtp() throws Exception {
		 List<PrimitiveConfigVO> list = coreSetService.getConfigNtp();
		 return new ModelAndView("jsonView", "result", convertNtp(list));
	 }
	 
	 /*
	  * getNtpServer
	  */
	 @RequestMapping(value = "/getNtpServer", method = RequestMethod.POST)
	 public ModelAndView getNtpServer() throws Exception {
		 List<NtpServerVO> list = coreSetService.getNtpServer();
		 return new ModelAndView("jsonView", "result", list);
	 }
	 
	 /*
	  * getNtpConfig
	  */
	 @RequestMapping(value = "/getNtpConfig", method = RequestMethod.POST)
	 public ModelAndView getNtpConfig() throws Exception {
		 NtpConfigVO vo = coreSetService.getNtpConfig();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("vo", vo);
		 return mav;
	 }
	 
	 
	 /*
	  * take NtpDate
	  */
	 @RequestMapping(value = "/takeNtpDate", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeNtpDate(@ModelAttribute NtpDateVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = coreSetService.createNtpDate(vo);
		 byte[] responseData =ipcService.request(Global.IPC_NTP, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 private NtpVO convertNtp(List<PrimitiveConfigVO> list){
		 NtpVO ntpVO = new NtpVO();
		 for(PrimitiveConfigVO vo : list){
			 if(vo.getArgString().equals("NTP_TIME_MODE") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 ntpVO.setSystemDateTimeMode(Short.parseShort(vo.getValueString()));
			 }
			 else if(vo.getArgString().equals("NTP_TIME_SERVER_MODE") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 ntpVO.setNtpServerMode(Short.parseShort(vo.getValueString()));
			 }
			 else if(vo.getArgString().equals("NTP_MIN_POLL") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 ntpVO.setNtpClientMinPoll(Short.parseShort(vo.getValueString()));
			 }
			 else if(vo.getArgString().equals("NTP_MAX_POLL") && !StringUtils.isNullOrEmpty(vo.getValueString())){
				 ntpVO.setNtpClientMaxPoll(Short.parseShort(vo.getValueString()));
			 }
		 }
		 return ntpVO;
	 }
	 
	 
	 
	 
	 /*
	  * getUserEmailServer
	  */
	 @RequestMapping(value = "/getUserEmailServer", method = RequestMethod.POST)
	 public ModelAndView getUserEmailServer() throws Exception {
		 UserEmailServerVO vo = coreSetService.getUserEmailServer();
		 return new ModelAndView("jsonView", "result", vo);
	 }
	 
	 /*
	  * saveUserEmailServer
	  */
	 @RequestMapping(value = "/saveUserEmailServer", method = RequestMethod.POST)
	 public ModelAndView saveUserEmailServer(@ModelAttribute UserEmailServerVO vo) throws Exception {
		 int result = 0;
		 UserEmailServerVO vo2 = coreSetService.getUserEmailServer();
		 if(vo2 != null){
			 result = coreSetService.setUserEmailServer(vo);
		 }else{
			 result = coreSetService.addUserEmailServer(vo);
		 }
		 return new ModelAndView("jsonView", "result", result);
	 }
	 
	 
}
