package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipConfigStackVO extends IPCMsgVO {
	
	private int workThreadCount;
	private int dispatchThreadCount;
	private int callObjectCount;
	private int tcpTimeout;
	private int tcpMsgSize;
	private int udpMsgSize;
	private int keepAliveTime;
	
	public int getWorkThreadCount() {
		return workThreadCount;
	}
	public void setWorkThreadCount(int workThreadCount) {
		this.workThreadCount = workThreadCount;
	}
	public int getDispatchThreadCount() {
		return dispatchThreadCount;
	}
	public void setDispatchThreadCount(int dispatchThreadCount) {
		this.dispatchThreadCount = dispatchThreadCount;
	}
	public int getCallObjectCount() {
		return callObjectCount;
	}
	public void setCallObjectCount(int callObjectCount) {
		this.callObjectCount = callObjectCount;
	}
	public int getTcpTimeout() {
		return tcpTimeout;
	}
	public void setTcpTimeout(int tcpTimeout) {
		this.tcpTimeout = tcpTimeout;
	}
	public int getTcpMsgSize() {
		return tcpMsgSize;
	}
	public void setTcpMsgSize(int tcpMsgSize) {
		this.tcpMsgSize = tcpMsgSize;
	}
	public int getUdpMsgSize() {
		return udpMsgSize;
	}
	public void setUdpMsgSize(int udpMsgSize) {
		this.udpMsgSize = udpMsgSize;
	}
	public int getKeepAliveTime() {
		return keepAliveTime;
	}
	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}
	
	
	
	
}
