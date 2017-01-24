package com.egsbc.ws;

public class MsgVO {
	private String msgType;	// received msg type (from browser)
	private String msgMode;	// return msg mode (to browser)
	private String msg;			// return msg  (to browser)
	
	// ping
	private String toIP;
	private String fromIP;
	
	// tcpdump
	private String intf;
	private String transport;
	private int port;
	
	// trace
	private String traceCmd;
	private String traceType;
	private String condition;
	
	// tcpdump, trace
	private int duration;
	
	
	public MsgVO(){}
	
	public MsgVO(String msgType, String msg){
		this.msgType = msgType;
		this.msg = msg;
	}
	
	public MsgVO(String msgType, String msgMode, String msg){
		this.msgType = msgType;
		this.msgMode = msgMode;
		this.msg = msg;
	}
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgMode() {
		return msgMode;
	}
	public void setMsgMode(String msgMode) {
		this.msgMode = msgMode;
	}
	public String getToIP() {
		return toIP;
	}
	public void setToIP(String toIP) {
		this.toIP = toIP;
	}
	public String getFromIP() {
		return fromIP;
	}
	public void setFromIP(String fromIP) {
		this.fromIP = fromIP;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getIntf() {
		return intf;
	}
	public void setIntf(String intf) {
		this.intf = intf;
	}
	
	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTraceCmd() {
		return traceCmd;
	}

	public void setTraceCmd(String traceCmd) {
		this.traceCmd = traceCmd;
	}

	public String getTraceType() {
		return traceType;
	}

	public void setTraceType(String traceType) {
		this.traceType = traceType;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
