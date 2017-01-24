package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipConfigExtVO extends IPCMsgVO {

	private int logSupport;
	private int logMsg;
	private int logInfoLevel;
	private int logInfoClass;
	
	public int getLogSupport() {
		return logSupport;
	}
	public void setLogSupport(int logSupport) {
		this.logSupport = logSupport;
	}
	public int getLogMsg() {
		return logMsg;
	}
	public void setLogMsg(int logMsg) {
		this.logMsg = logMsg;
	}
	public int getLogInfoLevel() {
		return logInfoLevel;
	}
	public void setLogInfoLevel(int logInfoLevel) {
		this.logInfoLevel = logInfoLevel;
	}
	public int getLogInfoClass() {
		return logInfoClass;
	}
	public void setLogInfoClass(int logInfoClass) {
		this.logInfoClass = logInfoClass;
	}
	
	
}
