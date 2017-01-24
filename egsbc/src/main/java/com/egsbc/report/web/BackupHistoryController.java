package com.egsbc.report.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.alarm.AlarmHistoryVO;
import com.egsbc.alarm.service.AlarmService;
import com.egsbc.report.CheckValidityHistoryVO;
import com.egsbc.report.DbBackupHistoryVO;
import com.egsbc.report.LogBackupHistoryVO;
import com.egsbc.report.SearchDateVO;
import com.egsbc.report.service.DbBackupHistoryService;

@Controller
public class BackupHistoryController {

	@Resource(name="dbBackupHistoryService")
	 private DbBackupHistoryService dbBackupHistoryService;
	
	 @RequestMapping(value = "/getDbBackupHistory", method = {RequestMethod.POST})
	 public ModelAndView getDbBackupHistory(@ModelAttribute SearchDateVO vo, String arg, BindingResult bindingResult) throws Exception {
		 
		 int cnt = dbBackupHistoryService.getDbBackupHistoryCnt(vo);
		 if(cnt != 0){
			 vo.setTotalRows(cnt);
		 }
		 
		 List<DbBackupHistoryVO> list = dbBackupHistoryService.getDbBackupHistory(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 return mav;
		 
	 }
	 
	 @RequestMapping(value = "/getLogBackupHistory", method = {RequestMethod.POST})
	 public ModelAndView getLogBackupHistory(@ModelAttribute SearchDateVO vo, String arg, BindingResult bindingResult) throws Exception {
		 
		 int cnt = dbBackupHistoryService.getLogBackupHistoryCnt(vo);
		 if(cnt != 0){
			 vo.setTotalRows(cnt);
		 }
		 
		 List<LogBackupHistoryVO> list = dbBackupHistoryService.getLogBackupHistory(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 return mav;
		 
	 }
	 
	 @RequestMapping(value = "/getCheckValidityHistory", method = {RequestMethod.POST})
	 public ModelAndView getCheckValidityHistory(@ModelAttribute SearchDateVO vo, String arg, BindingResult bindingResult) throws Exception {
		 
		 int cnt = dbBackupHistoryService.getCheckValidityHistoryCnt(vo);
		 if(cnt != 0){
			 vo.setTotalRows(cnt);
		 }
		 
		 List<CheckValidityHistoryVO> list = dbBackupHistoryService.getCheckValidityHistory(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 return mav;
		 
	 }
}
