package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipServerVO extends IPCMsgVO{
	
	private String serviceName;
	private short pollFlag;
	
	private String name;
	private short elemType;
	private String domain;
	private String groupName;
	private short serverIPType;
	private String serverIP;
	private int serverPort = 0;
	private String sigTransName;
	private String mediaTransName;
	private short srtpFlag;
	private int regPeriod = 3600;
	private int maxCps = 100;
	private int maxSession = 100;
	private int maxRps = 1000;
	private short pollingStatus;
	private String pollingTime;
	
	
	
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getElemType() {
		return elemType;
	}
	public void setElemType(short elemType) {
		this.elemType = elemType;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public short getServerIPType() {
		return serverIPType;
	}
	public void setServerIPType(short serverIPType) {
		this.serverIPType = serverIPType;
	}
	public String getServerIP() {
		return serverIP;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public String getSigTransName() {
		return sigTransName;
	}
	public void setSigTransName(String sigTransName) {
		this.sigTransName = sigTransName;
	}
	public String getMediaTransName() {
		return mediaTransName;
	}
	public void setMediaTransName(String mediaTransName) {
		this.mediaTransName = mediaTransName;
	}
	public short getSrtpFlag() {
		return srtpFlag;
	}
	public void setSrtpFlag(short srtpFlag) {
		this.srtpFlag = srtpFlag;
	}
	public int getRegPeriod() {
		return regPeriod;
	}
	public void setRegPeriod(int regPeriod) {
		this.regPeriod = regPeriod;
	}
	public int getMaxCps() {
		return maxCps;
	}
	public void setMaxCps(int maxCps) {
		this.maxCps = maxCps;
	}
	public int getMaxSession() {
		return maxSession;
	}
	public void setMaxSession(int maxSession) {
		this.maxSession = maxSession;
	}
	public int getMaxRps() {
		return maxRps;
	}
	public void setMaxRps(int maxRps) {
		this.maxRps = maxRps;
	}
	public short getPollingStatus() {
		return pollingStatus;
	}
	public void setPollingStatus(short pollingStatus) {
		this.pollingStatus = pollingStatus;
	}
	public String getPollingTime() {
		return pollingTime;
	}
	public void setPollingTime(String pollingTime) {
		this.pollingTime = pollingTime;
	}
	public short getPollFlag() {
		return pollFlag;
	}
	public void setPollFlag(short pollFlag) {
		this.pollFlag = pollFlag;
	}
	
}
