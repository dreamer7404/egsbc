package com.egsbc.report.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.report.CheckValidityHistoryVO;
import com.egsbc.report.DbBackupHistoryVO;
import com.egsbc.report.LogBackupHistoryVO;
import com.egsbc.report.NatHistoryVO;
import com.egsbc.report.SearchDateVO;

@Service("dbBackupHistoryService")
public class DbBackupHistoryService {
	
	@Resource(name="dbBackupHistoryDao")
	private DbBackupHistoryDao dbBackupHistoryDao;
	
	
	public int addDbBackupHistory(DbBackupHistoryVO vo) throws Exception {
		return dbBackupHistoryDao.addDbBackupHistory(vo);
	}
	
	public List<DbBackupHistoryVO> getDbBackupHistory(SearchDateVO vo) throws Exception {
		return dbBackupHistoryDao.getDbBackupHistory(vo);
	}
	
	public int getDbBackupHistoryCnt(SearchDateVO vo) throws Exception {
		return dbBackupHistoryDao.getDbBackupHistoryCnt(vo);
	}
	
	public List<LogBackupHistoryVO> getLogBackupHistory(SearchDateVO vo) throws Exception {
		return dbBackupHistoryDao.getLogBackupHistory(vo);
	}
	public int getLogBackupHistoryCnt(SearchDateVO vo) throws Exception {
		return dbBackupHistoryDao.getLogBackupHistoryCnt(vo);
	}
	
	public List<CheckValidityHistoryVO> getCheckValidityHistory(SearchDateVO vo) throws Exception {
		return dbBackupHistoryDao.getCheckValidityHistory(vo);
	}
	public int getCheckValidityHistoryCnt(SearchDateVO vo) throws Exception {
		return dbBackupHistoryDao.getCheckValidityHistoryCnt(vo);
	}

}
