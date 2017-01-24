package com.egsbc.statistics.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.statistics.StaticCallVO;
import com.egsbc.statistics.StaticMaxMinDateVO;
import com.egsbc.statistics.StaticSubscriberVO;
import com.egsbc.system.PrimitiveSysDupVO;


@Service("statisticsService")
public class StatisticsService {

	@Resource(name="statisticsDao")
	private StatisticsDao statisticsDao;
	
	public List<PrimitiveSysDupVO> getPrimitiveSysDup(short side) throws Exception {
		return statisticsDao.getPrimitiveSysDup(side);
	}
	
	public List<StaticCallVO> getStaticCall() throws Exception {
		return statisticsDao.getStaticCall();
	}
	
	public List<StaticSubscriberVO> getStaticSubscriber(StaticSubscriberVO vo) throws Exception {
		return statisticsDao.getStaticSubscriber(vo);
	}
	public int getStaticSubscriberCnt(StaticSubscriberVO vo) throws Exception {
		return statisticsDao.getStaticSubscriberCnt(vo);
	}
	
	public StaticMaxMinDateVO getStaticSubscriberDate() throws Exception {
		return statisticsDao.getStaticSubscriberDate();
	}
	public Map<String, Object> getStaticSubscriberRegCnt() throws Exception {
		return statisticsDao.getStaticSubscriberRegCnt();
	}
	
	
	public List<StaticCallVO> getStaticCall(StaticCallVO vo) throws Exception {
		return statisticsDao.getStaticCall(vo);
    }
	public int getStaticCallCnt(StaticCallVO vo) throws Exception {
		return statisticsDao.getStaticCallCnt(vo);
	}
	public StaticMaxMinDateVO getStaticCallDate() throws Exception {
		return statisticsDao.getStaticCallDate();
	}
	public Map<String, Object> getStaticCallCntCalling() throws Exception {
		return statisticsDao.getStaticCallCntCalling();
	}
	
	public List<HashMap<String, Object>> getStatisticsDynamic(String sql) throws Exception {
		return statisticsDao.getStatisticsDynamic(sql);
	}
	
	/*
	 * ================ Current Call ==============================================
	 * 
	 */
	public List<StaticCallVO> getStaticCallCurrent(StaticCallVO vo) throws Exception {
		return statisticsDao.getStaticCallCurrent(vo);
	}
	public int getStaticCallCurrentCnt(StaticCallVO vo) throws Exception {
		return statisticsDao.getStaticCallCurrentCnt(vo);
	}
	
	public List<StaticSubscriberVO> getStaticSubscriberCurrent(StaticSubscriberVO vo) throws Exception {
		return statisticsDao.getStaticSubscriberCurrent(vo);
	}
	public int getStaticSubscriberCurrentCnt(StaticSubscriberVO vo) throws Exception {
		return statisticsDao.getStaticSubscriberCurrentCnt(vo);
	}
	
}
