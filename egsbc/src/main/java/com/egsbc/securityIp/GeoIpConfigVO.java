package com.egsbc.securityIp;

import java.util.List;

import com.egsbc.common.IPCMsgVO;

public class GeoIpConfigVO extends IPCMsgVO {
//	private String geoIpOperMode;
//	private String geoIpOperTime;
//	private String geoIpAvailableTime;
//	
	
	
	private short geoIpOperMode;
	private short geoIpDbUpdateTime;
	private short geoIpDbAvailableTerm;
	private short geoIpNationRule;
	private short geoIpNationCount;
	private String geoUpdateDate; //from  R_SECURITY_GEO_IP
	private String geoIpArray;
	private List<GeoIpNationVO> list;
	
	
	
	public String getGeoIpArray() {
		return geoIpArray;
	}
	public void setGeoIpArray(String geoIpArray) {
		this.geoIpArray = geoIpArray;
	}
	public short getGeoIpOperMode() {
		return geoIpOperMode;
	}
	public void setGeoIpOperMode(short geoIpOperMode) {
		this.geoIpOperMode = geoIpOperMode;
	}
	public short getGeoIpDbUpdateTime() {
		return geoIpDbUpdateTime;
	}
	public void setGeoIpDbUpdateTime(short geoIpDbUpdateTime) {
		this.geoIpDbUpdateTime = geoIpDbUpdateTime;
	}
	public short getGeoIpDbAvailableTerm() {
		return geoIpDbAvailableTerm;
	}
	public void setGeoIpDbAvailableTerm(short geoIpDbAvailableTerm) {
		this.geoIpDbAvailableTerm = geoIpDbAvailableTerm;
	}
	public short getGeoIpNationRule() {
		return geoIpNationRule;
	}
	public void setGeoIpNationRule(short geoIpNationRule) {
		this.geoIpNationRule = geoIpNationRule;
	}
	public short getGeoIpNationCount() {
		return geoIpNationCount;
	}
	public void setGeoIpNationCount(short geoIpNationCount) {
		this.geoIpNationCount = geoIpNationCount;
	}
	public List<GeoIpNationVO> getList() {
		return list;
	}
	public void setList(List<GeoIpNationVO> list) {
		this.list = list;
	}
	public String getGeoUpdateDate() {
		return geoUpdateDate;
	}
	public void setGeoUpdateDate(String geoUpdateDate) {
		this.geoUpdateDate = geoUpdateDate;
	}
	
	
	
	
	
}
