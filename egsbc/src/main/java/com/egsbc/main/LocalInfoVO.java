package com.egsbc.main;

import com.egsbc.common.IPCMsgVO;

public class LocalInfoVO extends IPCMsgVO {
	private int dupSide;
	private int dupRole;
	private int dupMode;
	private int dupStatus;
	private int dupStatusXs;
	
	public int getDupSide() {
		return dupSide;
	}
	public void setDupSide(int dupSide) {
		this.dupSide = dupSide;
	}
	public int getDupRole() {
		return dupRole;
	}
	public void setDupRole(int dupRole) {
		this.dupRole = dupRole;
	}
	public int getDupMode() {
		return dupMode;
	}
	public void setDupMode(int dupMode) {
		this.dupMode = dupMode;
	}
	public int getDupStatus() {
		return dupStatus;
	}
	public void setDupStatus(int dupStatus) {
		this.dupStatus = dupStatus;
	}
	public int getDupStatusXs() {
		return dupStatusXs;
	}
	public void setDupStatusXs(int dupStatusXs) {
		this.dupStatusXs = dupStatusXs;
	}
	
	
}
