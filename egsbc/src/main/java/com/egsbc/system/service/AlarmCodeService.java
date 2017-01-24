package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.system.AlarmCodeVO;

@Service("alarmCodeService")
public class AlarmCodeService {
	
	@Resource(name="alarmCodeDao")
	private AlarmCodeDao alarmCodeDao;
	
	
	public List<AlarmCodeVO> getAlarmCode() throws Exception {
		return alarmCodeDao.getAlarmCode();
	}
	
	public int setAlarmCode(AlarmCodeVO vo) throws Exception {
		return alarmCodeDao.setAlarmCode(vo);
	}
}
