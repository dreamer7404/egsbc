package com.egsbc.securityIp;

public class GeoIpNationVO {
	private String geoIpNationCode;
	private short geoIpNationAction;
	
	
	
	public GeoIpNationVO(String geoIpNationCode, short geoIpNationAction) {
		super();
		this.geoIpNationCode = geoIpNationCode;
		this.geoIpNationAction = geoIpNationAction;
	}
	public String getGeoIpNationCode() {
		return geoIpNationCode;
	}
	public void setGeoIpNationCode(String geoIpNationCode) {
		this.geoIpNationCode = geoIpNationCode;
	}
	public short getGeoIpNationAction() {
		return geoIpNationAction;
	}
	public void setGeoIpNationAction(short geoIpNationAction) {
		this.geoIpNationAction = geoIpNationAction;
	}
	
	
}
