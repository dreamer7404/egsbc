package com.egsbc.configuration.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.NatServiceVO;
import com.egsbc.configuration.service.NatServiceService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class NatServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(NatServiceController.class);
	
	@Resource(name="natServiceService")
	 private NatServiceService natServiceService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	
	
	/*
	 * get getNatService
	 */
	 @RequestMapping(value = "/getNatService", method = {RequestMethod.POST})
	 public ModelAndView getNatService() throws Exception {
		 return new ModelAndView ("jsonView", "data", natServiceService.getNatService());
	 }
	 
	 /*
	  * take NatService
	  */
	 @RequestMapping(value = "/takeNatService", method = {RequestMethod.POST})
	 public ModelAndView takeNatService(@ModelAttribute NatServiceVO vo,  BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = natServiceService.createNatService(vo);
		 byte[] responseData =ipcService.request(Global.IPC_NAT_SERVICE,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
}
