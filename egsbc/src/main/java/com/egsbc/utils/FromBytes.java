package com.egsbc.utils;

import org.apache.commons.lang.StringUtils;

public class FromBytes {
	 
	
	    
    public static int Short(byte[] bt){
    	short temp = 0;
    	short[] bt2 = new short[2];

    	for(int i=0; i<2; i++)
    	{
    		bt2[i] = bt[i] < 0 ? (short)((Byte.MAX_VALUE + 1) * 2 + bt[i]) : bt[i];
    		temp |= bt2[i] << 8*(1-i);
    	}
    	return temp;
    }
	    
    public static int Int3(byte[] bt){
    	int temp = 0;
    	int[] bt2 = new int[3];

    	for(int i=0; i<3; i++)
    	{
    		bt2[i] = bt[i] < 0 ? (int)((Byte.MAX_VALUE + 1) * 2 + bt[i]) : bt[i];
    		temp |= (bt2[i] << (8*(2-i)));
    	}
    	return temp;
    }
	  
    public static int Int(byte[] bt){

    	int temp = 0;
    	int[] bt2 = new int[4];

    	for(int i=0; i<4; i++)
    	{
    		bt2[i] = bt[i] < 0 ? ((Byte.MAX_VALUE + 1) * 2) + bt[i] : bt[i];
    		temp |= (bt2[i] << (8*(3-i)));
    	}
    	return temp;
    }
    
    public static int Long(byte[] bt){
    	int temp = 0;
    	int[] bt2 = new int[8];

    	for(int i=0; i<8; i++)
    	{
    		bt2[i] = bt[i] < 0 ? ((Byte.MAX_VALUE + 1) * 2) + bt[i] : bt[i];
    		temp |= (bt2[i] << (8*(7-i)));
    	}
    	return temp;
    }
   
}
