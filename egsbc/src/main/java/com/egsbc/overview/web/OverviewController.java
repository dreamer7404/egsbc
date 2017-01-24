package com.egsbc.overview.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.overview.CurrentNatEntryVO;
import com.egsbc.overview.service.OverviewService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.IPCService;

@Controller
public class OverviewController {

	@Resource(name="overviewService")
	 private OverviewService overviewService;
	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	 /*
	 * getCurrentNatEntry
	 */
	 @RequestMapping(value = "/getCurrentNatEntry", method = {RequestMethod.POST})
	 public ModelAndView getCurrentNatEntry(@ModelAttribute CurrentNatEntryVO vo) throws Exception {
		 
		 List<CurrentNatEntryVO> list = overviewService.getCurrentNatEntry();
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", list.size());
		 mav.addObject("recordsFiltered", list.size());
		 mav.addObject("data", list);
		 
		
		 
		 return mav;
	 }
	 
	 /*
	  * take CurrentNatEntry
	  */
	 @RequestMapping(value = "/takeCurrentNatEntry", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeCurrentNatEntry(@ModelAttribute CurrentNatEntryVO vo,  BindingResult bindingResult) throws Exception {
		 byte[] body = overviewService.createCurrentNatEntry(vo);
		 byte[] responseData =ipcService.request(Global.IPC_NAT_ENTRY, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }

}
