package com.egsbc.pkg;

import com.egsbc.common.IPCMsgVO;

public class PackageVO extends IPCMsgVO {
	private short side;
	private String pkgVer;
	private int running;
	private int size;
	private String builder;
	private int validate;
	private String dateBuild;
	private String dateInstall;
	private String license;
	
	public short getSide() {
		return side;
	}
	public void setSide(short side) {
		this.side = side;
	}
	public String getPkgVer() {
		return pkgVer;
	}
	public void setPkgVer(String pkgVer) {
		this.pkgVer = pkgVer;
	}
	public int getRunning() {
		return running;
	}
	public void setRunning(int running) {
		this.running = running;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public int getValidate() {
		return validate;
	}
	public void setValidate(int validate) {
		this.validate = validate;
	}
	public String getDateBuild() {
		return dateBuild;
	}
	public void setDateBuild(String dateBuild) {
		this.dateBuild = dateBuild;
	}
	public String getDateInstall() {
		return dateInstall;
	}
	public void setDateInstall(String dateInstall) {
		this.dateInstall = dateInstall;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	
}
