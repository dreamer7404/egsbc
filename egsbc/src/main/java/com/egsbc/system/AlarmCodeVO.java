package com.egsbc.system;

public class AlarmCodeVO {
	private short alarmCode;
	private String alarmCategoryName;
	private String alarmName;
	private short securityFlag;
	private short rateLimitFlag;
	private short alarmLevel;
	private short alarmLevelThresholdValue;
	private short alarmAction;
	private short alarmType;
	private String alarmMsg;
	private String alarmDesc;
	private String blockName;
	private short soundOn;
	private short smsOn;
	private short emailOn;
	
	public short getAlarmCode() {
		return alarmCode;
	}
	public void setAlarmCode(short alarmCode) {
		this.alarmCode = alarmCode;
	}
	public short getAlarmLevelThresholdValue() {
		return alarmLevelThresholdValue;
	}
	public void setAlarmLevelThresholdValue(short alarmLevelThresholdValue) {
		this.alarmLevelThresholdValue = alarmLevelThresholdValue;
	}
	public short getAlarmAction() {
		return alarmAction;
	}
	public void setAlarmAction(short alarmAction) {
		this.alarmAction = alarmAction;
	}
	public String getAlarmCategoryName() {
		return alarmCategoryName;
	}
	public void setAlarmCategoryName(String alarmCategoryName) {
		this.alarmCategoryName = alarmCategoryName;
	}
	public String getAlarmName() {
		return alarmName;
	}
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}
	public short getSecurityFlag() {
		return securityFlag;
	}
	public void setSecurityFlag(short securityFlag) {
		this.securityFlag = securityFlag;
	}
	public short getRateLimitFlag() {
		return rateLimitFlag;
	}
	public void setRateLimitFlag(short rateLimitFlag) {
		this.rateLimitFlag = rateLimitFlag;
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
	public String getAlarmMsg() {
		return alarmMsg;
	}
	public void setAlarmMsg(String alarmMsg) {
		this.alarmMsg = alarmMsg;
	}
	public String getAlarmDesc() {
		return alarmDesc;
	}
	public void setAlarmDesc(String alarmDesc) {
		this.alarmDesc = alarmDesc;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public short getSoundOn() {
		return soundOn;
	}
	public void setSoundOn(short soundOn) {
		this.soundOn = soundOn;
	}
	public short getSmsOn() {
		return smsOn;
	}
	public void setSmsOn(short smsOn) {
		this.smsOn = smsOn;
	}
	public short getEmailOn() {
		return emailOn;
	}
	public void setEmailOn(short emailOn) {
		this.emailOn = emailOn;
	}
	
	
	
	
}
