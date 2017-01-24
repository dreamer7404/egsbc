package com.egsbc.alarm.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.alarm.AlarmDataDetailVO;
import com.egsbc.alarm.AlarmDataVO;
import com.egsbc.alarm.AlarmHistoryVO;
import com.egsbc.alarm.AlarmTriggerVO;
import com.egsbc.report.SearchDateVO;

@Service("alarmService")
public class AlarmService {
	
	@Resource(name="alarmDao")
	private AlarmDao alarmDao;
	

	public List<AlarmDataVO> getAlarmData(short alarmLevel) throws Exception {
		return alarmDao.getAlarmData(alarmLevel);
	}
	
	public String getLastAlarmDatetime() throws Exception {
		return alarmDao.getLastAlarmDatetime();
	}
	
	public List<AlarmDataVO> getAlarmDataForEmail() throws Exception {
		return alarmDao.getAlarmDataForEmail();
	}
	
	public List<AlarmDataVO> getAlarmDataByAlarmCode(AlarmDataVO vo) throws Exception {
		return alarmDao.getAlarmDataByAlarmCode(vo);
	}
	
	public AlarmDataDetailVO getAlarmDataDetail(int idx) throws Exception {
		return alarmDao.getAlarmDataDetail(idx);
	}
	
	public int setAlarmPercept(AlarmDataVO vo) throws Exception {
		return alarmDao.setAlarmPercept(vo);
	}
	
	public int setAlarmPerceptDetail(AlarmDataVO vo) throws Exception {
		return alarmDao.setAlarmPerceptDetail(vo);
	}
	
	public List<HashMap<String, Object>> getAlarmCount() throws Exception {
		return alarmDao.getAlarmCount();
	}
	
	public AlarmTriggerVO getAlarmTrigger() throws Exception {
		return alarmDao.getAlarmTrigger();
	}
	
	public int setAlarmTrigger(AlarmTriggerVO vo) throws Exception {
		return alarmDao.setAlarmTrigger(vo);
	}
	public int setAlarmTriggerEtcZero() throws Exception {
		return alarmDao.setAlarmTriggerEtcZero();
	}
	
	public int getMaxIndex() throws Exception {
		return alarmDao.getMaxIndex();
	}
	
	public List<AlarmHistoryVO> getAlarmHistory(SearchDateVO vo) throws Exception {
		return alarmDao.getAlarmHistory(vo);
	}
	public int getAlarmHistoryCnt(SearchDateVO vo) throws Exception {
		return alarmDao.getAlarmHistoryCnt(vo);
	}
	
	public int setAlarmDataEtcClear(int idx) throws Exception {
		return alarmDao.setAlarmDataEtcClear(idx);
	}
	
}
