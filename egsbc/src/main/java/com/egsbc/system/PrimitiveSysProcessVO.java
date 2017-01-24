package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class PrimitiveSysProcessVO extends IPCMsgVO {
	private int side;
	private String pkgVer;
	private String blkName;
	private String dateInstall;
	private String dateStart;
	private int status;
	
	private String blkVer; // r_primitive_sys_package_block
	
	
	
	public String getBlkVer() {
		return blkVer;
	}
	public void setBlkVer(String blkVer) {
		this.blkVer = blkVer;
	}
	public String getBlkName() {
		return blkName;
	}
	public void setBlkName(String blkName) {
		this.blkName = blkName;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public String getPkgVer() {
		return pkgVer;
	}
	public void setPkgVer(String pkgVer) {
		this.pkgVer = pkgVer;
	}
	public String getDateInstall() {
		return dateInstall;
	}
	public void setDateInstall(String dateInstall) {
		this.dateInstall = dateInstall;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
