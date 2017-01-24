package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecCallOverseasVO extends IPCMsgVO {
	private int policyMode;
	private int limitMaxCalls;
	private int limitDurationS;
	private String condVal;
	
	public int getPolicyMode() {
		return policyMode;
	}
	public void setPolicyMode(int policyMode) {
		this.policyMode = policyMode;
	}
	public int getLimitMaxCalls() {
		return limitMaxCalls;
	}
	public void setLimitMaxCalls(int limitMaxCalls) {
		this.limitMaxCalls = limitMaxCalls;
	}
	public int getLimitDurationS() {
		return limitDurationS;
	}
	public void setLimitDurationS(int limitDurationS) {
		this.limitDurationS = limitDurationS;
	}
	public String getCondVal() {
		return condVal;
	}
	public void setCondVal(String condVal) {
		this.condVal = condVal;
	}
	
	
	
}
