package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipConfigCertificationVO extends IPCMsgVO {
	private short tlsVersion;
	private short tlsMode; 		//0: RSA, 1:ECC
	private short certType;		// 0:PEM, 1:DER
	private String DerPassword; // 128 bytes
	private short verify;
	
	// file info.
	private String fileName;
	private long fileSize;
	private String fileDate;
	
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public short getTlsVersion() {
		return tlsVersion;
	}
	public void setTlsVersion(short tlsVersion) {
		this.tlsVersion = tlsVersion;
	}
	public short getTlsMode() {
		return tlsMode;
	}
	public void setTlsMode(short tlsMode) {
		this.tlsMode = tlsMode;
	}
	public short getCertType() {
		return certType;
	}
	public void setCertType(short certType) {
		this.certType = certType;
	}
	public String getDerPassword() {
		return DerPassword;
	}
	public void setDerPassword(String derPassword) {
		DerPassword = derPassword;
	}
	public short getVerify() {
		return verify;
	}
	public void setVerify(short verify) {
		this.verify = verify;
	}
	
	
	
}
