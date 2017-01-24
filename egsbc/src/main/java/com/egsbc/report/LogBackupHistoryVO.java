package com.egsbc.report;

public class LogBackupHistoryVO {
	private int idx;
	private short side;
	private short mode;
	private String backupTime;
	private String backupLogName;
	private String backupFileName;
	
	public LogBackupHistoryVO(){}
	

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public short getMode() {
		return mode;
	}
	public void setMode(short mode) {
		this.mode = mode;
	}
	public String getBackupTime() {
		return backupTime;
	}
	public void setBackupTime(String backupTime) {
		this.backupTime = backupTime;
	}


	public String getBackupLogName() {
		return backupLogName;
	}


	public void setBackupLogName(String backupLogName) {
		this.backupLogName = backupLogName;
	}


	public String getBackupFileName() {
		return backupFileName;
	}
	public void setBackupFileName(String backupFileName) {
		this.backupFileName = backupFileName;
	}
	
	
	
}
