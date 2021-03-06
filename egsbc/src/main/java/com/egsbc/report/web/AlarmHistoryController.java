package com.egsbc.report.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.alarm.AlarmHistoryVO;
import com.egsbc.alarm.service.AlarmService;
import com.egsbc.report.NatHistoryVO;
import com.egsbc.report.SearchDateVO;
import com.egsbc.report.service.NatHistoryService;

@Controller
public class AlarmHistoryController {
	
	@Resource(name="alarmService")
	 private AlarmService alarmService;
	

	/*
	 * getAlarmHistory
	 */
	 @RequestMapping(value = "/getAlarmHistory", method = {RequestMethod.POST})
	 public ModelAndView getAlarmHistory(@ModelAttribute SearchDateVO vo, String arg, BindingResult bindingResult) throws Exception {
		 
		if(!arg.equals("") && !arg.toLowerCase().equals("all")){
			String[] arr = arg.split(",");
			vo.setArgArray(arr);
		}
		 
		 int cnt = alarmService.getAlarmHistoryCnt(vo);
		 if(cnt != 0){
			 vo.setTotalRows(cnt);
		 }
		 
		 List<AlarmHistoryVO> list = alarmService.getAlarmHistory(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 return mav;
	 }
}
