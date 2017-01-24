package com.egsbc.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.system.AlarmCodeVO;
import com.egsbc.system.service.AlarmCodeService;

@Controller
public class AlarmCodeController {
	
	
	@Resource(name="alarmCodeService")
	private AlarmCodeService alarmCodeService;
	
	/*
	  * getAlarmCode
	  */
	 @RequestMapping(value = "/getAlarmCode", method = RequestMethod.POST)
	 public ModelAndView getAlarmCode() throws Exception {
		 List<AlarmCodeVO> list = alarmCodeService.getAlarmCode();

		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
	 
	/*
	 * setAlarmCode
	 */
	 @RequestMapping(value = "/setAlarmCode", method = RequestMethod.POST)
	 public ModelAndView setAlarmCode(@ModelAttribute AlarmCodeVO vo, BindingResult bindingResult) throws Exception {
		 int result = alarmCodeService.setAlarmCode(vo);
		 return new ModelAndView("jsonView", "result", result);
	 }
}
