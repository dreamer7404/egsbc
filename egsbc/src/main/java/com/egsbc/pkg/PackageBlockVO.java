package com.egsbc.pkg;

import com.egsbc.common.IPCMsgVO;

public class PackageBlockVO extends IPCMsgVO {
	private short side;
	private String pkgVer;
	private String blkName;
	private int blkSize;
	
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
	public String getBlkName() {
		return blkName;
	}
	public void setBlkName(String blkName) {
		this.blkName = blkName;
	}
	public int getBlkSize() {
		return blkSize;
	}
	public void setBlkSize(int blkSize) {
		this.blkSize = blkSize;
	}
	
	
	
	
}
