package com.egsbc.system;

import com.egsbc.common.PageVO;

public class UserActionHistoryVO extends PageVO {
	private String id;
	private String actionTime;
	private short actionType;
	private String actionDesc;
	private short actionResult;
	private String errorReason;
	
	private String date1;
	private String date2;
	
	
	public UserActionHistoryVO(){}
	
	public UserActionHistoryVO(String id, short actionType, String actionDesc,  short actionResult, String errorReason){
		this.id = id;
		this.actionType = actionType;
		this.actionDesc = actionDesc;
		this.actionResult = actionResult;
		this.errorReason = errorReason;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActionTime() {
		return actionTime;
	}
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}
	public short getActionType() {
		return actionType;
	}
	public void setActionType(short actionType) {
		this.actionType = actionType;
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	public short getActionResult() {
		return actionResult;
	}
	public void setActionResult(short actionResult) {
		this.actionResult = actionResult;
	}
	public String getErrorReason() {
		return errorReason;
	}
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	
	
}
