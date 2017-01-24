package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecCallPatternVO extends IPCMsgVO {
	private int	limitEnable;		// 최대 CALL 제한 보안정책 사용여부 
	private int limitMaxCalls;	// 최대call수
	private int limitDurationM;	// 최대call 분
	private int totalEnable; // 최대 CALL 초과시 차단정책 사용여부
	private int totalDurationM; // 차단시간(분)
	private int totalDurationH; // 차단시간(시간)
	
	public int getLimitEnable() {
		return limitEnable;
	}
	public void setLimitEnable(int limitEnable) {
		this.limitEnable = limitEnable;
	}
	public int getLimitMaxCalls() {
		return limitMaxCalls;
	}
	public void setLimitMaxCalls(int limitMaxCalls) {
		this.limitMaxCalls = limitMaxCalls;
	}
	public int getLimitDurationM() {
		return limitDurationM;
	}
	public void setLimitDurationM(int limitDurationM) {
		this.limitDurationM = limitDurationM;
	}
	public int getTotalEnable() {
		return totalEnable;
	}
	public void setTotalEnable(int totalEnable) {
		this.totalEnable = totalEnable;
	}
	public int getTotalDurationM() {
		return totalDurationM;
	}
	public void setTotalDurationM(int totalDurationM) {
		this.totalDurationM = totalDurationM;
	}
	public int getTotalDurationH() {
		return totalDurationH;
	}
	public void setTotalDurationH(int totalDurationH) {
		this.totalDurationH = totalDurationH;
	}
	
	
}
