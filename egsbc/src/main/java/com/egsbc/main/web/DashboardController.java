package com.egsbc.main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.alarm.AlarmDataDetailVO;
import com.egsbc.alarm.AlarmDataVO;
import com.egsbc.alarm.service.AlarmService;
import com.egsbc.main.LocalInfoVO;
import com.egsbc.main.service.LocalInfoService;
import com.egsbc.pkg.PackageVO;
import com.egsbc.pkg.service.PackageService;
import com.egsbc.statistics.service.StatisticsService;
import com.egsbc.system.AlarmCodeVO;
import com.egsbc.system.PrimitiveSysDupVO;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.ResourceMonitoringService;
import com.egsbc.system.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class DashboardController {

	@Resource(name="statisticsService")
	private StatisticsService statisticsService;
	
	@Resource(name="localInfoService")
	private LocalInfoService localInfoService;
	
	@Resource(name="packageService")
	private PackageService packageService;
	
	@Resource(name="resourceMonitoringService")
	private ResourceMonitoringService resourceMonitoringService;
	
	@Resource(name="alarmService")
	private AlarmService alarmService;
	
	@Resource(name="userService")
	private UserService userService;
	
	/*
	 * get Side
	 */
	@RequestMapping(value = "/getSide", method = RequestMethod.POST)
    public ModelAndView getSide() throws Exception {
		LocalInfoVO localInfoVO = localInfoService.getDupInfo();
		return new ModelAndView("jsonView", "result", localInfoVO);
	}
	
	/*
	 * getSystemStatus
	 */
	@RequestMapping(value = "/getSystemStatus", method = RequestMethod.POST)
    public ModelAndView getSystemStatus(@RequestParam short side) throws Exception {
		
		LocalInfoVO localInfoVO = localInfoService.getDupInfo();
		List<PrimitiveSysDupVO> list = statisticsService.getPrimitiveSysDup(side);
		
		List<PackageVO> PkgList = packageService.getPackage(localInfoVO.getDupSide());
		
		PackageVO packageVO = new PackageVO();
		if(PkgList.size()>0){
			packageVO = PkgList.get(0);
		}
		
		// alarm color range
		//JSONArray array = new JSONArray();
		JSONObject obj =  new JSONObject(); 
		List<AlarmCodeVO> alarmCodeList = resourceMonitoringService.getResourceMonitoring();
		
		for(int i=0; i<alarmCodeList.size(); i++){
			AlarmCodeVO vo = alarmCodeList.get(i);
			
			if(vo.getAlarmCode() == 301) obj.put("cpuMinor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 302) obj.put("cpuMajor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 303) obj.put("cpuCritical", vo.getAlarmLevelThresholdValue());
			
			else if(vo.getAlarmCode() == 304) obj.put("memoryMinor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 305) obj.put("memoryMajor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 306) obj.put("memoryCritical", vo.getAlarmLevelThresholdValue());
			
			else if(vo.getAlarmCode() == 307) obj.put("diskMinor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 308) obj.put("diskMajor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 309) obj.put("diskCritical", vo.getAlarmLevelThresholdValue());
			
			else if(vo.getAlarmCode() == 310) obj.put("temperatureMinor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 311) obj.put("temperatureMajor", vo.getAlarmLevelThresholdValue());
			else if(vo.getAlarmCode() == 312) obj.put("temperatureCritical", vo.getAlarmLevelThresholdValue());
		}
		
		
		//---------- get maxCreateDatetime of alarm/event --------------------------
		//int maxIndex =	alarmService.getMaxIndex();
		
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject( "localinfo", localInfoVO);
		mav.addObject( "list", list);
		mav.addObject( "pkg",packageVO);
		mav.addObject( "alarmValue", obj);
		//mav.addObject( "maxIndex", maxIndex);
		
		return mav;
	}
	
	
	
	/*
	 * getAlarmData
	 */
	@RequestMapping(value = "/getAlarmData", method = RequestMethod.POST)
    public ModelAndView getAlarmData(short alarmLevel) throws Exception {
		
		List<AlarmDataVO> list = alarmService.getAlarmData(alarmLevel);
		
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	}
	
	
	/*
	 * getAlarmDataByAlarmCode
	 */
	@RequestMapping(value = "/getAlarmDataByAlarmCode", method = RequestMethod.POST)
    public ModelAndView getAlarmDataByAlarmCode(@ModelAttribute AlarmDataVO vo) throws Exception {
		
		List<AlarmDataVO> list = alarmService.getAlarmDataByAlarmCode(vo);
		
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	}
	
	/*
	 * getAlarmDataDetail
	 */
	@RequestMapping(value = "/getAlarmDataDetail", method = RequestMethod.POST)
    public ModelAndView getAlarmDataDetail(int idx) throws Exception {
		AlarmDataDetailVO detailVO = alarmService.getAlarmDataDetail(idx);
		return new ModelAndView("jsonView", "result", detailVO);
	}
		
	/*
	 * setAlarmPercept
	 */
	@RequestMapping(value = "/setAlarmPercept", method = RequestMethod.POST)
    public ModelAndView setAlarmPercept(Authentication authentication, String str) throws Exception {
		
		UserDetails details = (UserDetails)authentication.getDetails();
		UserVO userVO = userService.getUser(details.getUsername());
		 
		int result = 0;
		AlarmDataVO vo =null;
		
		String[] arr = str.split("@");
		for(int i=0; i<arr.length; i++){
			String[] arr2 = arr[i].split(",");
			
			vo = new AlarmDataVO();
			vo.setUserId(userVO.getId());
			vo.setSide(Short.parseShort(arr2[0]));
			vo.setAlarmCode(Integer.parseInt(arr2[1]));
			
			result += alarmService.setAlarmPercept(vo);
		}
		
		return new ModelAndView("jsonView", "result", result);
	}
	
	
	/*
	 * setAlarmPerceptDetail
	 */
	@RequestMapping(value = "/setAlarmPerceptDetail", method = RequestMethod.POST)
    public ModelAndView setAlarmPerceptDetail(Authentication authentication, String str, int releaseFlag) throws Exception {
		
		UserDetails details = (UserDetails)authentication.getDetails();
		UserVO userVO = userService.getUser(details.getUsername());
		 
		int result = 0;
		AlarmDataVO vo =null;
		
		String[] arr = str.split("@");
		for(int i=0; i<arr.length; i++){
			
			vo = new AlarmDataVO();
			vo.setUserId(userVO.getId());
			vo.setIdx(Integer.parseInt(arr[i]));
			vo.setReleaseFlag(releaseFlag);
			
			result += alarmService.setAlarmPerceptDetail(vo);
		}
		
		return new ModelAndView("jsonView", "result", result);
	}
}
