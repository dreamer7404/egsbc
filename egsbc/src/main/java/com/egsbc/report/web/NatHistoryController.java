package com.egsbc.report.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.report.NatHistoryVO;
import com.egsbc.report.SearchDateVO;
import com.egsbc.report.service.NatHistoryService;

@Controller
public class NatHistoryController {
	
	@Resource(name="natHistoryService")
	 private NatHistoryService natHistoryService;
	

	/*
	 * getNatHistory
	 */
	 @RequestMapping(value = "/getNatHistory", method = {RequestMethod.POST})
	 public ModelAndView getNatHistory(@ModelAttribute SearchDateVO vo, BindingResult bindingResult) throws Exception {

		 int cnt = natHistoryService.getNatHistoryCnt(vo);
		 if(cnt != 0){
			 vo.setTotalRows(cnt);
		 }
		 
		 List<NatHistoryVO> list = natHistoryService.getNatHistory(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 return mav;
	 }
}
