package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class UserVO extends IPCMsgVO {
	private String id;
	private String pw;
	private short level;
	private String createdDate;
	private short status=-1;
	private String loginDate;
	private String loginIp;
	private short stayLoggedIn=-1;
	private String blockedDate;
	private short loginFailCount;
	private String mobileNum4Sms;
	private short smsSendOn;
	private String emailAddr4Email;
	private short emailSendOn;
	
	public UserVO(){}
	
	public UserVO(String id){
		this.id = id;
	}
	
	public UserVO(String id, short status, String loginIp){
		this.id = id;
		this.status = status;
		this.loginIp = loginIp;
	}
	
	public UserVO(String id, short status, String loginIp, short stayLoggedIn){
		this.id = id;
		this.status = status;
		this.loginIp = loginIp;
		this.stayLoggedIn = stayLoggedIn;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public short getLevel() {
		return level;
	}
	public void setLevel(short level) {
		this.level = level;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public short getStayLoggedIn() {
		return stayLoggedIn;
	}
	public void setStayLoggedIn(short stayLoggedIn) {
		this.stayLoggedIn = stayLoggedIn;
	}
	public String getBlockedDate() {
		return blockedDate;
	}
	public void setBlockedDate(String blockedDate) {
		this.blockedDate = blockedDate;
	}
	public short getLoginFailCount() {
		return loginFailCount;
	}
	public void setLoginFailCount(short loginFailCount) {
		this.loginFailCount = loginFailCount;
	}
	public String getMobileNum4Sms() {
		return mobileNum4Sms;
	}
	public void setMobileNum4Sms(String mobileNum4Sms) {
		this.mobileNum4Sms = mobileNum4Sms;
	}
	public short getSmsSendOn() {
		return smsSendOn;
	}
	public void setSmsSendOn(short smsSendOn) {
		this.smsSendOn = smsSendOn;
	}
	public String getEmailAddr4Email() {
		return emailAddr4Email;
	}
	public void setEmailAddr4Email(String emailAddr4Email) {
		this.emailAddr4Email = emailAddr4Email;
	}
	public short getEmailSendOn() {
		return emailSendOn;
	}
	public void setEmailSendOn(short emailSendOn) {
		this.emailSendOn = emailSendOn;
	}
	
	
	
}
