package com.egsbc.configuration;

public class PrimitiveNwIntfVO {
	
	private short opMode;			// 동작모드
	private int idx=0; 					// index
	private short side;				// Host - 0:A, 1:B, 2:both (CBox)
	private String intfName;		// 인터페이스 - R_PRIMITIVE_SYS_INTF_LIST 참조
	private String intfAlias;			// Alias
	private short intfType;		// 유형 - 0:Management 1:Service
	private short intfMedia=0;		// internal only
	private short intfUsage;		// 서비스용도 - 1: VoIP 2:NAT 3:BOTH  
	private short intfSindex;
	private String intfParent="";
	private short intfUsedFlag=0;
	private short ipMode;			// 연결방식 -  0:고정IP, 1:유동IP(Sel)
	private short	ipType;			// IP유형 - 0:IPv4, 1:IPv6(Sel)
	private String ip;					// IP 주소
	private short ipPrefix;			// IP Prefix (Netmask)
	private short srcRouteFlag; 	// 
	private String gateway;		// 기본게이트웨이
	private String vmac;			// VMAC 주소
	private short lrside;			// 연결정보 - 1:내부, 2:외부
	
	private short extLink;			// status  (  0: down, 1:up)
	private short extNego;		// 0:enable, 1:disable
	private short extSpeed;		// 0:10, 1:100, 2:1000
	private short extFlowCtrl;	// 0:enable, 1:disable

	private short extDummy1;
	private short extDummy2;
	
	private String dummy1="";
	private String dummy2="";
	
	
	
	
	public short getSrcRouteFlag() {
		return srcRouteFlag;
	}
	public void setSrcRouteFlag(short srcRouteFlag) {
		this.srcRouteFlag = srcRouteFlag;
	}
	public short getExtDummy1() {
		return extDummy1;
	}
	public short getExtDummy2() {
		return extDummy2;
	}
	public String getDummy1() {
		return dummy1;
	}
	public void setDummy1(String dummy1) {
		this.dummy1 = dummy1;
	}
	public String getDummy2() {
		return dummy2;
	}
	public void setDummy2(String dummy2) {
		this.dummy2 = dummy2;
	}
	public void setExtDummy1(short extDummy1) {
		this.extDummy1 = extDummy1;
	}
	public void setExtDummy2(short extDummy2) {
		this.extDummy2 = extDummy2;
	}
	public short getOpMode() {
		return opMode;
	}
	public void setOpMode(short opMode) {
		this.opMode = opMode;
	}
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
	public short getIntfSindex() {
		return intfSindex;
	}
	public void setIntfSindex(short intfSindex) {
		this.intfSindex = intfSindex;
	}
	public String getIntfParent() {
		return intfParent;
	}
	public void setIntfParent(String intfParent) {
		this.intfParent = intfParent;
	}
	public short getIntfUsedFlag() {
		return intfUsedFlag;
	}
	public void setIntfUsedFlag(short intfUsedFlag) {
		this.intfUsedFlag = intfUsedFlag;
	}
	public short getIpMode() {
		return ipMode;
	}
	public void setIpMode(short ipMode) {
		this.ipMode = ipMode;
	}
	public short getIpType() {
		return ipType;
	}
	public void setIpType(short ipType) {
		this.ipType = ipType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public short getIpPrefix() {
		return ipPrefix;
	}
	public void setIpPrefix(short ipPrefix) {
		this.ipPrefix = ipPrefix;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getVmac() {
		return vmac;
	}
	public void setVmac(String vmac) {
		this.vmac = vmac;
	}
	public short getLrside() {
		return lrside;
	}
	public void setLrside(short lrside) {
		this.lrside = lrside;
	}
	public short getExtLink() {
		return extLink;
	}
	public void setExtLink(short extLink) {
		this.extLink = extLink;
	}
	public short getExtNego() {
		return extNego;
	}
	public void setExtNego(short extNego) {
		this.extNego = extNego;
	}
	public short getExtSpeed() {
		return extSpeed;
	}
	public void setExtSpeed(short extSpeed) {
		this.extSpeed = extSpeed;
	}
	public short getExtFlowCtrl() {
		return extFlowCtrl;
	}
	public void setExtFlowCtrl(short extFlowCtrl) {
		this.extFlowCtrl = extFlowCtrl;
	}
	
	
	
	
	
	
	
	
}
