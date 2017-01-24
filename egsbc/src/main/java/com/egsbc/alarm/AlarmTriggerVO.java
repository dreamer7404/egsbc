package com.egsbc.alarm;

public class AlarmTriggerVO {
	private short alarmOccured;
	private short etc;
	
	AlarmTriggerVO(){}
	
	public AlarmTriggerVO(short alarmOccured){
		super();
		this.alarmOccured = alarmOccured;
	}
	

	public short getAlarmOccured() {
		return alarmOccured;
	}
	public void setAlarmOccured(short alarmOccured) {
		this.alarmOccured = alarmOccured;
	}
	public short getEtc() {
		return etc;
	}
	public void setEtc(short etc) {
		this.etc = etc;
	}
	
	
}
