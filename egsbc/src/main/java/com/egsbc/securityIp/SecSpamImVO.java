package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecSpamImVO extends IPCMsgVO {
	private int limitEnable;
	private int limitCount;
	private int intervalEnable;
	private int intervalCount;
	private int intervalS;
	
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
	
	
	
}
