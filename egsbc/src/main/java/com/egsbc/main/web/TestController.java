package com.egsbc.main.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.main.TestVO;
import com.egsbc.main.service.TestService;
import com.egsbc.overview.service.OverviewService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Controller
public class TestController {
	
	@Resource(name="testService")
	 private TestService testService;
	
	 /*
	 * getTest
	 */
	 @RequestMapping(value = "/getTest", method = {RequestMethod.POST})
	 public ModelAndView getTest() throws Exception {
		 
		 
		 JSONArray array = new JSONArray();
		 JSONObject obj =  null;
		 
		 String sql = 
				 "SELECT "+
				 "T_INDEX  				id, "+
				 "T_INTF_NAME 			name "+
				 "FROM R_PRIMITIVE_NW_INTF";
		 
		 
		 List<HashMap<String, Object>> dataList = testService.getTest(sql);
		 
		 for(int i=0; i<dataList.size(); i++){
			 
			 HashMap<String, Object> item = dataList.get(i);
			 
			 String id = item.get("id").toString();
			 String name = item.get("name").toString();
			 
			 obj = new JSONObject(); 
			 obj.put("id", id);
			 obj.put("name", name);
			 
			 array.add(obj);
			 
		 }
		 

//		 
//		 obj.put("id", "abc");
//		 obj.put("name", "ahnks");
//		 array.add(obj);
//		 
//		 obj.put("id", "asdf");
//		 obj.put("name", "lee");
//		 array.add(obj);
//		 
//		 
//		 List<TestVO> list = new ArrayList<TestVO>();
//		 
//		 TestVO myTest = new TestVO();
//		 myTest.setId("123");
//		 myTest.setName("ahnks");
//		 list.add(myTest);
//		 
//		 TestVO myTest2 = new TestVO();
//		 myTest2.setId("567");
//		 myTest2.setName("lee");
//		 list.add(myTest2);
		 
		 
		 
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", 2);
		 mav.addObject("recordsFiltered",2);
		 mav.addObject("data", array);
		 
		 return mav;
	 }

}

