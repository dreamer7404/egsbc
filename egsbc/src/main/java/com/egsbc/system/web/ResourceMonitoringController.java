package com.egsbc.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.system.AlarmCodeChangeVO;
import com.egsbc.system.AlarmCodeVO;
import com.egsbc.system.service.ResourceMonitoringService;

@Controller
public class ResourceMonitoringController {
	
	
	@Resource(name="resourceMonitoringService")
	private ResourceMonitoringService resourceMonitoringService;
	
	/*
	  * getResourceMonitoring
	  */
	 @RequestMapping(value = "/getResourceMonitoring", method = RequestMethod.POST)
	 public ModelAndView getResourceMonitoring() throws Exception {
		 List<AlarmCodeVO> list = resourceMonitoringService.getResourceMonitoring();
		 return new ModelAndView("jsonView", "result", list);
	 }
	 
	 /*
	  * chgResourceMonitoring
	  */
	 @RequestMapping(value = "/chgResourceMonitoring", method = RequestMethod.POST)
	 public ModelAndView chgResourceMonitoring(@ModelAttribute AlarmCodeChangeVO vo, BindingResult bindingResult) throws Exception {
		 int result = resourceMonitoringService.chgResourceMonitoring(vo);
		 return new ModelAndView("jsonView", "result", result);
	 }
	 
}
