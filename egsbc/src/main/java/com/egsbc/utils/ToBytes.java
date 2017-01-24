package com.egsbc.utils;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

public class ToBytes {
	
	// 64 bytes
	public static byte[] Char64(String value){
		if(value == null){
			value = StringUtils.EMPTY;
		}
		byte[] b64 = new byte[64];
		byte[] tmp = value.getBytes();
		System.arraycopy(tmp, 0, b64, 0, tmp.length);
		return b64;
	}
	// OVER 64 bytes 
	public static byte[] Char64Over(String value, int size){
		if(value == null){
			value = StringUtils.EMPTY;
		}
		byte[] b = new byte[size];
		byte[] tmp = value.getBytes();
		System.arraycopy(tmp, 0, b, 0, tmp.length);
		return b;
	}
	
	public static byte[] Long(long x) {
	    ByteBuffer buffer = ByteBuffer.allocate(8);
	    buffer.putLong(x);
	    return buffer.array();
	}
	
	public static byte[] Int(int value){
		return new byte[] {
	            (byte)(value >>> 24),
	            (byte)(value >>> 16),
	            (byte)(value >>> 8),
	            (byte)value};
	}
	public static byte[] Int3(int value){
		return new byte[] {
	            (byte)(value >>> 16),
	            (byte)(value >>> 8),
	            (byte)value};
	}
	public static byte[] Int2(int value){
		return new byte[] {
	            (byte)(value >>> 8),
	            (byte)value};
	}
	
	public static byte[] Short(short value){
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.putShort(value);
		return buffer.array();
	}
	
	
//	public static byte[] Float(float f){
//		return Int3(ConvertValue.floatToInt(f));
//	}
	
	public static byte[] Char(char c){
		byte[] b = new byte[1];
		b[0] = (byte)c;
		return b;
	}
	
	public static byte[] Byte(byte b){
//		byte[] bytes = new byte[1];
//		bytes[0] = b;
		byte[] bytes = {b};
		return bytes;
	}

}
