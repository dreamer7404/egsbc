package com.egsbc.securityIp;

import com.egsbc.common.IPCMsgVO;

public class SecSpamVO extends IPCMsgVO {
	private int enable;
	private int actionMode;
	private int duration;
	private int dropDuration;
	
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getActionMode() {
		return actionMode;
	}
	public void setActionMode(int actionMode) {
		this.actionMode = actionMode;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDropDuration() {
		return dropDuration;
	}
	public void setDropDuration(int dropDuration) {
		this.dropDuration = dropDuration;
	}
	
	
	
}
