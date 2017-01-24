package com.egsbc.securityIp.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.securityIp.SecSpamCallVO;
import com.egsbc.securityIp.SecSpamImVO;
import com.egsbc.securityIp.SecSpamVO;
import com.egsbc.securityIp.service.SecuritySpamService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class SecuritySpamController {

	@Resource(name="securitySpamService")
	private SecuritySpamService securitySpamService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	 /*
	  * getSecSpam, SpamCall, SpamIm
	  */
	 @RequestMapping(value = "/getSecSpam", method = {RequestMethod.POST})
	 public ModelAndView getSecSpam() throws Exception {
		 SecSpamVO secSpamVO = securitySpamService.getSecSpam();
		 SecSpamCallVO secSpamCallVO = securitySpamService.getSecSpamCall();
		 SecSpamImVO secSpamImVO = securitySpamService.getSecSpamIm();
		 
		 ModelAndView mav =  new ModelAndView();
		 mav.setViewName("jsonView");
		 mav.addObject("spam", secSpamVO);
		 mav.addObject("spamCall", secSpamCallVO);
		 mav.addObject("spamIm", secSpamImVO);
		 
		 return mav;
	 }
	
	 /*
	  * takeSpam
	  */
	 @RequestMapping(value = "/takeSpam", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSpam(@ModelAttribute SecSpamVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = securitySpamService.createSecSpam(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_SPAM_OVERVIEW, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 /*
	  * takeSpamCall
	  */
	 @RequestMapping(value = "/takeSpamCall", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSpamCall(@ModelAttribute SecSpamCallVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = securitySpamService.createSecSpamCall(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_SPAM_CALL, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 /*
	  * takeSpamIm
	  */
	 @RequestMapping(value = "/takeSpamIm", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSpamIm(@ModelAttribute SecSpamImVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = securitySpamService.createSecSpamIm(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_SPAM_IM, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
}
