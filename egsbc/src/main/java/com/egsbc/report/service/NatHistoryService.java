package com.egsbc.report.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.report.NatHistoryVO;
import com.egsbc.report.SearchDateVO;

@Service("natHistoryService")
public class NatHistoryService {
	
	@Resource(name="natHistoryDao")
	private NatHistoryDao natHistoryDao;
	
	
	public List<NatHistoryVO> getNatHistory(SearchDateVO vo) throws Exception {
		return natHistoryDao.getNatHistory(vo);
	}
	
	public int getNatHistoryCnt(SearchDateVO vo) throws Exception {
		return natHistoryDao.getNatHistoryCnt(vo);
	}

}
