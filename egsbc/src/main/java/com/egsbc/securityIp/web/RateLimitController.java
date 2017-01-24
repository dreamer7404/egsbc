package com.egsbc.securityIp.web;

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

import com.egsbc.securityIp.RateLimitVO;
import com.egsbc.securityIp.service.RateLimitService;
import com.egsbc.system.AlarmCodeVO;

@Controller
public class RateLimitController {
	
	private static final Logger logger = LoggerFactory.getLogger(RateLimitController.class);
	
	@Resource(name="rateLimitService")
	private RateLimitService rateLimitService;
	
	
	/*
	  * getRateLimit
	  */
	 @RequestMapping(value = "/getRateLimit", method = RequestMethod.POST)
	 public ModelAndView getRateLimit() throws Exception {
		 List<RateLimitVO> list = rateLimitService.getRateLimit();

		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
	 
	 /*
	  * setRateLimit
	  */
	 @RequestMapping(value = "/setRateLimit", method = RequestMethod.POST)
	 public ModelAndView setRateLimit(@ModelAttribute RateLimitVO vo, BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 int result = rateLimitService.setRateLimit(vo);
		 return new ModelAndView("jsonView", "result", result);
	 }
}
