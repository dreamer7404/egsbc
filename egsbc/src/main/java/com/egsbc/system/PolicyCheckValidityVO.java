package com.egsbc.system;

public class PolicyCheckValidityVO {

	private short checkValidOn;
	private short invalidActionType;
	private short checkValidHour;
	private short checkValidMinute;
	private short etc;
	
	public short getCheckValidOn() {
		return checkValidOn;
	}
	public void setCheckValidOn(short checkValidOn) {
		this.checkValidOn = checkValidOn;
	}
	public short getInvalidActionType() {
		return invalidActionType;
	}
	public void setInvalidActionType(short invalidActionType) {
		this.invalidActionType = invalidActionType;
	}
	public short getCheckValidHour() {
		return checkValidHour;
	}
	public void setCheckValidHour(short checkValidHour) {
		this.checkValidHour = checkValidHour;
	}
	public short getCheckValidMinute() {
		return checkValidMinute;
	}
	public void setCheckValidMinute(short checkValidMinute) {
		this.checkValidMinute = checkValidMinute;
	}
	public short getEtc() {
		return etc;
	}
	public void setEtc(short etc) {
		this.etc = etc;
	}
	
	
	
}
