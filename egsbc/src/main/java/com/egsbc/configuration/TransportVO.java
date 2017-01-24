package com.egsbc.configuration;

public class TransportVO {
	
	private short opMode;			// 동작모드
	
	private String name;
	private String vipName;
	private int sigPort=0;
	private short svcType=0;
	private short transType=0;
	private short qosType=0;
	private int qosValue=0;
	private int minPort=0;
	private int maxPort=0;
	private short protocol=0;
	private int forkingMinport=0;
	private int forkingMaxport=0;
	
	public short getOpMode() {
		return opMode;
	}
	public void setOpMode(short opMode) {
		this.opMode = opMode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public int getSigPort() {
		return sigPort;
	}
	public void setSigPort(int sigPort) {
		this.sigPort = sigPort;
	}
	public short getSvcType() {
		return svcType;
	}
	public void setSvcType(short svcType) {
		this.svcType = svcType;
	}
	public short getTransType() {
		return transType;
	}
	public void setTransType(short transType) {
		this.transType = transType;
	}
	public short getQosType() {
		return qosType;
	}
	public void setQosType(short qosType) {
		this.qosType = qosType;
	}
	public int getQosValue() {
		return qosValue;
	}
	public void setQosValue(int qosValue) {
		this.qosValue = qosValue;
	}
	public int getMinPort() {
		return minPort;
	}
	public void setMinPort(int minPort) {
		this.minPort = minPort;
	}
	public int getMaxPort() {
		return maxPort;
	}
	public void setMaxPort(int maxPort) {
		this.maxPort = maxPort;
	}
	public short getProtocol() {
		return protocol;
	}
	public void setProtocol(short protocol) {
		this.protocol = protocol;
	}
	public int getForkingMinport() {
		return forkingMinport;
	}
	public void setForkingMinport(int forkingMinport) {
		this.forkingMinport = forkingMinport;
	}
	public int getForkingMaxport() {
		return forkingMaxport;
	}
	public void setForkingMaxport(int forkingMaxport) {
		this.forkingMaxport = forkingMaxport;
	}
	
	
	

	
}
