package com.egsbc.common;

public class ClassTypeVO {
	private Object obj;
	private int size = 0;
	
	
	public ClassTypeVO(Object obj){
		this.obj = obj;
	}
	public ClassTypeVO(Object obj, int size){
		this.obj = obj;
		this.size = size;
	}
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
