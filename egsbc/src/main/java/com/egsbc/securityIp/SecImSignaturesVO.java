package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecImSignaturesVO extends IPCMsgVO {
	private int condHeader;
	private int condCheck;
	
	public int getCondHeader() {
		return condHeader;
	}
	public void setCondHeader(int condHeader) {
		this.condHeader = condHeader;
	}
	public int getCondCheck() {
		return condCheck;
	}
	public void setCondCheck(int condCheck) {
		this.condCheck = condCheck;
	}
	
	
}
