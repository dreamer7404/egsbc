package com.egsbc.securityIp;

public class RateLimitVO {
	private short profileId;
	private short category;
	private short mainPacketType;
	private String mainPacketName;
	private short subPacketType;
	private String subPacketName;
	private short limitType;
	private short limitValue;
	private short limitDetectActionRule;
	private short alarmCode;
	private short alarmLevel;
	private short alarmType;
	private short reLimitCheckInterval;
	private short reDetectActionRule;
	private short reDetectCnt4NextAlarmLevel;
	private short etc;
	
	public short getProfileId() {
		return profileId;
	}
	public void setProfileId(short profileId) {
		this.profileId = profileId;
	}
	public short getCategory() {
		return category;
	}
	public void setCategory(short category) {
		this.category = category;
	}
	public short getMainPacketType() {
		return mainPacketType;
	}
	public void setMainPacketType(short mainPacketType) {
		this.mainPacketType = mainPacketType;
	}
	public String getMainPacketName() {
		return mainPacketName;
	}
	public void setMainPacketName(String mainPacketName) {
		this.mainPacketName = mainPacketName;
	}
	public short getSubPacketType() {
		return subPacketType;
	}
	public void setSubPacketType(short subPacketType) {
		this.subPacketType = subPacketType;
	}
	public String getSubPacketName() {
		return subPacketName;
	}
	public void setSubPacketName(String subPacketName) {
		this.subPacketName = subPacketName;
	}
	public short getLimitType() {
		return limitType;
	}
	public void setLimitType(short limitType) {
		this.limitType = limitType;
	}
	public short getLimitValue() {
		return limitValue;
	}
	public void setLimitValue(short limitValue) {
		this.limitValue = limitValue;
	}
	public short getLimitDetectActionRule() {
		return limitDetectActionRule;
	}
	public void setLimitDetectActionRule(short limitDetectActionRule) {
		this.limitDetectActionRule = limitDetectActionRule;
	}
	public short getAlarmCode() {
		return alarmCode;
	}
	public void setAlarmCode(short alarmCode) {
		this.alarmCode = alarmCode;
	}
	public short getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(short alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	public short getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(short alarmType) {
		this.alarmType = alarmType;
	}
	public short getReLimitCheckInterval() {
		return reLimitCheckInterval;
	}
	public void setReLimitCheckInterval(short reLimitCheckInterval) {
		this.reLimitCheckInterval = reLimitCheckInterval;
	}
	public short getReDetectActionRule() {
		return reDetectActionRule;
	}
	public void setReDetectActionRule(short reDetectActionRule) {
		this.reDetectActionRule = reDetectActionRule;
	}
	public short getReDetectCnt4NextAlarmLevel() {
		return reDetectCnt4NextAlarmLevel;
	}
	public void setReDetectCnt4NextAlarmLevel(short reDetectCnt4NextAlarmLevel) {
		this.reDetectCnt4NextAlarmLevel = reDetectCnt4NextAlarmLevel;
	}
	public short getEtc() {
		return etc;
	}
	public void setEtc(short etc) {
		this.etc = etc;
	}
	
	
	
}
