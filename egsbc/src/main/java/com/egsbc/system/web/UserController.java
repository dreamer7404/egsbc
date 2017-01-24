package com.egsbc.system.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.security.CustomUserDetails;
import com.egsbc.security.service.CustomUserDetailsService;
import com.egsbc.system.UserAclVO;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserCommandLevelVO;
import com.egsbc.system.UserConfigVO;
import com.egsbc.system.UserEmailVO;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.UserService;
import com.egsbc.utils.Global;

@Controller
public class UserController {
	
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="customUserDetailsService")
	private CustomUserDetailsService customUserDetailsService;
	
	/*
	  * getUserList
	  */
	 @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	 public ModelAndView getUserList(Authentication authentication) throws Exception {
		 
		 List<UserVO> list = new ArrayList<>();
		 
		 CustomUserDetails details = (CustomUserDetails)authentication.getDetails();
		 if(details.getAuth().equals("0")){
			 UserVO userVO = userService.getUser(details.getUsername());
			 list.add(userVO);
		 }else{
			list = userService.getUserList();
		 }
		

		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
	 
	 
	
	 
	 /*
	  * getSession 처음관리자등록
	  */
	 @RequestMapping(value = "/getDetails", method = RequestMethod.POST)
	 public ModelAndView getDetails(UserVO vo) throws Exception {
		 CustomUserDetails details =  (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		 return new ModelAndView("jsonView", "result" ,details);
	 }
	 
	 /*
	  * removeUser
	  */
	 @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
	 public ModelAndView removeUser(UserVO vo) throws Exception {
		 int result = userService.removeUser(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * setPassword
	  */
	 @RequestMapping(value = "/setPassword", method = RequestMethod.POST)
	 public ModelAndView setPassword(UserVO vo, Authentication authentication) throws Exception {
		 
		 // encript pass
		 vo.setPw(customUserDetailsService.digest(vo.getId(), vo.getPw()));
		 
		 int result = userService.setPassword(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * addManager
	  */
	 
	 @RequestMapping(value = "/addManager", method = RequestMethod.POST)
	 public ModelAndView addManager(UserVO vo) throws Exception {
		 
		 // encript pass
		 vo.setPw(customUserDetailsService.digest(vo.getId(), vo.getPw()));
		 
		 int result = userService.addManager(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * checkDup
	  */
	 @RequestMapping(value = "/checkDupId", method = RequestMethod.POST)
	 public ModelAndView checkDupId(UserVO vo) throws Exception {
		 int result = userService.checkDupId(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * blockManager
	  */
	 @RequestMapping(value = "/blockManager", method = RequestMethod.POST)
	 public ModelAndView blockManager(UserVO vo, Authentication authentication) throws Exception {
		 int result = userService.setUserStatus(new UserVO(vo.getId(), Global.USER_STATUS_FORCED_BLOCKED, ""));
		 
		// add UserActionHistory
		CustomUserDetails details = (CustomUserDetails)authentication.getDetails();
		userService.addUserActionHistory(new UserActionHistoryVO(details.getUsername(), Global.HISTORY_FORCED_BLOCKED, "forced blocked", (short)0, ""));

			
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 /*
	  * releaseManager
	  */
	 @RequestMapping(value = "/releaseManager", method = RequestMethod.POST)
	 public ModelAndView releaseManager(UserVO vo, Authentication authentication) throws Exception {
		 int result = userService.setUserStatus(new UserVO(vo.getId(), Global.USER_STATUS_LOGOUT, ""));
		 
		// add UserActionHistory
		CustomUserDetails details = (CustomUserDetails)authentication.getDetails();
		userService.addUserActionHistory(new UserActionHistoryVO(details.getUsername(), Global.HISTORY_RELEASE_FORCED_BLOCKED, "release forced blocked", (short)0, ""));

		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 
	 /*
	  * getManagerConfigure
	  */
	 @RequestMapping(value = "/getManagerConfigure", method = RequestMethod.POST)
	 public ModelAndView getManagerConfigure() throws Exception {
		 List<UserConfigVO>  list = userService.getManagerConfigure();
		 return new ModelAndView("jsonView", "result" ,list);
	 }
	 
	 /*
	  * setManagerConfigure
	  */
	 @RequestMapping(value = "/setManagerConfigure", method = RequestMethod.POST)
	 public ModelAndView setManagerConfigure(UserConfigVO vo) throws Exception {
		 int result = 0;
		 
		 List<UserConfigVO>  list = userService.getManagerConfigure();
		 if(list.size()==0){
			 result = userService.addManagerConfigure(vo);
		 }else{
			 result = userService.setManagerConfigure(vo);
		 }
		 
		
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * getManagerIpAcl
	  */
	 @RequestMapping(value = "/getManagerIpAcl", method = RequestMethod.POST)
	 public ModelAndView getManagerIpAcl() throws Exception {
		 List<UserAclVO>  list = userService.getManagerUserAcl();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
	 
	 /*
	  * addManagerIpAcl
	  */
	 @RequestMapping(value = "/addManagerIpAcl", method = RequestMethod.POST)
	 public ModelAndView addManagerIpAcl(UserAclVO vo) throws Exception {
		 int result = userService.addManagerIpAcl(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * removeManagerAcl
	  */
	 @RequestMapping(value = "/removeManagerAcl", method = RequestMethod.POST)
	 public ModelAndView removeManagerAcl(UserAclVO vo) throws Exception {
		 int result = userService.removeManagerAcl(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * changeManagerAcl
	  */
	 
	 @RequestMapping(value = "/changeManagerAcl", method = RequestMethod.POST)
	 public ModelAndView changeManagerAcl(UserAclVO vo) throws Exception {
		 vo.setAclEnable((short)((vo.getAclEnable()==0)?1:0));
		 int result = userService.changeManagerAcl(vo);
		 return new ModelAndView("jsonView", "result" ,result);
	 }
	 
	 /*
	  * getUserCommandLevel
	  */
	 @RequestMapping(value = "/getUserCommandLevel", method = RequestMethod.POST)
	 public ModelAndView getUserCommandLevel() throws Exception {
		 List<UserCommandLevelVO>  list = userService.getUserCommandLevel();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		 return mav;
	 }
	 
	 /*
	  * getUserActionHistory
	  */
	 @RequestMapping(value = "/getUserActionHistory", method = RequestMethod.POST)
	 public ModelAndView getUserActionHistory(UserActionHistoryVO vo) throws Exception {
		 int cnt = userService.getUserActionHistoryCnt(vo);
		 if(cnt != 0){
			 vo.setTotalRows(cnt);
		 }
		 List<UserActionHistoryVO>  list = userService.getUserActionHistory(vo);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 mav.addObject("vo", vo);
		 
		 return mav;
	 }
	 
	 
	 /*
	  * addEmail
	  */
	 @RequestMapping(value = "/addEmail", method = RequestMethod.POST)
	 public ModelAndView addEmail(String email1, String email2) throws Exception {
		 int result = userService.addUserEmail(new UserEmailVO(email1 + "@" + email2));
		 return new ModelAndView("jsonView", "result" , result);
	 }
	 
	 /*
	  * getUserEmailList
	  */
	 @RequestMapping(value = "/getUserEmailList", method = RequestMethod.POST)
	 public ModelAndView getUserEmailList() throws Exception {
		 List<UserEmailVO> list = userService.getUserEmail();
		 return new ModelAndView("jsonView", "result" , list);
	 }
	 
	 /*
	  * removeUserEmail
	  */
	 @RequestMapping(value = "/removeUserEmail", method = RequestMethod.POST)
	 public ModelAndView removeUserEmail(String emailAddress) throws Exception {
		 int result = userService.removeUserEmail(new UserEmailVO(emailAddress));
		 return new ModelAndView("jsonView", "result" , result);
	 }
	 
	 
}
