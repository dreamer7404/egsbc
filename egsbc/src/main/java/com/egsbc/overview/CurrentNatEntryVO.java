package com.egsbc.overview;

import com.egsbc.common.IPCMsgVO;

public class CurrentNatEntryVO extends IPCMsgVO {
	private String idx;
	private String createDatetime;
	private String natSvcName;
	private int bucketIndex;
	private int entryIndex;
	private String inSrcIp;
	private int inSrcPort;
	private String inDstIp;
	private int inDstPort;
	private String outSrcIp;
	private int outSrcPort;
	private String outDstIp;
	private int outDstPort;
	private short protocol;
	private short proxyMode;
	private short ipkts;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getNatSvcName() {
		return natSvcName;
	}
	public void setNatSvcName(String natSvcName) {
		this.natSvcName = natSvcName;
	}
	public int getBucketIndex() {
		return bucketIndex;
	}
	public void setBucketIndex(int bucketIndex) {
		this.bucketIndex = bucketIndex;
	}
	public int getEntryIndex() {
		return entryIndex;
	}
	public void setEntryIndex(int entryIndex) {
		this.entryIndex = entryIndex;
	}
	public String getInSrcIp() {
		return inSrcIp;
	}
	public void setInSrcIp(String inSrcIp) {
		this.inSrcIp = inSrcIp;
	}
	public int getInSrcPort() {
		return inSrcPort;
	}
	public void setInSrcPort(int inSrcPort) {
		this.inSrcPort = inSrcPort;
	}
	public String getInDstIp() {
		return inDstIp;
	}
	public void setInDstIp(String inDstIp) {
		this.inDstIp = inDstIp;
	}
	public int getInDstPort() {
		return inDstPort;
	}
	public void setInDstPort(int inDstPort) {
		this.inDstPort = inDstPort;
	}
	public String getOutSrcIp() {
		return outSrcIp;
	}
	public void setOutSrcIp(String outSrcIp) {
		this.outSrcIp = outSrcIp;
	}
	public int getOutSrcPort() {
		return outSrcPort;
	}
	public void setOutSrcPort(int outSrcPort) {
		this.outSrcPort = outSrcPort;
	}
	public String getOutDstIp() {
		return outDstIp;
	}
	public void setOutDstIp(String outDstIp) {
		this.outDstIp = outDstIp;
	}
	public int getOutDstPort() {
		return outDstPort;
	}
	public void setOutDstPort(int outDstPort) {
		this.outDstPort = outDstPort;
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
	
	
}
