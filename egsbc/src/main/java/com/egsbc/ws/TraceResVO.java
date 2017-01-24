package com.egsbc.ws;

public class TraceResVO {
	private String msgType;
	private String msgMode;	// ok, error
	private String traceCmd; // add, del
	private String traceType; // num, ip, all
	private String condition; // 07012341234
	
	public TraceResVO(String msgType, String msgMode, String traceCmd, String traceType, String condition) {
		super();
		this.msgType = msgType;
		this.msgMode = msgMode;
		this.traceCmd = traceCmd;
		this.traceType = traceType;
		this.condition = condition;
	}
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getTraceCmd() {
		return traceCmd;
	}
	public void setTraceCmd(String traceCmd) {
		this.traceCmd = traceCmd;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getTraceType() {
		return traceType;
	}
	public void setTraceType(String traceType) {
		this.traceType = traceType;
	}

	public String getMsgMode() {
		return msgMode;
	}

	public void setMsgMode(String msgMode) {
		this.msgMode = msgMode;
	}
	
	
	
}
