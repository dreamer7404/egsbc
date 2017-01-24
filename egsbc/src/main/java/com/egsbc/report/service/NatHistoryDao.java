package com.egsbc.report.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.report.NatHistoryVO;
import com.egsbc.report.SearchDateVO;

@Repository("natHistoryDao")
public class NatHistoryDao {
	
	@Resource(name="sqlSession2")
	private SqlSession sqlSession2;
	
	
	
	public List<NatHistoryVO> getNatHistory(SearchDateVO vo) throws Exception {
		return sqlSession2.selectList("NatHistoryDao.getNatHistory", vo);
    }
	
	public int getNatHistoryCnt(SearchDateVO vo) throws Exception {
		return sqlSession2.selectOne("NatHistoryDao.getNatHistoryCnt", vo);
    }
	
}
