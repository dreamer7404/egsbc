package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class TlsConfigVO extends IPCMsgVO {
	private short tlsVersion;
	private short certType;
	private short fileType;
	private short verify;
	private short etc1;
	
	public short getTlsVersion() {
		return tlsVersion;
	}
	public void setTlsVersion(short tlsVersion) {
		this.tlsVersion = tlsVersion;
	}
	public short getCertType() {
		return certType;
	}
	public void setCertType(short certType) {
		this.certType = certType;
	}
	public short getFileType() {
		return fileType;
	}
	public void setFileType(short fileType) {
		this.fileType = fileType;
	}
	public short getVerify() {
		return verify;
	}
	public void setVerify(short verify) {
		this.verify = verify;
	}
	public short getEtc1() {
		return etc1;
	}
	public void setEtc1(short etc1) {
		this.etc1 = etc1;
	}
	
	
	
	
	
}
