package com.egsbc.system;

import com.egsbc.common.IPCMsgVO;

public class PrimitiveSysDupVO extends IPCMsgVO {
		private short side;
		private short role;
		private short dualFlag;
		private short status; // add by lee
		private String mgmtIp;
		private short heartbeatStatus;
		private String sysUpTime;
		private String bootTime;
		private String descOs;
		private String descCpuType;
		private String descCpuSpeed;
		private String descPkgVer;
		private String descLicense;
		
		private short numCpu;
		private short numCore;
		
		private long usageCpuUser;
		private long usageCpuNice;
		private long usageCpuSyst;
		private long usageCpuIdle;
		private String usageCpuDisp1;
		private String usageCpuDisp2;
		
		private long usageRamTotal;
		private long usageRamFree;
		private String usageRamDisp1;
		private String usageRamDisp2;
		private String usageRamDisp3;
		
		private long usageDiskTotal;
		private long usageDiskFree;
		private String usageDisk1Disp;
		private String usageDisk2Disp;
		private String usageDisk3Disp;
		
		private short usageTempCur;
		private String usageTempDisp;
		
		private short configCpuMajor;
		private short configCpuMinor;
		private short configMemMajor;
		private short configMemMinor;
		private short configTempMajor;
		private short configTempMinor;
		
		
		public short getStatus() {
			return status;
		}
		public void setStatus(short status) {
			this.status = status;
		}
		public short getSide() {
			return side;
		}
		public void setSide(short side) {
			this.side = side;
		}
		public short getRole() {
			return role;
		}
		public void setRole(short role) {
			this.role = role;
		}
		public short getDualFlag() {
			return dualFlag;
		}
		public void setDualFlag(short dualFlag) {
			this.dualFlag = dualFlag;
		}
		public String getMgmtIp() {
			return mgmtIp;
		}
		public void setMgmtIp(String mgmtIp) {
			this.mgmtIp = mgmtIp;
		}
		public short getHeartbeatStatus() {
			return heartbeatStatus;
		}
		public void setHeartbeatStatus(short heartbeatStatus) {
			this.heartbeatStatus = heartbeatStatus;
		}
		public String getSysUpTime() {
			return sysUpTime;
		}
		public void setSysUpTime(String sysUpTime) {
			this.sysUpTime = sysUpTime;
		}
		public String getBootTime() {
			return bootTime;
		}
		public void setBootTime(String bootTime) {
			this.bootTime = bootTime;
		}
		public String getDescOs() {
			return descOs;
		}
		public void setDescOs(String descOs) {
			this.descOs = descOs;
		}
		public String getDescCpuType() {
			return descCpuType;
		}
		public void setDescCpuType(String descCpuType) {
			this.descCpuType = descCpuType;
		}
		public String getDescCpuSpeed() {
			return descCpuSpeed;
		}
		public void setDescCpuSpeed(String descCpuSpeed) {
			this.descCpuSpeed = descCpuSpeed;
		}
		public String getDescPkgVer() {
			return descPkgVer;
		}
		public void setDescPkgVer(String descPkgVer) {
			this.descPkgVer = descPkgVer;
		}
		public String getDescLicense() {
			return descLicense;
		}
		public void setDescLicense(String descLicense) {
			this.descLicense = descLicense;
		}
		public short getNumCpu() {
			return numCpu;
		}
		public void setNumCpu(short numCpu) {
			this.numCpu = numCpu;
		}
		public short getNumCore() {
			return numCore;
		}
		public void setNumCore(short numCore) {
			this.numCore = numCore;
		}
		public long getUsageCpuUser() {
			return usageCpuUser;
		}
		public void setUsageCpuUser(long usageCpuUser) {
			this.usageCpuUser = usageCpuUser;
		}
		public long getUsageCpuNice() {
			return usageCpuNice;
		}
		public void setUsageCpuNice(long usageCpuNice) {
			this.usageCpuNice = usageCpuNice;
		}
		public long getUsageCpuSyst() {
			return usageCpuSyst;
		}
		public void setUsageCpuSyst(long usageCpuSyst) {
			this.usageCpuSyst = usageCpuSyst;
		}
		public long getUsageCpuIdle() {
			return usageCpuIdle;
		}
		public void setUsageCpuIdle(long usageCpuIdle) {
			this.usageCpuIdle = usageCpuIdle;
		}
		public String getUsageCpuDisp1() {
			return usageCpuDisp1;
		}
		public void setUsageCpuDisp1(String usageCpuDisp1) {
			this.usageCpuDisp1 = usageCpuDisp1;
		}
		public String getUsageCpuDisp2() {
			return usageCpuDisp2;
		}
		public void setUsageCpuDisp2(String usageCpuDisp2) {
			this.usageCpuDisp2 = usageCpuDisp2;
		}
		public long getUsageRamTotal() {
			return usageRamTotal;
		}
		public void setUsageRamTotal(long usageRamTotal) {
			this.usageRamTotal = usageRamTotal;
		}
		public long getUsageRamFree() {
			return usageRamFree;
		}
		public void setUsageRamFree(long usageRamFree) {
			this.usageRamFree = usageRamFree;
		}
		public String getUsageRamDisp1() {
			return usageRamDisp1;
		}
		public void setUsageRamDisp1(String usageRamDisp1) {
			this.usageRamDisp1 = usageRamDisp1;
		}
		public String getUsageRamDisp2() {
			return usageRamDisp2;
		}
		public void setUsageRamDisp2(String usageRamDisp2) {
			this.usageRamDisp2 = usageRamDisp2;
		}
		public String getUsageRamDisp3() {
			return usageRamDisp3;
		}
		public void setUsageRamDisp3(String usageRamDisp3) {
			this.usageRamDisp3 = usageRamDisp3;
		}
		public long getUsageDiskTotal() {
			return usageDiskTotal;
		}
		public void setUsageDiskTotal(long usageDiskTotal) {
			this.usageDiskTotal = usageDiskTotal;
		}
		public long getUsageDiskFree() {
			return usageDiskFree;
		}
		public void setUsageDiskFree(long usageDiskFree) {
			this.usageDiskFree = usageDiskFree;
		}
		public String getUsageDisk1Disp() {
			return usageDisk1Disp;
		}
		public void setUsageDisk1Disp(String usageDisk1Disp) {
			this.usageDisk1Disp = usageDisk1Disp;
		}
		public String getUsageDisk2Disp() {
			return usageDisk2Disp;
		}
		public void setUsageDisk2Disp(String usageDisk2Disp) {
			this.usageDisk2Disp = usageDisk2Disp;
		}
		public String getUsageDisk3Disp() {
			return usageDisk3Disp;
		}
		public void setUsageDisk3Disp(String usageDisk3Disp) {
			this.usageDisk3Disp = usageDisk3Disp;
		}
		public short getUsageTempCur() {
			return usageTempCur;
		}
		public void setUsageTempCur(short usageTempCur) {
			this.usageTempCur = usageTempCur;
		}
		public String getUsageTempDisp() {
			return usageTempDisp;
		}
		public void setUsageTempDisp(String usageTempDisp) {
			this.usageTempDisp = usageTempDisp;
		}
		public short getConfigCpuMajor() {
			return configCpuMajor;
		}
		public void setConfigCpuMajor(short configCpuMajor) {
			this.configCpuMajor = configCpuMajor;
		}
		public short getConfigCpuMinor() {
			return configCpuMinor;
		}
		public void setConfigCpuMinor(short configCpuMinor) {
			this.configCpuMinor = configCpuMinor;
		}
		public short getConfigMemMajor() {
			return configMemMajor;
		}
		public void setConfigMemMajor(short configMemMajor) {
			this.configMemMajor = configMemMajor;
		}
		public short getConfigMemMinor() {
			return configMemMinor;
		}
		public void setConfigMemMinor(short configMemMinor) {
			this.configMemMinor = configMemMinor;
		}
		public short getConfigTempMajor() {
			return configTempMajor;
		}
		public void setConfigTempMajor(short configTempMajor) {
			this.configTempMajor = configTempMajor;
		}
		public short getConfigTempMinor() {
			return configTempMinor;
		}
		public void setConfigTempMinor(short configTempMinor) {
			this.configTempMinor = configTempMinor;
		}
		
		
		
		
		
		
		
}
