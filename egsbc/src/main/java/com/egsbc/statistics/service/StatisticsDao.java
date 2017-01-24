package com.egsbc.statistics.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.statistics.StaticCallVO;
import com.egsbc.statistics.StaticMaxMinDateVO;
import com.egsbc.statistics.StaticSubscriberVO;
import com.egsbc.system.PrimitiveSysDupVO;

@Repository("statisticsDao")
public class StatisticsDao {
	
	@Resource(name="sqlSession2")
	private SqlSession sqlSession2;
	
	public List<PrimitiveSysDupVO> getPrimitiveSysDup(short side) throws Exception {
		return sqlSession2.selectList("StatisticsDao.getPrimitiveSysDup", side);
	}
	
	public List<StaticCallVO> getStaticCall() throws Exception {
		return sqlSession2.selectList("StatisticsDao.getStaticCall");
    }
	
	public List<StaticSubscriberVO> getStaticSubscriber(StaticSubscriberVO vo) throws Exception {
		return sqlSession2.selectList("StatisticsDao.getStaticSubscriber", vo);
    }
	public int getStaticSubscriberCnt(StaticSubscriberVO vo) throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticSubscriberCnt", vo);
    }
	public StaticMaxMinDateVO getStaticSubscriberDate() throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticSubscriberDate");
    }
	public Map<String, Object> getStaticSubscriberRegCnt() throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticSubscriberRegCnt");
    }
	
	
	public List<StaticCallVO> getStaticCall(StaticCallVO vo) throws Exception {
		return sqlSession2.selectList("StatisticsDao.getStaticCall", vo);
    }
	public int getStaticCallCnt(StaticCallVO vo) throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticCallCnt", vo);
    }
	public StaticMaxMinDateVO getStaticCallDate() throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticCallDate");
    }
	public Map<String, Object> getStaticCallCntCalling() throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticCallCntCalling");
    }
	
	public List<HashMap<String, Object>> getStatisticsDynamic(String sql) throws Exception {
		return sqlSession2.selectList("StatisticsDao.getStatisticsDynamic", sql);
	}
	
	/*
	 * ================ Current Call ==============================================
	 * 
	 */
	public List<StaticCallVO> getStaticCallCurrent(StaticCallVO vo) throws Exception {
		return sqlSession2.selectList("StatisticsDao.getStaticCallCurrent", vo);
	}
	public int getStaticCallCurrentCnt(StaticCallVO vo) throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticCallCurrentCnt", vo);
    }
	
	public List<StaticSubscriberVO> getStaticSubscriberCurrent(StaticSubscriberVO vo) throws Exception {
		return sqlSession2.selectList("StatisticsDao.getStaticSubscriberCurrent", vo);
	}
	public int getStaticSubscriberCurrentCnt(StaticSubscriberVO vo) throws Exception {
		return sqlSession2.selectOne("StatisticsDao.getStaticSubscriberCurrentCnt", vo);
    }
	
}
