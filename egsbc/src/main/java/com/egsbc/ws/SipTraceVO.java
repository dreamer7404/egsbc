package com.egsbc.ws;

public class SipTraceVO {
	
	private String msgType;
	
	private String method;
	private String code;
	private String callId;
	private String time;
	private String from;
	private String to;
	private String protocol;
	
	private String src; // src_a, src_b, src_c, src_d
	private String srcIp;
	private String srcPort; // src port
	
	private String dst;// dst_a, dst_b, dst_c,dst_d
	private String dstIp;
	private String dstPort;
	
	private String msgLen;
	private String msg;
	
	
	
	
	public SipTraceVO(String msgType, String method, String code, String callId, String time, String from, String to, String protocol,
			String src, String srcIp, String srcPort, String dst, String dstIp, String dstPort, String msgLen, String msg) {
		super();
		this.msgType = msgType;
		this.method = method;
		this.code = code;
		this.callId = callId;
		this.time = time;
		this.from = from;
		this.to = to;
		this.protocol = protocol;
		this.src = src;
		this.srcIp = srcIp;
		this.srcPort = srcPort;
		this.dst = dst;
		this.dstIp = dstIp;
		this.dstPort = dstPort;
		this.msgLen = msgLen;
		this.msg = msg;
	}
	
	
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}


	public String getSrcPort() {
		return srcPort;
	}

	public void setSrcPort(String srcPort) {
		this.srcPort = srcPort;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}


	public String getSrcIp() {
		return srcIp;
	}


	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}


	public String getDstIp() {
		return dstIp;
	}


	public void setDstIp(String dstIp) {
		this.dstIp = dstIp;
	}


	public String getDstPort() {
		return dstPort;
	}

	public void setDstPort(String dstPort) {
		this.dstPort = dstPort;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getMsgLen() {
		return msgLen;
	}


	public void setMsgLen(String msgLen) {
		this.msgLen = msgLen;
	}
	
	
	
	
	
	
}
