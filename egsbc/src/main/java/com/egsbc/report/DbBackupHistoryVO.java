package com.egsbc.report;

public class DbBackupHistoryVO {
	private int idx;
	private short side;
	private short mode;
	private String backupTime;
	private String backupDbName;
	private String backupFileName;
	
	public DbBackupHistoryVO(){}
	
	public DbBackupHistoryVO(String backupDbName, String backupFileName) {
		super();
		this.backupDbName = backupDbName;
		this.backupFileName = backupFileName;
	}

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
	public String getBackupDbName() {
		return backupDbName;
	}
	public void setBackupDbName(String backupDbName) {
		this.backupDbName = backupDbName;
	}
	public String getBackupFileName() {
		return backupFileName;
	}
	public void setBackupFileName(String backupFileName) {
		this.backupFileName = backupFileName;
	}
	
	
	
}
