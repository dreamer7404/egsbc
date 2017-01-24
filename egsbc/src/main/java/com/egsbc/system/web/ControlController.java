package com.egsbc.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.statistics.service.StatisticsService;
import com.egsbc.system.PrimitiveSysDupVO;
import com.egsbc.system.PrimitiveSysProcessVO;
import com.egsbc.system.ProcessControlVO;
import com.egsbc.system.SystemControlVO;
import com.egsbc.system.service.ControlService;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class ControlController {
	
	@Resource(name="controlService")
	private ControlService controlService;
	
	@Resource(name="statisticsService")
	private StatisticsService statisticsService;
	
	
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	
	/*
	  * apply System
	  */
	 @RequestMapping(value = "/applySystem", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView applySystem(@ModelAttribute SystemControlVO vo) throws Exception {
		 vo.setControlClass((short)0);
		 byte[] body = controlService.createSystemControl(vo);
		 byte[] responseData =ipcService.request(0x1007,  vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	
	 
	/*
	  * apply Process
	  */
	 @RequestMapping(value = "/applyProcess", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView applyProcess(@ModelAttribute ProcessControlVO vo) throws Exception {
		 vo.setControlClass((short)1);
		 byte[] body = controlService.createProcessControl(vo);
		 byte[] responseData =ipcService.request(0x1007, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	 * getPrimitiveSysDup
	 */
	 @RequestMapping(value = "/getPrimitiveSysDup", method = {RequestMethod.POST})
	 public ModelAndView getPrimitiveSysDup(@ModelAttribute PrimitiveSysDupVO vo) throws Exception {
		 
		 List<PrimitiveSysDupVO> list = statisticsService.getPrimitiveSysDup((short)-1);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
		 
	 /*
	 * getPrimitiveSysProcess
	 */
	 @RequestMapping(value = "/getPrimitiveSysProcess", method = {RequestMethod.POST})
	 public ModelAndView getPrimitiveSysProcess(@ModelAttribute PrimitiveSysProcessVO vo) throws Exception {
		 
		 List<PrimitiveSysProcessVO> list = controlService.getPrimitiveSysProcess();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
		 
	

}
