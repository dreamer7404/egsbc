package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.system.AlarmCodeVO;

@Repository("alarmCodeDao")
public class AlarmCodeDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public List<AlarmCodeVO> getAlarmCode() throws Exception {
		return sqlSession.selectList("AlarmCodeDao.getAlarmCode");
    }
	
	public int setAlarmCode(AlarmCodeVO vo) throws Exception {
		return sqlSession.update("AlarmCodeDao.setAlarmCode", vo);
	}
	
	
}
