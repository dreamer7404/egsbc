package com.egsbc.configuration;

import java.util.List;

public class SipServiceRuleVO {
	private short opMode;			// 동작모드
	
	private int idx;
	private String serviceName;
	private short ruleType; 			// 0: static(default) 1: Domain 2: Prefix
	private String rule;					// static 일때는 의미 없음
	private short referField;			// prefix일때만 유효, 0: To/RURI  1: From
	private String sourceGroup;		// R_SIP_SERVICE의 xxx_GROUPx 
	private String targetGroup;		// R_SIP_SERVICE의 xxx_GROUPx 
	private short reverseFlag;		// 역방향 지원 flag, 0: off 1: on(default) (Sel)
	
	
	private int isStatic;
	private int isDomain;
	private int isPrefix;
	
	private List<Integer> ruleTypeList;
	
	
	
	
	
	public int getIsStatic() {
		return isStatic;
	}
	public void setIsStatic(int isStatic) {
		this.isStatic = isStatic;
	}
	public int getIsDomain() {
		return isDomain;
	}
	public void setIsDomain(int isDomain) {
		this.isDomain = isDomain;
	}
	public int getIsPrefix() {
		return isPrefix;
	}
	public void setIsPrefix(int isPrefix) {
		this.isPrefix = isPrefix;
	}
	public List<Integer> getRuleTypeList() {
		return ruleTypeList;
	}
	public void setRuleTypeList(List<Integer> ruleTypeList) {
		this.ruleTypeList = ruleTypeList;
	}
	public short getOpMode() {
		return opMode;
	}
	public void setOpMode(short opMode) {
		this.opMode = opMode;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public short getRuleType() {
		return ruleType;
	}
	public void setRuleType(short ruleType) {
		this.ruleType = ruleType;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public short getReferField() {
		return referField;
	}
	public void setReferField(short referField) {
		this.referField = referField;
	}
	public String getSourceGroup() {
		return sourceGroup;
	}
	public void setSourceGroup(String sourceGroup) {
		this.sourceGroup = sourceGroup;
	}
	public String getTargetGroup() {
		return targetGroup;
	}
	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}
	public short getReverseFlag() {
		return reverseFlag;
	}
	public void setReverseFlag(short reverseFlag) {
		this.reverseFlag = reverseFlag;
	}
	
	
	
}
