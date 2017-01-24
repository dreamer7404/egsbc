package com.egsbc.report.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.report.StatCode4WebVO;
import com.egsbc.report.StatisticsSearchVO;

@Service("statisticsSearchService")
public class StatisticsSearchService {
	
	@Resource(name="statisticsSearchDao")
	private StatisticsSearchDao statisticsSearchDao;
	
	
	public List<StatCode4WebVO> getStatCode4Web(StatisticsSearchVO vo) throws Exception {
		return statisticsSearchDao.getStatCode4Web(vo);
	}

}
