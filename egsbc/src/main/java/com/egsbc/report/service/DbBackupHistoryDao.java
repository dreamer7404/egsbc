package com.egsbc.report.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.report.CheckValidityHistoryVO;
import com.egsbc.report.DbBackupHistoryVO;
import com.egsbc.report.LogBackupHistoryVO;
import com.egsbc.report.SearchDateVO;

@Repository("dbBackupHistoryDao")
public class DbBackupHistoryDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	
	public int addDbBackupHistory(DbBackupHistoryVO vo) throws Exception {
		return sqlSession.insert("DbBackupHistoryDao.addDbBackupHistory", vo);
    }
	
	public List<DbBackupHistoryVO> getDbBackupHistory(SearchDateVO vo) throws Exception {
		return sqlSession.selectList("DbBackupHistoryDao.getDbBackupHistory", vo);
    }
	public int getDbBackupHistoryCnt(SearchDateVO vo) throws Exception {
		return sqlSession.selectOne("DbBackupHistoryDao.getDbBackupHistoryCnt", vo);
    }
	
	public List<LogBackupHistoryVO> getLogBackupHistory(SearchDateVO vo) throws Exception {
		return sqlSession.selectList("DbBackupHistoryDao.getLogBackupHistory", vo);
    }
	public int getLogBackupHistoryCnt(SearchDateVO vo) throws Exception {
		return sqlSession.selectOne("DbBackupHistoryDao.getLogBackupHistoryCnt", vo);
    }
	
	public List<CheckValidityHistoryVO> getCheckValidityHistory(SearchDateVO vo) throws Exception {
		return sqlSession.selectList("DbBackupHistoryDao.getCheckValidityHistory", vo);
    }
	public int getCheckValidityHistoryCnt(SearchDateVO vo) throws Exception {
		return sqlSession.selectOne("DbBackupHistoryDao.getCheckValidityHistoryCnt", vo);
    }
	
	
}
