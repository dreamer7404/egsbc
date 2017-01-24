package com.egsbc.configuration.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.SipConfigExtVO;
import com.egsbc.configuration.SipConfigServiceVO;
import com.egsbc.configuration.SipConfigStackVO;
import com.egsbc.configuration.SipConfigTimerVO;
import com.egsbc.configuration.service.AdvancedSipService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class AdvancedSipController {
	
	
	@Resource(name="advancedSipService")
	 private AdvancedSipService advancedSipService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;

	/*
	 * getSipConfigStack
	 */
	 @RequestMapping(value = "/getSipConfigStack", method = {RequestMethod.POST})
	 public ModelAndView getSipConfigStack() throws Exception {
		 List<SipConfigStackVO> list = advancedSipService.getSipConfigStack();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * getSipConfigTimer 
	 */
	 @RequestMapping(value = "/getSipConfigTimer", method = {RequestMethod.POST})
	 public ModelAndView getSipConfigTimer() throws Exception {
		 List<SipConfigTimerVO> list = advancedSipService.getSipConfigTimer();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * getSipConfigService
	 */
	 @RequestMapping(value = "/getSipConfigService", method = {RequestMethod.POST})
	 public ModelAndView getSipConfigService() throws Exception {
		 List<SipConfigServiceVO> list = advancedSipService.getSipConfigService();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 //
	 /*
	 * getSipConfigExt
	 */
	 @RequestMapping(value = "/getSipConfigExt", method = {RequestMethod.POST})
	 public ModelAndView getSipConfigExt() throws Exception {
		 List<SipConfigExtVO> list = advancedSipService.getSipConfigExt();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }	 
	 
	 /*
	  * takeSipStatck 
	  */
	 @RequestMapping(value = "/takeSipStatck", method = {RequestMethod.POST})
	 public ModelAndView takeSipStatck(@ModelAttribute SipConfigStackVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = advancedSipService.createSipStatck(vo);
		 byte[] responseData =ipcService.request(Global.IPC_ADVANCED_SIP_STACK,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 } 
	 
	 /*
	  * takeSipConfigTimer 
	  */
	 @RequestMapping(value = "/takeSipConfigTimer", method = {RequestMethod.POST})
	 public ModelAndView takeSipConfigTimer(@ModelAttribute SipConfigTimerVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = advancedSipService.createSipConfigTimer(vo);
		 byte[] responseData =ipcService.request(Global.IPC_ADVANCED_SIP_TIMER,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * takeSipConfigService 
	  */
	 @RequestMapping(value = "/takeSipConfigService", method = {RequestMethod.POST})
	 public ModelAndView takeSipConfigService(@ModelAttribute SipConfigServiceVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = advancedSipService.createSipConfigService(vo);
		 byte[] responseData =ipcService.request(Global.IPC_ADVANCED_SIP_SERVICE,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * takeSipConfigExt 
	  */
	 @RequestMapping(value = "/takeSipConfigExt", method = {RequestMethod.POST})
	 public ModelAndView takeSipConfigExt(@ModelAttribute SipConfigExtVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = advancedSipService.createSipConfigExt(vo);
		 byte[] responseData =ipcService.request(Global.IPC_ADVANCED_SIP_LOG,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	
}
