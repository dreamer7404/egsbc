package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class TlsCertFileInfoVO extends IPCMsgVO {
	private short fileExist;
	private short applied;
	private short certChainLevel;
	private short certMode; //*
	private short fileType; //*
	private String fileName;
	private String validStartDate;
	private String validEndDate;
	private String orderedCipherList;
	private String derPassword; //*
	private short privateKeyFileEncryptFlag; //*
	
	private boolean activate; // fileExist 4개모두 있는지여부
	
	
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	public short getFileExist() {
		return fileExist;
	}
	public void setFileExist(short fileExist) {
		this.fileExist = fileExist;
	}
	public short getApplied() {
		return applied;
	}
	public void setApplied(short applied) {
		this.applied = applied;
	}
	public short getCertChainLevel() {
		return certChainLevel;
	}
	public void setCertChainLevel(short certChainLevel) {
		this.certChainLevel = certChainLevel;
	}
	public short getCertMode() {
		return certMode;
	}
	public void setCertMode(short certMode) {
		this.certMode = certMode;
	}
	public short getFileType() {
		return fileType;
	}
	public void setFileType(short fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getValidStartDate() {
		return validStartDate;
	}
	public void setValidStartDate(String validStartDate) {
		this.validStartDate = validStartDate;
	}
	public String getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(String validEndDate) {
		this.validEndDate = validEndDate;
	}
	public String getOrderedCipherList() {
		return orderedCipherList;
	}
	public void setOrderedCipherList(String orderedCipherList) {
		this.orderedCipherList = orderedCipherList;
	}
	public String getDerPassword() {
		return derPassword;
	}
	public void setDerPassword(String derPassword) {
		this.derPassword = derPassword;
	}
	public short getPrivateKeyFileEncryptFlag() {
		return privateKeyFileEncryptFlag;
	}
	public void setPrivateKeyFileEncryptFlag(short privateKeyFileEncryptFlag) {
		this.privateKeyFileEncryptFlag = privateKeyFileEncryptFlag;
	}
	
	
	
	
}
