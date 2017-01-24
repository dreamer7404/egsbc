package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecUserAgentVO extends IPCMsgVO {
	private int policyMode;
	private int	condMethod;
	private int	condHeader;
	private String	condVal;
	
	public int getPolicyMode() {
		return policyMode;
	}
	public void setPolicyMode(int policyMode) {
		this.policyMode = policyMode;
	}
	public int getCondMethod() {
		return condMethod;
	}
	public void setCondMethod(int condMethod) {
		this.condMethod = condMethod;
	}
	public int getCondHeader() {
		return condHeader;
	}
	public void setCondHeader(int condHeader) {
		this.condHeader = condHeader;
	}
	public String getCondVal() {
		return condVal;
	}
	public void setCondVal(String condVal) {
		this.condVal = condVal;
	}
	
	
}
