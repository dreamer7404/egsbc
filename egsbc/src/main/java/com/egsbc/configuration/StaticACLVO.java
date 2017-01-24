package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class StaticACLVO extends IPCMsgVO {
	private int idx;
	private short usageACL;
	private short ipType;
	private short protocol;
	private short actionACL;
	private String sourceIp;
	private int sourcePort;
	private String destinationIp;
	private int destinationPort;
	private String description;
	
	
	public short getUsageACL() {
		return usageACL;
	}
	public void setUsageACL(short usageACL) {
		this.usageACL = usageACL;
	}
	public short getActionACL() {
		return actionACL;
	}
	public void setActionACL(short actionACL) {
		this.actionACL = actionACL;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public short getIpType() {
		return ipType;
	}
	public void setIpType(short ipType) {
		this.ipType = ipType;
	}
	public short getProtocol() {
		return protocol;
	}
	public void setProtocol(short protocol) {
		this.protocol = protocol;
	}
	public String getSourceIp() {
		return sourceIp;
	}
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	public int getSourcePort() {
		return sourcePort;
	}
	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}
	public String getDestinationIp() {
		return destinationIp;
	}
	public void setDestinationIp(String destinationIp) {
		this.destinationIp = destinationIp;
	}
	public int getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
