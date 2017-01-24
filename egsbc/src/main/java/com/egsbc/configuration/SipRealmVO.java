package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipRealmVO extends IPCMsgVO{
	
	private String serviceName;
	
	private String name;
	private short elemType;
	private String	domain;
	private	String	 groupName;
	private	String	 sigTransName;
	private	String mediaTransName;
	private	short mediaPassFlag;
	private	short srtpFlag;
	private	int	 regPeriod = 3600;
	private	int regPeriodNat = 60;
	private	short regPeriodBypass;
	private short sessionFlag;
	private	int	 sessionExpires = 0;
	private	int	 sessionMinse = 0;
	private	short deregDeactFlag;
	private short endPointType;
	
	
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public short getSessionFlag() {
		return sessionFlag;
	}
	public void setSessionFlag(short sessionFlag) {
		this.sessionFlag = sessionFlag;
	}
	public short getEndPointType() {
		return endPointType;
	}
	public void setEndPointType(short endPointType) {
		this.endPointType = endPointType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	public int getRegPeriodNat() {
		return regPeriodNat;
	}
	public void setRegPeriodNat(int regPeriodNat) {
		this.regPeriodNat = regPeriodNat;
	}
	public short getRegPeriodBypass() {
		return regPeriodBypass;
	}
	public void setRegPeriodBypass(short regPeriodBypass) {
		this.regPeriodBypass = regPeriodBypass;
	}
	public int getSessionExpires() {
		return sessionExpires;
	}
	public void setSessionExpires(int sessionExpires) {
		this.sessionExpires = sessionExpires;
	}
	
	public int getSessionMinse() {
		return sessionMinse;
	}
	public void setSessionMinse(int sessionMinse) {
		this.sessionMinse = sessionMinse;
	}
	public short getDeregDeactFlag() {
		return deregDeactFlag;
	}
	public void setDeregDeactFlag(short deregDeactFlag) {
		this.deregDeactFlag = deregDeactFlag;
	}
	
	
	
}
