package com.egsbc.ws;

import java.util.concurrent.Future;

import org.springframework.web.socket.WebSocketSession;

public class TraceVO {
	private String key;
	private Future<?> future;
	private WebSocketSession session;
	
	private String msgType;
	private String msgMode;
	
	private String traceCmd;
	private String createdTime;
	private String traceType;
	private String condition;
	private int duration;
	
	
	public TraceVO(){}
	
	public TraceVO(WebSocketSession session, String traceCmd, String traceType, String condition, int duration){
		this.key = session.getId() + traceType + condition;
		this.session = session;
		this.traceCmd = traceCmd;
		this.traceType = traceType;
		this.condition = condition;
		this.duration = duration;
	}
	
	/*
	 * to Web for Add
	 */
	public TraceVO(String msgType, String msgMode, String traceCmd, String createdTime, String traceType, String condition){
		this.msgType = msgType;
		this.msgMode = msgMode;
		this.traceCmd = traceCmd;
		this.createdTime = createdTime;
		this.traceType = traceType;
		this.condition = condition;
	}
	/*
	 * to Web for Delete
	 */
	public TraceVO(String msgType, String msgMode, String createdTime){
		this.msgType = msgType;
		this.msgMode = msgMode;
		this.createdTime = createdTime;
	}
	
	
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public Future<?> getFuture() {
		return future;
	}

	public void setFuture(Future<?> future) {
		this.future = future;
	}

	public WebSocketSession getSession() {
		return session;
	}
	public void setSession(WebSocketSession session) {
		this.session = session;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	
}
