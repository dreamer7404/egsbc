package com.egsbc.system;

public class ProcessControlVO {
	private short opMode;
	
	private short controlClass;
	private short controlHost;
	
	private short process;
	private short processControlMode;
	private short processControlDummy1;
	private short processControlDummy2;
	
	
	
	
	public short getOpMode() {
		return opMode;
	}
	public void setOpMode(short opMode) {
		this.opMode = opMode;
	}
	public short getControlClass() {
		return controlClass;
	}
	public void setControlClass(short controlClass) {
		this.controlClass = controlClass;
	}
	public short getControlHost() {
		return controlHost;
	}
	public void setControlHost(short controlHost) {
		this.controlHost = controlHost;
	}
	public short getProcess() {
		return process;
	}
	public void setProcess(short process) {
		this.process = process;
	}
	
	public short getProcessControlMode() {
		return processControlMode;
	}
	public void setProcessControlMode(short processControlMode) {
		this.processControlMode = processControlMode;
	}
	public short getProcessControlDummy1() {
		return processControlDummy1;
	}
	public void setProcessControlDummy1(short processControlDummy1) {
		this.processControlDummy1 = processControlDummy1;
	}
	public short getProcessControlDummy2() {
		return processControlDummy2;
	}
	public void setProcessControlDummy2(short processControlDummy2) {
		this.processControlDummy2 = processControlDummy2;
	}
	
	
}
