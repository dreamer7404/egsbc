package com.egsbc.system;

public class UserEmailServerVO {

	private short sendMailFlag;
	private String emailAddress;
	private String password;
	private String serverDomain;
	private short port;
	private String protocol;
	private short useSsl;
	
	public short getSendMailFlag() {
		return sendMailFlag;
	}
	public void setSendMailFlag(short sendMailFlag) {
		this.sendMailFlag = sendMailFlag;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServerDomain() {
		return serverDomain;
	}
	public void setServerDomain(String serverDomain) {
		this.serverDomain = serverDomain;
	}
	public short getPort() {
		return port;
	}
	public void setPort(short port) {
		this.port = port;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public short getUseSsl() {
		return useSsl;
	}
	public void setUseSsl(short useSsl) {
		this.useSsl = useSsl;
	}
	
	
	
	
	
}
