package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class NtpVO extends IPCMsgVO {
	
//	private String timeMode;
//	private String timeServerMode;
//	private String minPoll;
//	private String maxPoll;
//	
//	private String serverName;
	
	
	private short systemDateTimeMode;
	private short ntpClientMinPoll;
	private short ntpClientMaxPoll;
	private String staticSystemDateTime;
	private short ntpServerMode;
	private String ntpServerRestrictIp;
	private short ntpServerRestrictIpPrifixLen;
	private String ntpHost;
	
	
	public short getSystemDateTimeMode() {
		return systemDateTimeMode;
	}
	public void setSystemDateTimeMode(short systemDateTimeMode) {
		this.systemDateTimeMode = systemDateTimeMode;
	}
	public short getNtpClientMinPoll() {
		return ntpClientMinPoll;
	}
	public void setNtpClientMinPoll(short ntpClientMinPoll) {
		this.ntpClientMinPoll = ntpClientMinPoll;
	}
	public short getNtpClientMaxPoll() {
		return ntpClientMaxPoll;
	}
	public void setNtpClientMaxPoll(short ntpClientMaxPoll) {
		this.ntpClientMaxPoll = ntpClientMaxPoll;
	}
	public String getStaticSystemDateTime() {
		return staticSystemDateTime;
	}
	public void setStaticSystemDateTime(String staticSystemDateTime) {
		this.staticSystemDateTime = staticSystemDateTime;
	}
	public short getNtpServerMode() {
		return ntpServerMode;
	}
	public void setNtpServerMode(short ntpServerMode) {
		this.ntpServerMode = ntpServerMode;
	}
	public String getNtpServerRestrictIp() {
		return ntpServerRestrictIp;
	}
	public void setNtpServerRestrictIp(String ntpServerRestrictIp) {
		this.ntpServerRestrictIp = ntpServerRestrictIp;
	}
	public short getNtpServerRestrictIpPrifixLen() {
		return ntpServerRestrictIpPrifixLen;
	}
	public void setNtpServerRestrictIpPrifixLen(short ntpServerRestrictIpPrifixLen) {
		this.ntpServerRestrictIpPrifixLen = ntpServerRestrictIpPrifixLen;
	}
	public String getNtpHost() {
		return ntpHost;
	}
	public void setNtpHost(String ntpHost) {
		this.ntpHost = ntpHost;
	}
	
	
	
	
	

	
	
	
	
}
