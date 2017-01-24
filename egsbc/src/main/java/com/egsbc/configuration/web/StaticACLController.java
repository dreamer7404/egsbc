package com.egsbc.configuration.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.StaticACLVO;
import com.egsbc.configuration.service.StaticACLService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class StaticACLController {
	@Resource(name="staticACLService")
	 private StaticACLService staticACLService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;

	/*
	 *  getStaticACL
	 */
	 @RequestMapping(value = "/getStaticACL", method = {RequestMethod.POST})
	 public ModelAndView getStaticACL(@RequestParam int usageACL) throws Exception {
		 List<StaticACLVO> list = staticACLService.getStaticACL(usageACL);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 @RequestMapping(value = "/getPrimitiveConfig", method = {RequestMethod.POST})
	 public ModelAndView getPrimitiveConfig(@RequestParam String argString) throws Exception {
		 return new ModelAndView("jsonView", "data", staticACLService.getPrimitiveConfig(argString));
	 }
	 
	 /*
	  * take Static ACL
	  */
	 @RequestMapping(value = "/takeStaticACL", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeSipNatStaticACL(@ModelAttribute StaticACLVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = staticACLService.createStaticACL(vo);
		 byte[] responseData =ipcService.request(Global.IPC_SECURITY_ACL, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
}
