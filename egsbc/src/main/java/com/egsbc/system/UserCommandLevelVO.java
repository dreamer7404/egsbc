package com.egsbc.system;

public class UserCommandLevelVO {
	private short level;
	private String commandCode;
	private short commandActionCode;
	private String commandName;
	private String commandDesc;
	private String etc;
	public short getLevel() {
		return level;
	}
	public void setLevel(short level) {
		this.level = level;
	}
	public String getCommandCode() {
		return commandCode;
	}
	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}
	public short getCommandActionCode() {
		return commandActionCode;
	}
	public void setCommandActionCode(short commandActionCode) {
		this.commandActionCode = commandActionCode;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getCommandDesc() {
		return commandDesc;
	}
	public void setCommandDesc(String commandDesc) {
		this.commandDesc = commandDesc;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
	
}
