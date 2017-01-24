package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecSpamCallVO extends IPCMsgVO {
	private int limitEnable;
	private int limitCount;
	
	private int durationEnable;
	private int durationCount;
	private int durationS;
	
	private int intervalEnable;
	private int intervalCount;
	private int intervalS;
	
	private int rejectEnable;
	private int rejectCount;
	
	public int getLimitEnable() {
		return limitEnable;
	}
	public void setLimitEnable(int limitEnable) {
		this.limitEnable = limitEnable;
	}
	public int getLimitCount() {
		return limitCount;
	}
	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
	}
	public int getDurationEnable() {
		return durationEnable;
	}
	public void setDurationEnable(int durationEnable) {
		this.durationEnable = durationEnable;
	}
	public int getDurationCount() {
		return durationCount;
	}
	public void setDurationCount(int durationCount) {
		this.durationCount = durationCount;
	}
	public int getDurationS() {
		return durationS;
	}
	public void setDurationS(int durationS) {
		this.durationS = durationS;
	}
	public int getIntervalEnable() {
		return intervalEnable;
	}
	public void setIntervalEnable(int intervalEnable) {
		this.intervalEnable = intervalEnable;
	}
	public int getIntervalCount() {
		return intervalCount;
	}
	public void setIntervalCount(int intervalCount) {
		this.intervalCount = intervalCount;
	}
	public int getIntervalS() {
		return intervalS;
	}
	public void setIntervalS(int intervalS) {
		this.intervalS = intervalS;
	}
	public int getRejectEnable() {
		return rejectEnable;
	}
	public void setRejectEnable(int rejectEnable) {
		this.rejectEnable = rejectEnable;
	}
	public int getRejectCount() {
		return rejectCount;
	}
	public void setRejectCount(int rejectCount) {
		this.rejectCount = rejectCount;
	}
	
	
}
