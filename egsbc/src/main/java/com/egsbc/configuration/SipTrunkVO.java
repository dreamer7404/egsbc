package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipTrunkVO extends IPCMsgVO {
	
	// for easy
	private String serviceName;
	private String elem1; // to get peerIp2, peerPort2, sigTransName2
	
	private String name;
	private short elemType;
	private String domain;
	private String groupName;
	private short peerIpType;
	private String peerIp;
	private int peerPort = 0;
	private String sigTransName;
	private String mediaTransName;
	private short mediaPassFlag;
	private short srtpFlag;
	private int regPeriod = 3600;
	private short registerFlag; // 데리레지 지원
	private String registerUserId;
	private String registerDomain;
	private String registerAuthId;
	private String registerAuthPw;
	private short policySpamFlag;
	private int maxCps = 0;
	private int maxSession = 0;
	private short pollingStatus;
	private String pollingTime;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getElem1() {
		return elem1;
	}
	public void setElem1(String elem1) {
		this.elem1 = elem1;
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
	public short getPeerIpType() {
		return peerIpType;
	}
	public void setPeerIpType(short peerIpType) {
		this.peerIpType = peerIpType;
	}
	public String getPeerIp() {
		return peerIp;
	}
	public void setPeerIp(String peerIp) {
		this.peerIp = peerIp;
	}
	public int getPeerPort() {
		return peerPort;
	}
	public void setPeerPort(int peerPort) {
		this.peerPort = peerPort;
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
	public short getMediaPassFlag() {
		return mediaPassFlag;
	}
	public void setMediaPassFlag(short mediaPassFlag) {
		this.mediaPassFlag = mediaPassFlag;
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
	public short getRegisterFlag() {
		return registerFlag;
	}
	public void setRegisterFlag(short registerFlag) {
		this.registerFlag = registerFlag;
	}
	public String getRegisterUserId() {
		return registerUserId;
	}
	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}
	public String getRegisterDomain() {
		return registerDomain;
	}
	public void setRegisterDomain(String registerDomain) {
		this.registerDomain = registerDomain;
	}
	public String getRegisterAuthId() {
		return registerAuthId;
	}
	public void setRegisterAuthId(String registerAuthId) {
		this.registerAuthId = registerAuthId;
	}
	public String getRegisterAuthPw() {
		return registerAuthPw;
	}
	public void setRegisterAuthPw(String registerAuthPw) {
		this.registerAuthPw = registerAuthPw;
	}
	public short getPolicySpamFlag() {
		return policySpamFlag;
	}
	public void setPolicySpamFlag(short policySpamFlag) {
		this.policySpamFlag = policySpamFlag;
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
	
	
	
	
	
}
