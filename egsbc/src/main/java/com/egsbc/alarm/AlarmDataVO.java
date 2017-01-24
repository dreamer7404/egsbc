package com.egsbc.alarm;

import com.egsbc.common.IPCMsgVO;

public class AlarmDataVO extends IPCMsgVO {
	private int	idx;
	private short alarmLevel;
	private short side;
	private String createDatetime;
	private int alarmCode;
	private String alarmCauseParam;
	private String causeDescription;
	
	private int cnt;
	private String userId;
	private int releaseFlag; // 0: not , 1: delete (=> T_RELEASE_DATETIME = NOW())
	
	public short getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(short alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	public int getReleaseFlag() {
		return releaseFlag;
	}
	public void setReleaseFlag(int releaseFlag) {
		this.releaseFlag = releaseFlag;
	}
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public String getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	public int getAlarmCode() {
		return alarmCode;
	}
	public void setAlarmCode(int alarmCode) {
		this.alarmCode = alarmCode;
	}
	public String getCauseDescription() {
		return causeDescription;
	}
	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAlarmCauseParam() {
		return alarmCauseParam;
	}
	public void setAlarmCauseParam(String alarmCauseParam) {
		this.alarmCauseParam = alarmCauseParam;
	}
	
	
	
	
}
