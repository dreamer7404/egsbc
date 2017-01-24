package com.egsbc.utils;

import java.util.List;

import com.egsbc.common.ClassTypeVO;

public class Bytes {

	public static byte[] arrayCopy(List<Object> list){
		
		byte[] data = new byte[4096];
		int start = 0;
		
		for(Object obj : list){ 
			if (obj == null || obj.getClass().equals(String.class)) {
				System.arraycopy(ToBytes.Char64((String)obj), 0, data, start, Global.STR_LEN);
				start += Global.STR_LEN;
			}else if (obj.getClass().equals(Integer.class)) {
				System.arraycopy(ToBytes.Int((int)obj), 0, data, start, 4);
				start += Global.INT_LEN;
			}else if (obj.getClass().equals(Short.class)) {
				System.arraycopy(ToBytes.Short((short)obj), 0, data, start, 2);
				start += Global.SHO_LEN;
			}else if (obj.getClass().equals(Character.class)) {
				System.arraycopy(ToBytes.Char((char)obj), 0, data, start, 1);
				start += 1;
			}
		}
		
		byte[] dataTo = new byte[start];
		
		System.arraycopy(data, 0, dataTo, 0, start);
		
		return dataTo;
	}
	
public static byte[] arrayCopy2(List<ClassTypeVO> list){
		
		byte[] data = new byte[17000];
		int start = 0;
		
		int i = 0;
		
		try{
			
			
			int k = 0;
			
			for(ClassTypeVO vo : list){ 
				
				i++;
				if(i == 134){
					k = i;
				}
				
				Object obj = vo.getObj();
				
				if (vo == null || obj == null || obj.getClass().equals(String.class)) {
					if(vo.getSize() > Global.STR_LEN){
						System.arraycopy(ToBytes.Char64Over((String)obj, vo.getSize()), 0, data, start, vo.getSize());
						start += vo.getSize();
					}else{
						System.arraycopy(ToBytes.Char64((String)obj), 0, data, start, Global.STR_LEN);
						start += Global.STR_LEN;
					}
				}else if (obj.getClass().equals(Integer.class)) {
					if(vo.getSize() == Global.SHO_LEN){
						System.arraycopy(ToBytes.Int2((int)obj), 0, data, start, Global.SHO_LEN);
						start += Global.SHO_LEN;
					}else{
						System.arraycopy(ToBytes.Int((int)obj), 0, data, start, Global.INT_LEN);
						start += Global.INT_LEN;
					}
				}else if (obj.getClass().equals(Short.class)) {
					System.arraycopy(ToBytes.Short((short)obj), 0, data, start, Global.SHO_LEN);
					start += Global.SHO_LEN;
				}else if (obj.getClass().equals(Character.class)) {
					System.arraycopy(ToBytes.Char((char)obj), 0, data, start, 1);
					start += 1;
				}
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		
		byte[] dataTo = new byte[start];
		
		System.arraycopy(data, 0, dataTo, 0, start);
		
		return dataTo;
	}
}
