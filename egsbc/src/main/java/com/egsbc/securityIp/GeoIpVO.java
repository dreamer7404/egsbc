package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class GeoIpVO extends IPCMsgVO {
	private String geoNationCode;
	private String geoNation;
	private short geoNationAction;
	
	public String getGeoNationCode() {
		return geoNationCode;
	}
	public void setGeoNationCode(String geoNationCode) {
		this.geoNationCode = geoNationCode;
	}
	public String getGeoNation() {
		return geoNation;
	}
	public void setGeoNation(String geoNation) {
		this.geoNation = geoNation;
	}
	public short getGeoNationAction() {
		return geoNationAction;
	}
	public void setGeoNationAction(short geoNationAction) {
		this.geoNationAction = geoNationAction;
	}
	
	
	
}
