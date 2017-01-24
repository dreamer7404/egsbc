package com.egsbc.alarm;

import com.egsbc.common.IPCMsgVO;

public class AlarmDataDetailVO extends IPCMsgVO {
	private short rateLimitProfile; // 0: off,  other:on
	private short rateLimitCategory; // 0:system, 1: un-regi user, 2: regi user, 3: server
	private String alarmCauseParam; 
	private String alarmCauseRealValue; 
	
	private short protocol;  // 1:udp, 2:tcp, 4: tls, 5: icmp
	private String remoteIp;
	private short remotePort;
	private String localIp;
	private short localPort;
	private String fromUri;
	private String toUri;
	
	
	public short getRateLimitProfile() {
		return rateLimitProfile;
	}
	public void setRateLimitProfile(short rateLimitProfile) {
		this.rateLimitProfile = rateLimitProfile;
	}
	public short getRateLimitCategory() {
		return rateLimitCategory;
	}
	public void setRateLimitCategory(short rateLimitCategory) {
		this.rateLimitCategory = rateLimitCategory;
	}
	public String getAlarmCauseParam() {
		return alarmCauseParam;
	}
	public void setAlarmCauseParam(String alarmCauseParam) {
		this.alarmCauseParam = alarmCauseParam;
	}
	public String getAlarmCauseRealValue() {
		return alarmCauseRealValue;
	}
	public void setAlarmCauseRealValue(String alarmCauseRealValue) {
		this.alarmCauseRealValue = alarmCauseRealValue;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public short getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(short remotePort) {
		this.remotePort = remotePort;
	}
	public String getLocalIp() {
		return localIp;
	}
	public void setLocalIp(String localIp) {
		this.localIp = localIp;
	}
	public short getLocalPort() {
		return localPort;
	}
	public void setLocalPort(short localPort) {
		this.localPort = localPort;
	}
	public String getFromUri() {
		return fromUri;
	}
	public void setFromUri(String fromUri) {
		this.fromUri = fromUri;
	}
	public String getToUri() {
		return toUri;
	}
	public void setToUri(String toUri) {
		this.toUri = toUri;
	}
	public short getProtocol() {
		return protocol;
	}
	public void setProtocol(short protocol) {
		this.protocol = protocol;
	}
	
	
	
	
	
	
}
