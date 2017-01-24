package com.egsbc.system.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.PrimitiveNwIntfVO;
import com.egsbc.system.PolicyCheckValidityVO;
import com.egsbc.system.PolicyDataBackupVO;
import com.egsbc.system.PolicyDataDeleteVO;
import com.egsbc.system.service.PolicyDataService;

@Controller
public class PolicyController {
	
	@Resource(name="policyDataService")
	private PolicyDataService policyDataService;
	
	
	@RequestMapping(value = "/getPolicyDataBackup", method = {RequestMethod.POST})
	public ModelAndView getPolicyDataBackup() throws Exception {
		PolicyDataBackupVO vo = new PolicyDataBackupVO();
		vo = policyDataService.getPolicyDataBackup();
		return new ModelAndView("jsonView", "result", vo);
	}
	
	@RequestMapping(value = "/setPolicyDataBackup", method = {RequestMethod.POST})
	public ModelAndView setPolicyDataBackup(@ModelAttribute PolicyDataBackupVO vo, BindingResult bindingResult) throws Exception {
		int result = policyDataService.setPolicyDataBackup(vo);
		return new ModelAndView("jsonView", "result", result);
	}
	

	
	@RequestMapping(value = "/getPolicyDataDelete", method = {RequestMethod.POST})
	public ModelAndView getPolicyDataDelete() throws Exception {
		PolicyDataDeleteVO vo = new PolicyDataDeleteVO();
		vo = policyDataService.getPolicyDataDelete();
		return new ModelAndView("jsonView", "result", vo);
	}

	@RequestMapping(value = "/setPolicyDataDelete", method = {RequestMethod.POST})
	public ModelAndView setPolicyDataDelete(@ModelAttribute PolicyDataDeleteVO vo, BindingResult bindingResult) throws Exception {
		int result = policyDataService.setPolicyDataDelete(vo);
		return new ModelAndView("jsonView", "result", result);
	}
	@RequestMapping(value = "/setPolicyFileDelete", method = {RequestMethod.POST})
	public ModelAndView setPolicyFileDelete(@ModelAttribute PolicyDataDeleteVO vo, BindingResult bindingResult) throws Exception {
		int result = policyDataService.setPolicyFileDelete(vo);
		return new ModelAndView("jsonView", "result", result);
	}
	
	@RequestMapping(value = "/getPolicyCheckValidity", method = {RequestMethod.POST})
	public ModelAndView getPolicyCheckValidity() throws Exception {
		PolicyCheckValidityVO vo = policyDataService.getPolicyCheckValidity();
		return new ModelAndView("jsonView", "result", vo);
	}
	
	@RequestMapping(value = "/setPolicyCheckValidity", method = {RequestMethod.POST})
	public ModelAndView setPolicyCheckValidity(@ModelAttribute PolicyCheckValidityVO vo, BindingResult bindingResult) throws Exception {
		int result = policyDataService.setPolicyCheckValidity(vo);
		return new ModelAndView("jsonView", "result", result);
	}
	
}
