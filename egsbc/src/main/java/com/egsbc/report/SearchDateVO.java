package com.egsbc.report;

import com.egsbc.common.PageVO;

public class SearchDateVO extends PageVO {
	private String startDate;
	private String endDate;
	
	private String[] argArray;
	private short alarmLevel;
	
	private short side;
	private String date1;
	private String date2;
	
	private String causeDescription; // alarmHistory
	
	
	public String getCauseDescription() {
		return causeDescription;
	}
	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
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
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String[] getArgArray() {
		return argArray;
	}
	public void setArgArray(String[] argArray) {
		this.argArray = argArray;
	}
	public short getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(short alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	

	
	
}
