package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class NtpDateVO extends IPCMsgVO {

	private short ntpCommand;
	private short side;
	private String directlySystemDatetime;
	private short onOffFlag;
	private String ntpServerIp;
	private short ntpReserved;
	
	public short getNtpCommand() {
		return ntpCommand;
	}
	public void setNtpCommand(short ntpCommand) {
		this.ntpCommand = ntpCommand;
	}
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public String getDirectlySystemDatetime() {
		return directlySystemDatetime;
	}
	public void setDirectlySystemDatetime(String directlySystemDatetime) {
		this.directlySystemDatetime = directlySystemDatetime;
	}
	public short getOnOffFlag() {
		return onOffFlag;
	}
	public void setOnOffFlag(short onOffFlag) {
		this.onOffFlag = onOffFlag;
	}
	public String getNtpServerIp() {
		return ntpServerIp;
	}
	public void setNtpServerIp(String ntpServerIp) {
		this.ntpServerIp = ntpServerIp;
	}
	public short getNtpReserved() {
		return ntpReserved;
	}
	public void setNtpReserved(short ntpReserved) {
		this.ntpReserved = ntpReserved;
	}
	
	
	
	
}
