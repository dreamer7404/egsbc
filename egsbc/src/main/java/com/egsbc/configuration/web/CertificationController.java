package com.egsbc.configuration.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.TlsCertFileInfoVO;
import com.egsbc.configuration.TlsConfigVO;
import com.egsbc.configuration.service.CertificationService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class CertificationController {

	@Resource(name="certificationService")
	 private CertificationService certificationService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	
	/*
	 * getTlsConfig
	 */
	 @RequestMapping(value = "/getTlsConfig", method = {RequestMethod.POST})
	 public ModelAndView getTlsConfig() throws Exception {
		 List<TlsConfigVO> list = certificationService.getTlsConfig();
		 return new ModelAndView("jsonView", "result", list);
	 }
	
	 /*
	  * takeTlsConfig
	  */
	 @RequestMapping(value = "/takeTlsConfig", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeTlsConfig(@ModelAttribute TlsConfigVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = certificationService.createTlsConfig(vo);
		 byte[] responseData =ipcService.request(Global.IPC_ADVANCED_SIP_CERT, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 /*
	  * getTlsCertFileInfo
	  */
	 @RequestMapping(value = "/getTlsCertFileInfo", method = {RequestMethod.POST})
	 public ModelAndView getTlsCertFileInfo() throws Exception {
		 
		 TlsCertFileInfoVO appliedVO = certificationService.getTlsCertFileInfoApplied();
		 
		 List<TlsCertFileInfoVO> list = certificationService.getTlsCertFileInfo();
		 
		 boolean[] activateArray = {true, true, true, true};
		 
		 for(int i=0; i<list.size(); i++){
			 TlsCertFileInfoVO vo = list.get(i);
			 
			 // applied 
			 if(vo.getCertMode() == appliedVO.getCertMode() && vo.getFileType() == appliedVO.getFileType()){
				 vo.setApplied((short)1);
			 }
			 
			 // set activate to temp array
			 if(vo.getFileExist() == 0){
				 int index = (int)(i / 4);
				 activateArray[index] = false;
			 }
		 }
		 
		 // set activate from temp array
		 for(int i=0; i<list.size(); i++){
			 TlsCertFileInfoVO vo = list.get(i);
			 vo.setActivate(activateArray[(int)(i / 4)]);
		 }
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 
	 
	 
	 /*
	  * uploadCertification
	  */
	 
	 @RequestMapping(value = "/uploadCertification", method = {RequestMethod.POST})
	 public String uploadCertification(MultipartHttpServletRequest mptRequest, @ModelAttribute TlsCertFileInfoVO vo) throws Exception {
		int result = certificationService.saveFiles(mptRequest, vo);
		return "forward:/takeCertification";
	 }
	 
	 /*
	  * takeCertification
	  */
	 @RequestMapping(value = "/takeCertification", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeCertification(@ModelAttribute TlsCertFileInfoVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = certificationService.createTlsCertFileInfo(vo);
		 byte[] responseData =ipcService.request(Global.IPC_ADVANCED_SIP_CERT_CHECK, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
}
