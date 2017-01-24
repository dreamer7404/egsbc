package com.egsbc.configuration.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.configuration.PrimitiveNwIntfVO;
import com.egsbc.configuration.service.InterfaceService;
import com.egsbc.utils.FromBytes;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.IPCService;

@Controller
public class InterfaceController {
	
	private static final Logger logger = LoggerFactory.getLogger(InterfaceController.class);
	
	@Resource(name="interfaceService")
	 private InterfaceService interfaceService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;

	/*
	 * getInterface
	 */
	 @RequestMapping(value = "/getInterface", method = {RequestMethod.POST})
	 public ModelAndView getInterface() throws Exception {
		 List<PrimitiveNwIntfVO> list = interfaceService.getInterface();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 return mav;
	 }
	 
	 /*
	  * getInterfaceNameList
	  */
	 @RequestMapping(value = "/getInterfaceNameList", method = {RequestMethod.POST})
	 public ModelAndView getInterfaceNameList() throws Exception {
		 List<String> list = interfaceService.getInterfaceNameList();
		 return new ModelAndView("jsonView", "data", list);
	 }
	 /*
	  * getInterfaceNameListForAdd
	  */
	 @RequestMapping(value = "/getInterfaceNameListForAdd", method = {RequestMethod.POST})
	 public ModelAndView getInterfaceNameListForAdd() throws Exception {
		 List<String> list = interfaceService.getInterfaceNameListForAdd();
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	  * getInterfaceAliasList
	  */
	 @RequestMapping(value = "/getInterfaceAliasList", method = {RequestMethod.POST})
	 public ModelAndView getInterfaceAliasList() throws Exception {
		 List<PrimitiveNwIntfVO> list = interfaceService.getInterfaceAliasList();
		 return new ModelAndView("jsonView", "data", list);
	 }
	 
	 /*
	  * take Interface
	  */
	 @RequestMapping(value = "/takeInterface", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeInterface(@ModelAttribute PrimitiveNwIntfVO vo, BindingResult bindingResult) throws Exception {
		 if(bindingResult.hasErrors()){
			 logger.info(bindingResult.getFieldError().toString());
		 }
		 byte[] body = interfaceService.createInterface(vo);
		 byte[] responseData = ipcService.request(Global.IPC_NETWORK, vo.getOpMode(), body);
		 
		 int sentSize = body.length + Global.HEAD_DATA_LEN;
		 
		 List<String> resultList = new ArrayList<String>();
		
		 byte[] bError = new byte[Global.INT_LEN];
		 byte[] bMsg = new byte[Global.STR_LEN];
		 int errorCode = 0;
		 
		 // get errorCode
		 System.arraycopy(responseData, sentSize, bError, 0, Global.INT_LEN);
		 errorCode = FromBytes.Int(bError);
		 resultList.add(String.valueOf(errorCode));
		 
		 // get error msg
		 if(errorCode != 0){
			 // error msg count
			 short cnt = 0;
			 byte[] bCnt = new byte[Global.SHO_LEN];
			 int idxDataCount =  responseData.length - Global.ERR_DATA_LEN + Global.INT_LEN;
			 System.arraycopy(responseData, idxDataCount, bCnt, 0, Global.SHO_LEN); // get cnt
			 cnt = (short) FromBytes.Short(bCnt);
			 
			 if(cnt > 0 && cnt < 6){
				 for(int i=0; i<cnt; i++){
					 int idx = responseData.length - Global.ERR_DATA_LEN + Global.INT_LEN + Global.SHO_LEN + (Global.STR_LEN * i);
					 System.arraycopy(responseData, idx, bMsg, 0, Global.STR_LEN); // get msg
					 resultList.add(new String(bMsg));
				 }
			 }
		 }
		
		
		//================== DEBUGGING  print ===========================================================
		 System.out.println("====================== responseData (" + responseData.length + ") =================================");
		 System.out.println("Error Code  => " + errorCode);
		 for(int j=0; j < responseData.length; ++j){
	         System.out.print(String.format("%02X ", (0xFF & responseData[j])));    
	         if(j==429){
	        	 System.out.print("[");
	         }
	         if(j==433){
	        	 System.out.print("]");
	         }
	         
	         if((j+1)%10==0){
	        	 System.out.print("\n");
	         }
    	   }
		 System.out.print("\n");
		 
		 
		 
		 return new ModelAndView("jsonView", "result", resultList);
		 
	 }
	 
	 /*
	 * getInterfaceAliasForNat
	 */
	 @RequestMapping(value = "/getInterfaceAliasForNat", method = {RequestMethod.POST})
	 public ModelAndView getInterfaceAliasForNat() throws Exception {
		 return new ModelAndView ("jsonView", "data", interfaceService.getInterfaceAliasForNat());
	 }
}
