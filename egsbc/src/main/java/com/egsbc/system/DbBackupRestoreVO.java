package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class DbBackupRestoreVO extends IPCMsgVO {
	private String dbName;
	private String fileName;
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
