package com.egsbc.configuration;

public class ServiceConfigurationVO {
	private short tlsSupportVersion;
	private short verifyType;
	private short certificationType;
	private short verify;
	public short getTlsSupportVersion() {
		return tlsSupportVersion;
	}
	public void setTlsSupportVersion(short tlsSupportVersion) {
		this.tlsSupportVersion = tlsSupportVersion;
	}
	public short getVerifyType() {
		return verifyType;
	}
	public void setVerifyType(short verifyType) {
		this.verifyType = verifyType;
	}
	public short getCertificationType() {
		return certificationType;
	}
	public void setCertificationType(short certificationType) {
		this.certificationType = certificationType;
	}
	public short getVerify() {
		return verify;
	}
	public void setVerify(short verify) {
		this.verify = verify;
	}
	
	
	
	
}
