package com.egsbc.statistics.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.statistics.StaticCallVO;
import com.egsbc.statistics.StaticMaxMinDateVO;
import com.egsbc.statistics.StaticSubscriberVO;
import com.egsbc.statistics.service.StatisticsService;
import com.egsbc.utils.service.IPCService;

@Controller
public class StatisticsController {
	
	@Resource(name="statisticsService")
	 private StatisticsService statisticsService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;

	/*
	 * getStaticSubsriber
	 */
	 @RequestMapping(value = "/getStaticSubscriber", method = {RequestMethod.POST})
	 public ModelAndView getStaticSubscriber(@ModelAttribute StaticSubscriberVO vo) throws Exception {
		 
		 List<StaticSubscriberVO> list = statisticsService.getStaticSubscriber(vo);
		 vo.setTotalRows(statisticsService.getStaticSubscriberCnt(vo));
		 
		 //가입자수
		 Map<String, Object>  map = statisticsService.getStaticSubscriberRegCnt();
		 if(map != null && map.get("cntAll") != null && map.get("cntReg") != null){
			 vo.setSubscriberCntAll(Integer.parseInt(map.get("cntAll").toString()));
			 vo.setSubscriberCntReg(Integer.parseInt(map.get("cntReg").toString()));
		 }
		 
		 // datetime
		 StaticMaxMinDateVO dateVO =  statisticsService.getStaticSubscriberDate();
		 if(dateVO.getMinDate() == null  || dateVO.getMaxDate() == null ){
			 // ahnks 
//			 vo.setDate1();
//			 vo.setDate2();
		 }else{
			 vo.setDate1(dateVO.getMinDate());
			 vo.setDate2(dateVO.getMaxDate());
		 }
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 
		 return mav;
	 }
	 
	 /*
	 * getStaticSubscriberDate
	 */
	 @RequestMapping(value = "/getStaticSubscriberDate", method = {RequestMethod.POST})
	 public ModelAndView getStaticSubscriberDate() throws Exception {
		 StaticMaxMinDateVO vo = statisticsService.getStaticSubscriberDate();
		 return new ModelAndView("jsonView", "vo", vo);
	 } 
	 
	 /*
	 * getStaticCall
	 */
	 @RequestMapping(value = "/getStaticCall", method = {RequestMethod.POST})
	 public ModelAndView getStaticCall(@ModelAttribute StaticCallVO vo) throws Exception {
		 
		 List<StaticCallVO> list = statisticsService.getStaticCall(vo);
		 vo.setTotalRows(statisticsService.getStaticCallCnt(vo));

		 // 통화중
		 Map<String, Object>  map = statisticsService.getStaticCallCntCalling();
		 if(map != null && map.get("cntAll") != null && map.get("cntCalling") != null){
			 vo.setCntAll(Integer.parseInt(map.get("cntAll").toString()));
			 vo.setCntCalling(Integer.parseInt(map.get("cntCalling").toString()));
		 }
		 
		 // datetime
		 StaticMaxMinDateVO dateVO =  statisticsService.getStaticCallDate();
		 if(dateVO.getMinDate() == null  || dateVO.getMaxDate() == null ){
			 // ahnks 
//			 vo.setDate1();
//			 vo.setDate2();
		 }else{
			 vo.setDate1(dateVO.getMinDate());
			 vo.setDate2(dateVO.getMaxDate());
		 }
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 
		 return mav;
	 }
	 /*
	 * getStaticCallDate
	 */
	 @RequestMapping(value = "/getStaticCallDate", method = {RequestMethod.POST})
	 public ModelAndView getStaticCallDate() throws Exception {
		 StaticMaxMinDateVO vo = statisticsService.getStaticCallDate();
		 return new ModelAndView("jsonView", "vo", vo);
	 } 
	 
	 
	 /*
	  * getCurrentCall
	  */
	 @RequestMapping(value = "/getStaticCallCurrent", method = {RequestMethod.POST})
	 public ModelAndView getStaticCallCurrent(@ModelAttribute StaticCallVO vo) throws Exception {
		 
		 List<StaticCallVO> list = new ArrayList<>();
		// if(!vo.getUserId().equals("")){
			 list = statisticsService.getStaticCallCurrent(vo);
			 vo.setTotalRows(statisticsService.getStaticCallCurrentCnt(vo));
		 //}
	 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 
		 return mav;
	 }
	 
	 /*
	  * getStaticSubscriberCurrent
	  */
	 
	 @RequestMapping(value = "/getStaticSubscriberCurrent", method = {RequestMethod.POST})
	 public ModelAndView getStaticSubscriberCurrent(@ModelAttribute StaticSubscriberVO vo) throws Exception {
		 
		 List<StaticSubscriberVO> list = new ArrayList<>();
		// if(!vo.getUserId().equals("")){
			 list = statisticsService.getStaticSubscriberCurrent(vo);
			 vo.setTotalRows(statisticsService.getStaticSubscriberCurrentCnt(vo));
		// }
	 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 
		 return mav;
	 }

}
