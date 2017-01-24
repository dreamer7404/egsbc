package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class GeoIpExcludeVO extends IPCMsgVO {
	private String geoExIpKey;
	private short geoExIpMatchType;
	
	public String getGeoExIpKey() {
		return geoExIpKey;
	}
	public void setGeoExIpKey(String geoExIpKey) {
		this.geoExIpKey = geoExIpKey;
	}
	public short getGeoExIpMatchType() {
		return geoExIpMatchType;
	}
	public void setGeoExIpMatchType(short geoExIpMatchType) {
		this.geoExIpMatchType = geoExIpMatchType;
	}
	
	
	
	
}
