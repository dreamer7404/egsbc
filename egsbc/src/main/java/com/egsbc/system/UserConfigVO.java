package com.egsbc.system;

public class UserConfigVO {
	private short limitLoginFailCount;
	private short blockDurationByLimit;
	private short sleepModeByNoActionDuration;
	private short forceLogoutByActionDuration;
	private short defaultAclRule;
	private short maxUser;
	
	public short getLimitLoginFailCount() {
		return limitLoginFailCount;
	}
	public void setLimitLoginFailCount(short limitLoginFailCount) {
		this.limitLoginFailCount = limitLoginFailCount;
	}
	public short getBlockDurationByLimit() {
		return blockDurationByLimit;
	}
	public void setBlockDurationByLimit(short blockDurationByLimit) {
		this.blockDurationByLimit = blockDurationByLimit;
	}
	public short getSleepModeByNoActionDuration() {
		return sleepModeByNoActionDuration;
	}
	public void setSleepModeByNoActionDuration(short sleepModeByNoActionDuration) {
		this.sleepModeByNoActionDuration = sleepModeByNoActionDuration;
	}
	public short getForceLogoutByActionDuration() {
		return forceLogoutByActionDuration;
	}
	public void setForceLogoutByActionDuration(short forceLogoutByActionDuration) {
		this.forceLogoutByActionDuration = forceLogoutByActionDuration;
	}
	public short getDefaultAclRule() {
		return defaultAclRule;
	}
	public void setDefaultAclRule(short defaultAclRule) {
		this.defaultAclRule = defaultAclRule;
	}
	public short getMaxUser() {
		return maxUser;
	}
	public void setMaxUser(short maxUser) {
		this.maxUser = maxUser;
	}
	
	
	
}
