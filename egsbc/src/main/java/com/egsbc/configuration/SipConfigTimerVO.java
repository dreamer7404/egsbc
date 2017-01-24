package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class SipConfigTimerVO extends IPCMsgVO {
	private int timerT1;
	private int timerK;
	private int timerJ;
	private int timerD;
	private int timerI;
	
	public int getTimerT1() {
		return timerT1;
	}
	public void setTimerT1(int timerT1) {
		this.timerT1 = timerT1;
	}
	public int getTimerK() {
		return timerK;
	}
	public void setTimerK(int timerK) {
		this.timerK = timerK;
	}
	public int getTimerJ() {
		return timerJ;
	}
	public void setTimerJ(int timerJ) {
		this.timerJ = timerJ;
	}
	public int getTimerD() {
		return timerD;
	}
	public void setTimerD(int timerD) {
		this.timerD = timerD;
	}
	public int getTimerI() {
		return timerI;
	}
	public void setTimerI(int timerI) {
		this.timerI = timerI;
	}
	
	
}
