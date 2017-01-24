package com.egsbc.ws;

public class MediaTraceVO {
	
	private String msgType;
	private String callId;
	private String time;
	private String lStatus;
	private String lType;
	private String rStatus;
	private String rType;
	private String aIp;
	private String aPort;
	private String bIp;
	private String bPort;
	private String cIp;
	private String cPort;
	private String dIp;
	private String dPort;
	private String msgLen;
	private String msg;
	


	public MediaTraceVO(String msgType, String callId, String time, String lStatus, String lType, String rStatus,
			String rType, String aIp, String aPort, String bIp, String bPort, String cIp, String cPort, String dIp,
			String dPort, String msgLen, String msg) {
		super();
		this.msgType = msgType;
		this.callId = callId;
		this.time = time;
		this.lStatus = lStatus;
		this.lType = lType;
		this.rStatus = rStatus;
		this.rType = rType;
		this.aIp = aIp;
		this.aPort = aPort;
		this.bIp = bIp;
		this.bPort = bPort;
		this.cIp = cIp;
		this.cPort = cPort;
		this.dIp = dIp;
		this.dPort = dPort;
		this.msgLen = msgLen;
		this.msg = msg;
	}



	public String getMsgType() {
		return msgType;
	}


	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	public String getCallId() {
		return callId;
	}


	public void setCallId(String callId) {
		this.callId = callId;
	}




	public String getTime() {
		return time;
	}




	public void setTime(String time) {
		this.time = time;
	}




	public String getlStatus() {
		return lStatus;
	}




	public void setlStatus(String lStatus) {
		this.lStatus = lStatus;
	}




	public String getlType() {
		return lType;
	}




	public void setlType(String lType) {
		this.lType = lType;
	}




	public String getrStatus() {
		return rStatus;
	}




	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}




	public String getrType() {
		return rType;
	}




	public void setrType(String rType) {
		this.rType = rType;
	}




	public String getaIp() {
		return aIp;
	}




	public void setaIp(String aIp) {
		this.aIp = aIp;
	}




	public String getaPort() {
		return aPort;
	}




	public void setaPort(String aPort) {
		this.aPort = aPort;
	}




	public String getbIp() {
		return bIp;
	}




	public void setbIp(String bIp) {
		this.bIp = bIp;
	}




	public String getbPort() {
		return bPort;
	}




	public void setbPort(String bPort) {
		this.bPort = bPort;
	}




	public String getcIp() {
		return cIp;
	}




	public void setcIp(String cIp) {
		this.cIp = cIp;
	}




	public String getcPort() {
		return cPort;
	}




	public void setcPort(String cPort) {
		this.cPort = cPort;
	}




	public String getdIp() {
		return dIp;
	}




	public void setdIp(String dIp) {
		this.dIp = dIp;
	}




	public String getdPort() {
		return dPort;
	}




	public void setdPort(String dPort) {
		this.dPort = dPort;
	}




	public String getMsgLen() {
		return msgLen;
	}




	public void setMsgLen(String msgLen) {
		this.msgLen = msgLen;
	}




	public String getMsg() {
		return msg;
	}




	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
	
}
