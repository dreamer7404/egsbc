package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipConfigServiceVO extends IPCMsgVO {

	private short provider;
	private int ringBackTimeout;
	private int responseTimeout;
	private int actCount;
	private int actInterval;
	private int failCount;
	private int failInterval;
	private short switchOn;
	private short passertMode;
	private short caEnable;
	private int caInterval;
	private short caForceDrop;
	private short srtpEncType;
	
	public short getProvider() {
		return provider;
	}
	public void setProvider(short provider) {
		this.provider = provider;
	}
	public int getRingBackTimeout() {
		return ringBackTimeout;
	}
	public void setRingBackTimeout(int ringBackTimeout) {
		this.ringBackTimeout = ringBackTimeout;
	}
	public int getResponseTimeout() {
		return responseTimeout;
	}
	public void setResponseTimeout(int responseTimeout) {
		this.responseTimeout = responseTimeout;
	}
	public int getActCount() {
		return actCount;
	}
	public void setActCount(int actCount) {
		this.actCount = actCount;
	}
	public int getActInterval() {
		return actInterval;
	}
	public void setActInterval(int actInterval) {
		this.actInterval = actInterval;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public int getFailInterval() {
		return failInterval;
	}
	public void setFailInterval(int failInterval) {
		this.failInterval = failInterval;
	}
	public short getSwitchOn() {
		return switchOn;
	}
	public void setSwitchOn(short switchOn) {
		this.switchOn = switchOn;
	}
	public short getPassertMode() {
		return passertMode;
	}
	public void setPassertMode(short passertMode) {
		this.passertMode = passertMode;
	}
	public short getCaEnable() {
		return caEnable;
	}
	public void setCaEnable(short caEnable) {
		this.caEnable = caEnable;
	}
	public int getCaInterval() {
		return caInterval;
	}
	public void setCaInterval(int caInterval) {
		this.caInterval = caInterval;
	}
	public short getCaForceDrop() {
		return caForceDrop;
	}
	public void setCaForceDrop(short caForceDrop) {
		this.caForceDrop = caForceDrop;
	}
	public short getSrtpEncType() {
		return srtpEncType;
	}
	public void setSrtpEncType(short srtpEncType) {
		this.srtpEncType = srtpEncType;
	}
	
	
	
	
}
