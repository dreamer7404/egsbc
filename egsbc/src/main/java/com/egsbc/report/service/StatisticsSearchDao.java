package com.egsbc.report.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.report.StatCode4WebVO;
import com.egsbc.report.StatisticsSearchVO;

@Repository("statisticsSearchDao")
public class StatisticsSearchDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	
	public List<StatCode4WebVO> getStatCode4Web(StatisticsSearchVO vo) throws Exception {
		return sqlSession.selectList("StatisticsSearchDao.getStatCode4Web", vo);
    }
	
	
	
}
