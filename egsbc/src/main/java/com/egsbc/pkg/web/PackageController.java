package com.egsbc.pkg.web;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.egsbc.common.service.CommonService;
import com.egsbc.configuration.TransportVO;
import com.egsbc.pkg.PackageBlockVO;
import com.egsbc.pkg.PackageVO;
import com.egsbc.pkg.service.PackageService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class PackageController {

	@Resource(name="packageService")
	 private PackageService packageService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Value("${UploadPath}") 
	private String uploadPath;
	
	/*
	 * getPackage
	 */
	 @RequestMapping(value = "/getPackage", method = {RequestMethod.POST})
	 public ModelAndView getPackage(@RequestParam int side) throws Exception {
		 List<PackageVO> list = packageService.getPackage(side);
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	 * uploadPackage
	 */
	 @RequestMapping(value = "/uploadPackage", method = {RequestMethod.POST})
	 public ModelAndView uploadPackage(MultipartHttpServletRequest mptRequest,  short host) throws Exception {
		 
		 ModelAndView mav = new ModelAndView();
		 
		 Iterator<?> fileIter = mptRequest.getFileNames();
		 if (fileIter.hasNext()) {
		 	MultipartFile mFile = mptRequest.getFile((String)fileIter.next());
		 	
		 	if(mFile.getSize() > 0){
//			 	long size = mFile.getSize();
			 	
			 	String fileName = mFile.getOriginalFilename();
			 	String saveName = System.currentTimeMillis() + "-" + fileName;
			 	
			 	String path = "";
			 	if(System.getProperty("os.name").contains("Windows")){
			 		uploadPath = "C:\\";
			 	}
			 	
			 	path = uploadPath + saveName;
			 	
			 	File file = new File(path);
			 	
			 	// save
			 	mFile.transferTo(file);
			 	
			 	Thread.sleep(500);
			 	
			 	if(file.exists()){// OK,  redirect
			 		mav.setViewName("redirect:/takePackage?opMode=2&side="+host+"&pkgVer="+saveName);
			 	}else{ // fail to save file
			 		mav.setViewName("jsonView");
			 		mav.addObject("result", commonService.setErrorList(Global.ERR_FILE_SAVE_FAILURE, "Fail, Save upload-file!"));
			 	}
		 	}else{ // file size = 0
		 		mav.setViewName("jsonView");
		 		mav.addObject("result", commonService.setErrorList(Global.ERR_FILE_SIZE_ZERO, "Fail, Upload-file size is zero!"));
		 	}
		  
		 }else{ // no attached upload file
			mav.setViewName("jsonView");
		 	mav.addObject("result", commonService.setErrorList(Global.ERR_FILE_NO_ATTACH, "Fail, No upload-file!"));
		 }
		 
		 return mav;
	 }
	 
	 /*
	 * getPackageBlock
	 */
	 @RequestMapping(value = "/getPackageBlock", method = {RequestMethod.POST})
	 public ModelAndView getPackageBlock(PackageBlockVO vo) throws Exception {
		 List<PackageBlockVO> list = packageService.getPackageBlock(vo);
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	  * take Package
	  */
	 @RequestMapping(value = "/takePackage", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takePackage(@ModelAttribute PackageVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = packageService.createPackage(vo);
		 byte[] responseData =ipcService.request(Global.IPC_PACKAGE, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
}
