package com.egsbc.alarm.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.alarm.AlarmDataDetailVO;
import com.egsbc.alarm.AlarmDataVO;
import com.egsbc.alarm.AlarmHistoryVO;
import com.egsbc.alarm.AlarmTriggerVO;
import com.egsbc.report.SearchDateVO;

@Repository("alarmDao")
public class AlarmDao {
	
	@Resource(name="sqlSession4")
	private SqlSession sqlSession4;
	
	public List<AlarmDataVO> getAlarmData(short alarmLevel) throws Exception {
		return sqlSession4.selectList("AlarmDao.getAlarmData", alarmLevel);
    }
	
	public String getLastAlarmDatetime() throws Exception {
		return sqlSession4.selectOne("AlarmDao.getLastAlarmDatetime");
	}
	
	public List<AlarmDataVO> getAlarmDataForEmail() throws Exception {
		return sqlSession4.selectList("AlarmDao.getAlarmDataForEmail");
    }
	
	public List<AlarmDataVO> getAlarmDataByAlarmCode(AlarmDataVO vo) throws Exception {
		return sqlSession4.selectList("AlarmDao.getAlarmDataByAlarmCode", vo);
    }
	
	
	public AlarmDataDetailVO getAlarmDataDetail(int idx) throws Exception {
		return sqlSession4.selectOne("AlarmDao.getAlarmDataDetail", idx);
	}
	
	
	public int setAlarmPercept(AlarmDataVO vo) throws Exception {
		return sqlSession4.update("AlarmDao.setAlarmPercept", vo);
	}
	
	public int setAlarmPerceptDetail(AlarmDataVO vo) throws Exception {
		return sqlSession4.update("AlarmDao.setAlarmPerceptDetail", vo);
	}
	
	
	public List<HashMap<String, Object>> getAlarmCount() throws Exception {
		return sqlSession4.selectList("AlarmDao.getAlarmCount");
    }
	
	public AlarmTriggerVO getAlarmTrigger() throws Exception {
		return sqlSession4.selectOne("AlarmDao.getAlarmTrigger");
	}
	
	public int setAlarmTrigger(AlarmTriggerVO vo) throws Exception {
		return sqlSession4.update("AlarmDao.setAlarmTrigger", vo);
	}
	public int setAlarmTriggerEtcZero() throws Exception {
		return sqlSession4.update("AlarmDao.setAlarmTriggerEtcZero");
	}
	
	public int getMaxIndex() throws Exception {
		return sqlSession4.selectOne("AlarmDao.getMaxIndex");
	}
	
	public List<AlarmHistoryVO> getAlarmHistory(SearchDateVO vo) throws Exception {
		return sqlSession4.selectList("AlarmDao.getAlarmHistory", vo);
    }
	
	public int getAlarmHistoryCnt(SearchDateVO vo) throws Exception {
		return sqlSession4.selectOne("AlarmDao.getAlarmHistoryCnt", vo);
	}
	
	public int setAlarmDataEtcClear(int idx) throws Exception {
		return sqlSession4.update("AlarmDao.setAlarmDataEtcClear", idx);
	}
	
}
