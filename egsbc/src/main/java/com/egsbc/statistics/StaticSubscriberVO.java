package com.egsbc.statistics;

import com.egsbc.common.PageVO;

public class StaticSubscriberVO extends PageVO {
	private String keySubscriber;
	private String userId;
	private String domain;
	private short forkingIndex;
	private short regState=1;
	private short reason;
	private String intfLocalIp;
	private int intfLocalPort;
	private String intfPeerIp;
	private int intfPeerPort;
	private String timeReg;
	private String timeExpire;
	private String timeUnreg;
	private short extReserved1;
	private short extReserved2;
	private String extReserved3;
	private String extReserved4;
	
	// search
	private String date1;
	private String date2;
	
	// 가입자수
	private int subscriberCntReg; 	// 등록가입자수
	private int subscriberCntAll; 		// 모든가입자수
	
	
	
	
	public int getSubscriberCntReg() {
		return subscriberCntReg;
	}
	public void setSubscriberCntReg(int subscriberCntReg) {
		this.subscriberCntReg = subscriberCntReg;
	}
	public int getSubscriberCntAll() {
		return subscriberCntAll;
	}
	public void setSubscriberCntAll(int subscriberCntAll) {
		this.subscriberCntAll = subscriberCntAll;
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
	public String getKeySubscriber() {
		return keySubscriber;
	}
	public void setKeySubscriber(String keySubscriber) {
		this.keySubscriber = keySubscriber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public short getForkingIndex() {
		return forkingIndex;
	}
	public void setForkingIndex(short forkingIndex) {
		this.forkingIndex = forkingIndex;
	}
	public short getRegState() {
		return regState;
	}
	public void setRegState(short regState) {
		this.regState = regState;
	}
	public short getReason() {
		return reason;
	}
	public void setReason(short reason) {
		this.reason = reason;
	}
	public String getIntfLocalIp() {
		return intfLocalIp;
	}
	public void setIntfLocalIp(String intfLocalIp) {
		this.intfLocalIp = intfLocalIp;
	}
	public int getIntfLocalPort() {
		return intfLocalPort;
	}
	public void setIntfLocalPort(int intfLocalPort) {
		this.intfLocalPort = intfLocalPort;
	}
	public String getIntfPeerIp() {
		return intfPeerIp;
	}
	public void setIntfPeerIp(String intfPeerIp) {
		this.intfPeerIp = intfPeerIp;
	}
	public int getIntfPeerPort() {
		return intfPeerPort;
	}
	public void setIntfPeerPort(int intfPeerPort) {
		this.intfPeerPort = intfPeerPort;
	}
	public String getTimeReg() {
		return timeReg;
	}
	public void setTimeReg(String timeReg) {
		this.timeReg = timeReg;
	}
	public String getTimeExpire() {
		return timeExpire;
	}
	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}
	public String getTimeUnreg() {
		return timeUnreg;
	}
	public void setTimeUnreg(String timeUnreg) {
		this.timeUnreg = timeUnreg;
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
