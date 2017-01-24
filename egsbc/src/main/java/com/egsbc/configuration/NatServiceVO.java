package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class NatServiceVO extends IPCMsgVO {
	private int idx = 0;
	private String name;
	private short iPType = 0; 			// internal use only
	private short protocol = 2; 			// tcp
	private short proxyMode = 1;  		// on
	private short ipkts = 0; 				// off
	private short packetPerSec = 0;
	private int pineHoleDuration = 0;
	private String sourceIp = "*.*.*.*";
	private String incommingIntfAlias;
	private int incommingIntfMinPort = 10000;
	private int incommingIntfMaxPort = 19999;
	private String outgoingIntfAlias;
	private String destinationIp;
	private int destinationMinPort=1;
	private int destinationMaxPort=65535;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getiPType() {
		return iPType;
	}
	public void setiPType(short iPType) {
		this.iPType = iPType;
	}
	public short getProtocol() {
		return protocol;
	}
	public void setProtocol(short protocol) {
		this.protocol = protocol;
	}
	public short getProxyMode() {
		return proxyMode;
	}
	public void setProxyMode(short proxyMode) {
		this.proxyMode = proxyMode;
	}
	public short getIpkts() {
		return ipkts;
	}
	public void setIpkts(short ipkts) {
		this.ipkts = ipkts;
	}
	public short getPacketPerSec() {
		return packetPerSec;
	}
	public void setPacketPerSec(short packetPerSec) {
		this.packetPerSec = packetPerSec;
	}
	public int getPineHoleDuration() {
		return pineHoleDuration;
	}
	public void setPineHoleDuration(int pineHoleDuration) {
		this.pineHoleDuration = pineHoleDuration;
	}
	public String getSourceIp() {
		return sourceIp;
	}
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	public String getIncommingIntfAlias() {
		return incommingIntfAlias;
	}
	public void setIncommingIntfAlias(String incommingIntfAlias) {
		this.incommingIntfAlias = incommingIntfAlias;
	}
	public int getIncommingIntfMinPort() {
		return incommingIntfMinPort;
	}
	public void setIncommingIntfMinPort(int incommingIntfMinPort) {
		this.incommingIntfMinPort = incommingIntfMinPort;
	}
	public int getIncommingIntfMaxPort() {
		return incommingIntfMaxPort;
	}
	public void setIncommingIntfMaxPort(int incommingIntfMaxPort) {
		this.incommingIntfMaxPort = incommingIntfMaxPort;
	}
	public String getOutgoingIntfAlias() {
		return outgoingIntfAlias;
	}
	public void setOutgoingIntfAlias(String outgoingIntfAlias) {
		this.outgoingIntfAlias = outgoingIntfAlias;
	}
	public String getDestinationIp() {
		return destinationIp;
	}
	public void setDestinationIp(String destinationIp) {
		this.destinationIp = destinationIp;
	}
	public int getDestinationMinPort() {
		return destinationMinPort;
	}
	public void setDestinationMinPort(int destinationMinPort) {
		this.destinationMinPort = destinationMinPort;
	}
	public int getDestinationMaxPort() {
		return destinationMaxPort;
	}
	public void setDestinationMaxPort(int destinationMaxPort) {
		this.destinationMaxPort = destinationMaxPort;
	}
	
	
	
	
}
