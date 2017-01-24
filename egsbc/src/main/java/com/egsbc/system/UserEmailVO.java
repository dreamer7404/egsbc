package com.egsbc.system;

public class UserEmailVO {
	private String emailAddress;
	private short param;
	private short param2;
	
	public UserEmailVO(){}
	
	public UserEmailVO(String emailAddress){
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public short getParam() {
		return param;
	}
	public void setParam(short param) {
		this.param = param;
	}
	public short getParam2() {
		return param2;
	}
	public void setParam2(short param2) {
		this.param2 = param2;
	}
	
}
