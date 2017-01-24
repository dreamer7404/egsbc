package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecGeoIpVO extends IPCMsgVO{
	private int policyMode;
	private String condVal;
	
	public int getPolicyMode() {
		return policyMode;
	}
	public void setPolicyMode(int policyMode) {
		this.policyMode = policyMode;
	}
	public String getCondVal() {
		return condVal;
	}
	public void setCondVal(String condVal) {
		this.condVal = condVal;
	}
	
	
}
