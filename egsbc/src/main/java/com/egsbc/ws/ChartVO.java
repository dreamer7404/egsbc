package com.egsbc.ws;

public class ChartVO {
	private String msgType;
	
	private short chartIndex;
	private String chartTitle;
	private int dataCnt;
	private String legendArray;
	private String colorArray;
	private String dateTime;
	private String dataArray;
	private String unitArray; // 단위
	
	
	
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getUnitArray() {
		return unitArray;
	}
	public void setUnitArray(String unitArray) {
		this.unitArray = unitArray;
	}
	public int getDataCnt() {
		return dataCnt;
	}
	public void setDataCnt(int dataCnt) {
		this.dataCnt = dataCnt;
	}
	public short getChartIndex() {
		return chartIndex;
	}
	public void setChartIndex(short chartIndex) {
		this.chartIndex = chartIndex;
	}
	public String getChartTitle() {
		return chartTitle;
	}
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}
	public String getLegendArray() {
		return legendArray;
	}
	public void setLegendArray(String legendArray) {
		this.legendArray = legendArray;
	}
	public String getColorArray() {
		return colorArray;
	}
	public void setColorArray(String colorArray) {
		this.colorArray = colorArray;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getDataArray() {
		return dataArray;
	}
	public void setDataArray(String dataArray) {
		this.dataArray = dataArray;
	}
	
	
	
	
	
}
