package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class NtpConfigVO extends IPCMsgVO {
	private short side;
	private short clientFlag;
	private short serverFlag;
	private short periodicHour;
	private int intReserved;
	
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public short getClientFlag() {
		return clientFlag;
	}
	public void setClientFlag(short clientFlag) {
		this.clientFlag = clientFlag;
	}
	public short getPeriodicHour() {
		return periodicHour;
	}
	public void setPeriodicHour(short periodicHour) {
		this.periodicHour = periodicHour;
	}
	public int getIntReserved() {
		return intReserved;
	}
	public void setIntReserved(int intReserved) {
		this.intReserved = intReserved;
	}
	public short getServerFlag() {
		return serverFlag;
	}
	public void setServerFlag(short serverFlag) {
		this.serverFlag = serverFlag;
	}
	
	
	
}
