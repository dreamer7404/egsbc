package com.egsbc.configuration;

import com.egsbc.common.IPCMsgVO;

public class EasyConfigurationVO extends IPCMsgVO {
	
	private short mode;
	private String serviceName;
	
	// Realm
	private String rlmName;
	private String	rlmDomain;
	private	String	 rlmSigTransName;
	private	String rlmMediaTransName;
	private int rlmRegPeriod;
	
	private short rlmElemType;
	private	String	 rlmGroupName;
	private	short rlmMediaPassFlag;
	private	short rlmSrtpFlag;
	private	int rlmRegPeriodNat = 60;
	private	short rlmRegPeriodBypass;
	private short rlmSessionFlag;
	private	int	 rlmSessionExpires = 0;
	private	int	 rlmSessionMinse = 0;
	private	short rlmDeregDeactFlag;
	private short rlmEndPointType;
	
	private short rlmPeerIpType;
	private String rlmPeerIp;
	private int rlmPeerPort = 0;
	private short rlmRegisterFlag; // 데리레지 지원
	private String rlmRegisterUserId;
	private String rlmRegisterDomain;
	private String rlmRegisterAuthId;
	private String rlmRegisterAuthPw;
	private short rlmPolicySpamFlag;
	private int rlmMaxCps = 0;
	private int rlmMaxSession = 0;
	private short rlmPollingStatus;
	private String rlmPollingTime;
	
	
	
	
	//Server
	private String svrName;
	private String	svrDomain;
	private	String	 svrSigTransName;
	private	String svrMediaTransName;
	private int svrRegPeriod;
	
	private short svrElemType;
	private String svrGroupName;
	private short svrServerIPType;
	private String svrServerIP;
	private int svrServerPort = 0;
	private short svrSrtpFlag;
	private int svrMaxCps = 100;
	private int svrMaxSession = 100;
	private int svrMaxRps = 1000;
	private short svrPollingStatus;
	private String svrPollingTime;
	
	private short svrPeerIpType;
	private String svrPeerIp;
	private int svrPeerPort = 0;
	private short svrMediaPassFlag;
	private short svrRegisterFlag; // 데리레지 지원
	private String svrRegisterUserId;
	private String svrRegisterDomain;
	private String svrRegisterAuthId;
	private String svrRegisterAuthPw;
	private short svrPolicySpamFlag;
	
	private int dummyIndex;
	private short svrPollFlag;
	
	
	// Trunking용 추가
	private short svrSelfResponseFlag;
	
	private	String	 svrSigTransName2;
	private String svrPeerIp2;
	private int svrPeerPort2 = 0;
	public short getMode() {
		return mode;
	}
	public void setMode(short mode) {
		this.mode = mode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRlmName() {
		return rlmName;
	}
	public void setRlmName(String rlmName) {
		this.rlmName = rlmName;
	}
	public String getRlmDomain() {
		return rlmDomain;
	}
	public void setRlmDomain(String rlmDomain) {
		this.rlmDomain = rlmDomain;
	}
	public String getRlmSigTransName() {
		return rlmSigTransName;
	}
	public void setRlmSigTransName(String rlmSigTransName) {
		this.rlmSigTransName = rlmSigTransName;
	}
	public String getRlmMediaTransName() {
		return rlmMediaTransName;
	}
	public void setRlmMediaTransName(String rlmMediaTransName) {
		this.rlmMediaTransName = rlmMediaTransName;
	}
	public int getRlmRegPeriod() {
		return rlmRegPeriod;
	}
	public void setRlmRegPeriod(int rlmRegPeriod) {
		this.rlmRegPeriod = rlmRegPeriod;
	}
	public short getRlmElemType() {
		return rlmElemType;
	}
	public void setRlmElemType(short rlmElemType) {
		this.rlmElemType = rlmElemType;
	}
	public String getRlmGroupName() {
		return rlmGroupName;
	}
	public void setRlmGroupName(String rlmGroupName) {
		this.rlmGroupName = rlmGroupName;
	}
	public short getRlmMediaPassFlag() {
		return rlmMediaPassFlag;
	}
	public void setRlmMediaPassFlag(short rlmMediaPassFlag) {
		this.rlmMediaPassFlag = rlmMediaPassFlag;
	}
	public short getRlmSrtpFlag() {
		return rlmSrtpFlag;
	}
	public void setRlmSrtpFlag(short rlmSrtpFlag) {
		this.rlmSrtpFlag = rlmSrtpFlag;
	}
	public int getRlmRegPeriodNat() {
		return rlmRegPeriodNat;
	}
	public void setRlmRegPeriodNat(int rlmRegPeriodNat) {
		this.rlmRegPeriodNat = rlmRegPeriodNat;
	}
	public short getRlmRegPeriodBypass() {
		return rlmRegPeriodBypass;
	}
	public void setRlmRegPeriodBypass(short rlmRegPeriodBypass) {
		this.rlmRegPeriodBypass = rlmRegPeriodBypass;
	}
	public short getRlmSessionFlag() {
		return rlmSessionFlag;
	}
	public void setRlmSessionFlag(short rlmSessionFlag) {
		this.rlmSessionFlag = rlmSessionFlag;
	}
	public int getRlmSessionExpires() {
		return rlmSessionExpires;
	}
	public void setRlmSessionExpires(int rlmSessionExpires) {
		this.rlmSessionExpires = rlmSessionExpires;
	}
	public int getRlmSessionMinse() {
		return rlmSessionMinse;
	}
	public void setRlmSessionMinse(int rlmSessionMinse) {
		this.rlmSessionMinse = rlmSessionMinse;
	}
	public short getRlmDeregDeactFlag() {
		return rlmDeregDeactFlag;
	}
	public void setRlmDeregDeactFlag(short rlmDeregDeactFlag) {
		this.rlmDeregDeactFlag = rlmDeregDeactFlag;
	}
	public short getRlmEndPointType() {
		return rlmEndPointType;
	}
	public void setRlmEndPointType(short rlmEndPointType) {
		this.rlmEndPointType = rlmEndPointType;
	}
	public short getRlmPeerIpType() {
		return rlmPeerIpType;
	}
	public void setRlmPeerIpType(short rlmPeerIpType) {
		this.rlmPeerIpType = rlmPeerIpType;
	}
	public String getRlmPeerIp() {
		return rlmPeerIp;
	}
	public void setRlmPeerIp(String rlmPeerIp) {
		this.rlmPeerIp = rlmPeerIp;
	}
	public int getRlmPeerPort() {
		return rlmPeerPort;
	}
	public void setRlmPeerPort(int rlmPeerPort) {
		this.rlmPeerPort = rlmPeerPort;
	}
	public short getRlmRegisterFlag() {
		return rlmRegisterFlag;
	}
	public void setRlmRegisterFlag(short rlmRegisterFlag) {
		this.rlmRegisterFlag = rlmRegisterFlag;
	}
	public String getRlmRegisterUserId() {
		return rlmRegisterUserId;
	}
	public void setRlmRegisterUserId(String rlmRegisterUserId) {
		this.rlmRegisterUserId = rlmRegisterUserId;
	}
	public String getRlmRegisterDomain() {
		return rlmRegisterDomain;
	}
	public void setRlmRegisterDomain(String rlmRegisterDomain) {
		this.rlmRegisterDomain = rlmRegisterDomain;
	}
	public String getRlmRegisterAuthId() {
		return rlmRegisterAuthId;
	}
	public void setRlmRegisterAuthId(String rlmRegisterAuthId) {
		this.rlmRegisterAuthId = rlmRegisterAuthId;
	}
	public String getRlmRegisterAuthPw() {
		return rlmRegisterAuthPw;
	}
	public void setRlmRegisterAuthPw(String rlmRegisterAuthPw) {
		this.rlmRegisterAuthPw = rlmRegisterAuthPw;
	}
	public short getRlmPolicySpamFlag() {
		return rlmPolicySpamFlag;
	}
	public void setRlmPolicySpamFlag(short rlmPolicySpamFlag) {
		this.rlmPolicySpamFlag = rlmPolicySpamFlag;
	}
	public int getRlmMaxCps() {
		return rlmMaxCps;
	}
	public void setRlmMaxCps(int rlmMaxCps) {
		this.rlmMaxCps = rlmMaxCps;
	}
	public int getRlmMaxSession() {
		return rlmMaxSession;
	}
	public void setRlmMaxSession(int rlmMaxSession) {
		this.rlmMaxSession = rlmMaxSession;
	}
	public short getRlmPollingStatus() {
		return rlmPollingStatus;
	}
	public void setRlmPollingStatus(short rlmPollingStatus) {
		this.rlmPollingStatus = rlmPollingStatus;
	}
	public String getRlmPollingTime() {
		return rlmPollingTime;
	}
	public void setRlmPollingTime(String rlmPollingTime) {
		this.rlmPollingTime = rlmPollingTime;
	}
	public String getSvrName() {
		return svrName;
	}
	public void setSvrName(String svrName) {
		this.svrName = svrName;
	}
	public String getSvrDomain() {
		return svrDomain;
	}
	public void setSvrDomain(String svrDomain) {
		this.svrDomain = svrDomain;
	}
	public String getSvrSigTransName() {
		return svrSigTransName;
	}
	public void setSvrSigTransName(String svrSigTransName) {
		this.svrSigTransName = svrSigTransName;
	}
	public String getSvrMediaTransName() {
		return svrMediaTransName;
	}
	public void setSvrMediaTransName(String svrMediaTransName) {
		this.svrMediaTransName = svrMediaTransName;
	}
	public int getSvrRegPeriod() {
		return svrRegPeriod;
	}
	public void setSvrRegPeriod(int svrRegPeriod) {
		this.svrRegPeriod = svrRegPeriod;
	}
	public short getSvrElemType() {
		return svrElemType;
	}
	public void setSvrElemType(short svrElemType) {
		this.svrElemType = svrElemType;
	}
	public String getSvrGroupName() {
		return svrGroupName;
	}
	public void setSvrGroupName(String svrGroupName) {
		this.svrGroupName = svrGroupName;
	}
	public short getSvrServerIPType() {
		return svrServerIPType;
	}
	public void setSvrServerIPType(short svrServerIPType) {
		this.svrServerIPType = svrServerIPType;
	}
	public String getSvrServerIP() {
		return svrServerIP;
	}
	public void setSvrServerIP(String svrServerIP) {
		this.svrServerIP = svrServerIP;
	}
	public int getSvrServerPort() {
		return svrServerPort;
	}
	public void setSvrServerPort(int svrServerPort) {
		this.svrServerPort = svrServerPort;
	}
	public short getSvrSrtpFlag() {
		return svrSrtpFlag;
	}
	public void setSvrSrtpFlag(short svrSrtpFlag) {
		this.svrSrtpFlag = svrSrtpFlag;
	}
	public int getSvrMaxCps() {
		return svrMaxCps;
	}
	public void setSvrMaxCps(int svrMaxCps) {
		this.svrMaxCps = svrMaxCps;
	}
	public int getSvrMaxSession() {
		return svrMaxSession;
	}
	public void setSvrMaxSession(int svrMaxSession) {
		this.svrMaxSession = svrMaxSession;
	}
	public int getSvrMaxRps() {
		return svrMaxRps;
	}
	public void setSvrMaxRps(int svrMaxRps) {
		this.svrMaxRps = svrMaxRps;
	}
	public short getSvrPollingStatus() {
		return svrPollingStatus;
	}
	public void setSvrPollingStatus(short svrPollingStatus) {
		this.svrPollingStatus = svrPollingStatus;
	}
	public String getSvrPollingTime() {
		return svrPollingTime;
	}
	public void setSvrPollingTime(String svrPollingTime) {
		this.svrPollingTime = svrPollingTime;
	}
	public short getSvrPeerIpType() {
		return svrPeerIpType;
	}
	public void setSvrPeerIpType(short svrPeerIpType) {
		this.svrPeerIpType = svrPeerIpType;
	}
	public String getSvrPeerIp() {
		return svrPeerIp;
	}
	public void setSvrPeerIp(String svrPeerIp) {
		this.svrPeerIp = svrPeerIp;
	}
	public int getSvrPeerPort() {
		return svrPeerPort;
	}
	public void setSvrPeerPort(int svrPeerPort) {
		this.svrPeerPort = svrPeerPort;
	}
	public short getSvrMediaPassFlag() {
		return svrMediaPassFlag;
	}
	public void setSvrMediaPassFlag(short svrMediaPassFlag) {
		this.svrMediaPassFlag = svrMediaPassFlag;
	}
	public short getSvrRegisterFlag() {
		return svrRegisterFlag;
	}
	public void setSvrRegisterFlag(short svrRegisterFlag) {
		this.svrRegisterFlag = svrRegisterFlag;
	}
	public String getSvrRegisterUserId() {
		return svrRegisterUserId;
	}
	public void setSvrRegisterUserId(String svrRegisterUserId) {
		this.svrRegisterUserId = svrRegisterUserId;
	}
	public String getSvrRegisterDomain() {
		return svrRegisterDomain;
	}
	public void setSvrRegisterDomain(String svrRegisterDomain) {
		this.svrRegisterDomain = svrRegisterDomain;
	}
	public String getSvrRegisterAuthId() {
		return svrRegisterAuthId;
	}
	public void setSvrRegisterAuthId(String svrRegisterAuthId) {
		this.svrRegisterAuthId = svrRegisterAuthId;
	}
	public String getSvrRegisterAuthPw() {
		return svrRegisterAuthPw;
	}
	public void setSvrRegisterAuthPw(String svrRegisterAuthPw) {
		this.svrRegisterAuthPw = svrRegisterAuthPw;
	}
	public short getSvrPolicySpamFlag() {
		return svrPolicySpamFlag;
	}
	public void setSvrPolicySpamFlag(short svrPolicySpamFlag) {
		this.svrPolicySpamFlag = svrPolicySpamFlag;
	}
	public int getDummyIndex() {
		return dummyIndex;
	}
	public void setDummyIndex(int dummyIndex) {
		this.dummyIndex = dummyIndex;
	}
	public short getSvrPollFlag() {
		return svrPollFlag;
	}
	public void setSvrPollFlag(short svrPollFlag) {
		this.svrPollFlag = svrPollFlag;
	}
	public short getSvrSelfResponseFlag() {
		return svrSelfResponseFlag;
	}
	public void setSvrSelfResponseFlag(short svrSelfResponseFlag) {
		this.svrSelfResponseFlag = svrSelfResponseFlag;
	}
	public String getSvrSigTransName2() {
		return svrSigTransName2;
	}
	public void setSvrSigTransName2(String svrSigTransName2) {
		this.svrSigTransName2 = svrSigTransName2;
	}
	public String getSvrPeerIp2() {
		return svrPeerIp2;
	}
	public void setSvrPeerIp2(String svrPeerIp2) {
		this.svrPeerIp2 = svrPeerIp2;
	}
	public int getSvrPeerPort2() {
		return svrPeerPort2;
	}
	public void setSvrPeerPort2(int svrPeerPort2) {
		this.svrPeerPort2 = svrPeerPort2;
	}
	
	
	
	
	
	
}
