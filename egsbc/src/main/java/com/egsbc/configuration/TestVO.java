package com.egsbc.configuration;

public class TestVO {
	
	private int idx; 					// index
	private short side;				// Host - 0:A, 1:B, 2:both (CBox)
	private String intfName;		// 인터페이스 - R_PRIMITIVE_SYS_INTF_LIST 참조
	private String intfAlias;			// Alias
	private short intfType;		// 유형 - 0:Management 1:Service
	private short intfMedia;		// internal only
	private short intfUsage;		// 서비스용도 - 1: VoIP 2:NAT 3:BOTH  
//	private short intfSindex;
//	private String intfParent;
//	private short intfUsedFlag;
//	private short ipMode;			// 연결방식 -  0:고정IP, 1:유동IP(Sel)
//	private short	ipType;			// IP유형 - 0:IPv4, 1:IPv6(Sel)
//	private String ip;					// IP 주소
//	private short ipPrefix;			// IP Prefix (Netmask)
//	private String gateway;		// 기본게이트웨이
//	private String vmac;			// VMAC 주소
//	private short lrside;			// 연결정보 - 1:내부, 2:외부

	
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public String getIntfName() {
		return intfName;
	}
	public void setIntfName(String intfName) {
		this.intfName = intfName;
	}
	public String getIntfAlias() {
		return intfAlias;
	}
	public void setIntfAlias(String intfAlias) {
		this.intfAlias = intfAlias;
	}
	public short getIntfType() {
		return intfType;
	}
	public void setIntfType(short intfType) {
		this.intfType = intfType;
	}
	public short getIntfMedia() {
		return intfMedia;
	}
	public void setIntfMedia(short intfMedia) {
		this.intfMedia = intfMedia;
	}
	public short getIntfUsage() {
		return intfUsage;
	}
	public void setIntfUsage(short intfUsage) {
		this.intfUsage = intfUsage;
	}

	
	
	
	
}
