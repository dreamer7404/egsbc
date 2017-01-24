package com.egsbc.report.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.common.PageVO;
import com.egsbc.configuration.StaticACLVO;
import com.egsbc.report.StatCode4WebVO;
import com.egsbc.report.StatisticsSearchVO;
import com.egsbc.report.service.StatisticsSearchService;
import com.egsbc.statistics.service.StatisticsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class StatisticsSearchController {

	@Resource(name="statisticsSearchService")
	StatisticsSearchService statisticsSearchService;
	
	@Resource(name="statisticsService")
	 private StatisticsService statisticsService;
	
	/*
	 * getStatisticsItems 
	 */
	@RequestMapping(value = "/getStatisticsItems", method = RequestMethod.POST)
    public ModelAndView getStatisticsItems(@ModelAttribute StatisticsSearchVO vo , BindingResult bindingResult) throws Exception {
		List<StatCode4WebVO> list = statisticsSearchService.getStatCode4Web(vo);
		return new ModelAndView("jsonView", "result", list);
	}
	
	/*
	 *  getStatisticTableInfo
	 */
	 @RequestMapping(value = "/getStatisticTableInfo", method = {RequestMethod.POST})
	 public ModelAndView getStatisticTableInfo(@ModelAttribute StatisticsSearchVO vo , BindingResult bindingResult) throws Exception {
		 List<StatCode4WebVO> list = statisticsSearchService.getStatCode4Web(vo);
		 
		 StatCode4WebVO statCode4WebVO=null;
		 if(list.size() > 0){
			 statCode4WebVO = list.get(0);
		 }
		 return new ModelAndView("jsonView", "result", statCode4WebVO);
	 }
	
	/*
	 *  getStatisticsDynamic
	 */
	 @RequestMapping(value = "/getStatisticsDynamic", method = {RequestMethod.POST})
	 public ModelAndView getStatisticsDynamic(String tableName, String columnNames, String where, String startDate, String endDate) throws Exception {
		 
		 
		 String sql = "SELECT " + columnNames + " FROM " + tableName + " WHERE START_TIME >= '"+ startDate + "' AND END_TIME <= '" +endDate + "' ";
		 
		 if(where != ""){
			 sql += " AND " + where;
		 }
		 
//		 PageVO pageVO = new PageVO();
//		 pageVO.setPage(page);
//		 pageVO.setPageSize(pageSize);
//		 sql += " LIMIT " + pageVO.getOffset() +", " + pageVO.getPageSize();
		 
		 
		 String[] columns = columnNames.split(",");
		 
		 List<HashMap<String, Object>> list = statisticsService.getStatisticsDynamic(sql);
		 
		JSONArray array = new JSONArray();
		JSONObject obj =  null; //new JSONObject(); 
			
		for(Map<String, Object> map : list){
			obj = new JSONObject(); 
			
			for(int i=0; i<columns.length; i++){
				String value = map.get(columns[i].trim()).toString();
				obj.put(columns[i], value);
			}
			
			array.add(obj);
		}
		
		
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", array.size());
		 mav.addObject("recordsFiltered", array.size());
		 mav.addObject("data", array);
		 return mav;
	 }
	 
}
