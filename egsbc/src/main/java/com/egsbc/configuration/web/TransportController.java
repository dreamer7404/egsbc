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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.TransportVO;
import com.egsbc.configuration.service.TransportService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class TransportController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransportController.class);
	
	@Resource(name="transportService")
	 private TransportService transportService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;

	/*
	 * get SipTransport
	 */
	 @RequestMapping(value = "/getSipTransport", method = {RequestMethod.POST})
	 public ModelAndView getSipTransport() throws Exception {
		 List<TransportVO> list = transportService.getSipTransport();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * get MediaTransport
	 */
	 @RequestMapping(value = "/getMediaTransport", method = {RequestMethod.POST})
	 public ModelAndView getMediaTransport() throws Exception {
		 List<TransportVO> list = transportService.getMediaTransport();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
		 
	 /*
	 * get NatTransport
	 */
	 @RequestMapping(value = "/getNatTransport", method = {RequestMethod.POST})
	 public ModelAndView getNatTransport() throws Exception {
		 List<TransportVO> list = transportService.getNatTransport();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	  * getMediaTransportName
	  */
	 @RequestMapping(value = "/getMediaTransportName", method = {RequestMethod.POST})
	 public ModelAndView getMediaTransportName() throws Exception {
		 return new ModelAndView ("jsonView", "data", transportService.getMediaTransportName());
	 }
	 /*
	  * getSipTransportName
	  */
	 @RequestMapping(value = "/getSipTransportName", method = {RequestMethod.POST})
	 public ModelAndView getSipTransportName(@RequestParam int svcType) throws Exception {
		 return new ModelAndView ("jsonView", "data", transportService.getSipTransportName(svcType));
	 }
	 
	 
	 /*
	  * take SipTransport
	  */
	 @RequestMapping(value = "/takeSipTransport", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSipTransport(@ModelAttribute TransportVO vo, BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = transportService.createSipTransport(vo);
		 byte[] responseData =ipcService.request(Global.IPC_TRANSPORT_SIG, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take MediaTransport
	  */
	 @RequestMapping(value = "/takeMediaTransport", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeMediaTransport(@ModelAttribute TransportVO vo,  BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = transportService.createMediaTransport(vo);
		 byte[] responseData =ipcService.request(Global.IPC_TRANSPORT_MEDIA, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * take NatTransport
	  */
	 @RequestMapping(value = "/takeNatTransport", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeNatTransport(@ModelAttribute TransportVO vo, BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = transportService.createNatTransport(vo);
		 byte[] responseData =ipcService.request(Global.IPC_TRANSPORT_NAT, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
}
