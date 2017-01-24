package com.egsbc.statistics;

import com.egsbc.common.PageVO;

public class StaticCallVO extends PageVO {
	private String keyCall;
	private String caller;
	private String callee;
	private short type;
	private short callState;
	private String intfCallerIp;
	private int intfCallerPort;
	private String intfCalleeIp;
	private int intfCalleePort;
	private String timeStarted;
	private String timeConnected;
	private String timeDisconnected;
	private int timeCall;
	private short dropper;
	private int rCode;
	private short reason;
	private String debugInfo;
	private short extReserved1;
	private short extReserved2;
	private String extReserved3;
	private String extReserved4;
	
	// search
	private String date1;
	private String date2;
	
	// cnt
	private int cntAll;
	private int cntCalling;
	
	// for search caller & callee
	private String userId;
		
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCntAll() {
		return cntAll;
	}

	public void setCntAll(int cntAll) {
		this.cntAll = cntAll;
	}

	public int getCntCalling() {
		return cntCalling;
	}

	public void setCntCalling(int cntCalling) {
		this.cntCalling = cntCalling;
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

	public int getTimeCall() {
		return timeCall;
	}

	public void setTimeCall(int timeCall) {
		this.timeCall = timeCall;
	}

	public String getKeyCall() {
		return keyCall;
	}

	public void setKeyCall(String keyCall) {
		this.keyCall = keyCall;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public String getCallee() {
		return callee;
	}

	public void setCallee(String callee) {
		this.callee = callee;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public short getCallState() {
		return callState;
	}

	public void setCallState(short callState) {
		this.callState = callState;
	}

	public String getIntfCallerIp() {
		return intfCallerIp;
	}

	public void setIntfCallerIp(String intfCallerIp) {
		this.intfCallerIp = intfCallerIp;
	}

	public int getIntfCallerPort() {
		return intfCallerPort;
	}

	public void setIntfCallerPort(int intfCallerPort) {
		this.intfCallerPort = intfCallerPort;
	}

	public String getIntfCalleeIp() {
		return intfCalleeIp;
	}

	public void setIntfCalleeIp(String intfCalleeIp) {
		this.intfCalleeIp = intfCalleeIp;
	}

	public int getIntfCalleePort() {
		return intfCalleePort;
	}

	public void setIntfCalleePort(int intfCalleePort) {
		this.intfCalleePort = intfCalleePort;
	}

	public String getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(String timeStarted) {
		this.timeStarted = timeStarted;
	}

	public String getTimeConnected() {
		return timeConnected;
	}

	public void setTimeConnected(String timeConnected) {
		this.timeConnected = timeConnected;
	}

	public String getTimeDisconnected() {
		return timeDisconnected;
	}

	public void setTimeDisconnected(String timeDisconnected) {
		this.timeDisconnected = timeDisconnected;
	}

	public short getDropper() {
		return dropper;
	}

	public void setDropper(short dropper) {
		this.dropper = dropper;
	}

	public int getrCode() {
		return rCode;
	}

	public void setrCode(int rCode) {
		this.rCode = rCode;
	}

	public short getReason() {
		return reason;
	}

	public void setReason(short reason) {
		this.reason = reason;
	}

	public String getDebugInfo() {
		return debugInfo;
	}

	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}

	public short getExtReserved1() {
		return extReserved1;
	}

	public void setExtReserved1(short extReserved1) {
		this.extReserved1 = extReserved1;
	}

	public short getExtReserved2() {
		return extReserved2;
	}

	public void setExtReserved2(short extReserved2) {
		this.extReserved2 = extReserved2;
	}

	public String getExtReserved3() {
		return extReserved3;
	}

	public void setExtReserved3(String extReserved3) {
		this.extReserved3 = extReserved3;
	}

	public String getExtReserved4() {
		return extReserved4;
	}

	public void setExtReserved4(String extReserved4) {
		this.extReserved4 = extReserved4;
	}

	
	
	
}
