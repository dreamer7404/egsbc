package com.egsbc.report;

public class CheckValidityHistoryVO {
	private int idx;
	private short side;
	private short mode;
	private short fileType;
	private String checkTime;
	private short checkResult;
	private String errorStatement;
	private String errorAction;
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
	public short getFileType() {
		return fileType;
	}
	public void setFileType(short fileType) {
		this.fileType = fileType;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public short getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(short checkResult) {
		this.checkResult = checkResult;
	}
	public String getErrorStatement() {
		return errorStatement;
	}
	public void setErrorStatement(String errorStatement) {
		this.errorStatement = errorStatement;
	}
	public String getErrorAction() {
		return errorAction;
	}
	public void setErrorAction(String errorAction) {
		this.errorAction = errorAction;
	}
	
	
	
	

}
