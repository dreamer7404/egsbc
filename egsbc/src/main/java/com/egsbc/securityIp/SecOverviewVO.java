package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecOverviewVO extends IPCMsgVO {
	
	private int secOvUagentMode;
	private int secOvUagentPolicy; // add
	private int secOvGeoIpMode;
	private int secOvCallPatternMode;
	private int secOvCallOverseasMode;
	private int secOvCallOverseasPolicy; // add
	private int secOvCallGappingMode;
	private int secOvImSignatureMode;
	
	
	
	
	public int getSecOvUagentPolicy() {
		return secOvUagentPolicy;
	}
	public void setSecOvUagentPolicy(int secOvUagentPolicy) {
		this.secOvUagentPolicy = secOvUagentPolicy;
	}
	public int getSecOvCallOverseasPolicy() {
		return secOvCallOverseasPolicy;
	}
	public void setSecOvCallOverseasPolicy(int secOvCallOverseasPolicy) {
		this.secOvCallOverseasPolicy = secOvCallOverseasPolicy;
	}
	public int getSecOvUagentMode() {
		return secOvUagentMode;
	}
	public void setSecOvUagentMode(int secOvUagentMode) {
		this.secOvUagentMode = secOvUagentMode;
	}
	public int getSecOvGeoIpMode() {
		return secOvGeoIpMode;
	}
	public void setSecOvGeoIpMode(int secOvGeoIpMode) {
		this.secOvGeoIpMode = secOvGeoIpMode;
	}
	public int getSecOvCallPatternMode() {
		return secOvCallPatternMode;
	}
	public void setSecOvCallPatternMode(int secOvCallPatternMode) {
		this.secOvCallPatternMode = secOvCallPatternMode;
	}
	public int getSecOvCallOverseasMode() {
		return secOvCallOverseasMode;
	}
	public void setSecOvCallOverseasMode(int secOvCallOverseasMode) {
		this.secOvCallOverseasMode = secOvCallOverseasMode;
	}
	public int getSecOvCallGappingMode() {
		return secOvCallGappingMode;
	}
	public void setSecOvCallGappingMode(int secOvCallGappingMode) {
		this.secOvCallGappingMode = secOvCallGappingMode;
	}
	public int getSecOvImSignatureMode() {
		return secOvImSignatureMode;
	}
	public void setSecOvImSignatureMode(int secOvImSignatureMode) {
		this.secOvImSignatureMode = secOvImSignatureMode;
	}
	
	
}
