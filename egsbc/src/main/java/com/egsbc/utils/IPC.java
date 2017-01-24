package com.egsbc.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public class IPC {
	
	@Value("${Host}") 
	private static String host;
	
	@Value("${Port}") 
	private static int port;
	
	@Value("${SoTimeout}") 
	private static int soTimeout;
	
	private static final Logger logger = LoggerFactory.getLogger(IPC.class);
	
	private static int seq = 0;

	public static byte[] request(short opMode, byte[] body) {
		
		Socket clientSocket = null;
		DataOutputStream outToServer = null;
		
		byte[] head = null;
		byte[] requestData = null;
		byte[] responseData = null;
        byte[] buff = new byte[2048];
        
        
        try{
        	
        	// join head and body
        	head = createHeader(opMode, body.length);
			requestData = new byte[head.length+body.length];
			System.arraycopy(head, 0, requestData, 0, head.length);					// input head
			System.arraycopy(body, 0, requestData, head.length, body.length);		// input body
			
			
			
			//================== DEBUGGING  ===========================================================
			 System.out.println("==================== requestData (" + requestData.length + ") ===================================");
			 for(int j=0; j < requestData.length; ++j){
		         System.out.print(String.format("%02X ", (0xFF & requestData[j])));    
		         if((j+1)%10==0){
		        	 System.out.print("\n");
		         }
	    	   }
			 System.out.print("\n");
			 
			 
			 String line="";
			 logger.info("==================== requestData (" + requestData.length + ") ===================================");
			 for(int j=0; j < requestData.length; ++j){
				 line += String.format("%02X ", (0xFF & requestData[j]));
				  if((j+1)%10==0){
					  logger.info(line);
					  line = "";
			      }
			 }
			//================== // DEBUGGING  ===========================================================
        	
        	clientSocket = new Socket(host, port);
        	clientSocket.setSoTimeout(soTimeout);
		
			// send
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.write(requestData);    
			outToServer.flush();
			
			
			
			
			
			// receive
			//BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//modifiedSentence = inFromServer.readLine();
			//System.out.println("FROM TCP SERVER: " + modifiedSentence);
			
			
			
			// read
			int receivedSize = clientSocket.getInputStream().read(buff);
			if(receivedSize != 0){
				 responseData = new byte[receivedSize];
				 
				 for(int i=0; i < receivedSize; i++){
					 responseData[i] = buff[i];
				 }
			 }
			
			logger.info("==================== requestData (" + requestData.length + ") ===================================");
			 for(int j=0; j < requestData.length; ++j){
				 line += String.format("%02X ", (0xFF & requestData[j]));
				  if((j+1)%10==0){
					  logger.info(line);
					  line = "";
			      }
			 }
			 
			
        }catch (SocketException e) { 
        	return createErrorFooterr(requestData, Global.ERR_SOCKET, getRootCause(e).getMessage());
        } catch (UnknownHostException e) { 
        	return createErrorFooterr(requestData, Global.ERR_UNKNOWNHOST, getRootCause(e).getMessage());
        } catch (IOException e) { 	
        	return createErrorFooterr(requestData, Global.ERR_IO, getRootCause(e).getMessage());
        }catch(Exception e){
        	return createErrorFooterr(requestData, Global.ERR, getRootCause(e).getMessage());
        }finally{
        	if(outToServer != null){
        		try {
        			outToServer.close();
    			} catch (IOException e) {
    				return createErrorFooterr(requestData, Global.ERR_IO, getRootCause(e).getMessage());
    		    }
        	}
        	if(clientSocket != null){
        		try {
        			clientSocket.close();
    			} catch (IOException e) {
    				return createErrorFooterr(requestData, Global.ERR_IO, getRootCause(e).getMessage());
    		    }
        	}
        }
		
		return responseData;
	}
	private static byte[] createErrorFooterr(byte[] requestData, int errorCode, String msg) {
		
		byte[] responseData = new byte[requestData.length + Global.ERR_DATA_LEN];
		
		System.arraycopy(requestData, 						0, 	responseData, 0, 																			requestData.length); // requestData
    	System.arraycopy(ToBytes.Int(errorCode), 		0, 	responseData, requestData.length, 													Global.INT_LEN); // errorCode
    	System.arraycopy(ToBytes.Short((short)1), 	0, 	responseData, requestData.length+Global.INT_LEN, 							Global.SHO_LEN); // error array count
    	System.arraycopy(ToBytes.Char64(msg), 		0, 	responseData, requestData.length+Global.INT_LEN+Global.SHO_LEN, 	Global.STR_LEN); // error msg
    	
    	return responseData;
	}
	private static Throwable getRootCause(Throwable throwable) {
	    if (throwable.getCause() != null)
	        return getRootCause(throwable.getCause());

	    return throwable;
	}
	
	
	public static byte[] createHeader(short opMode, int size){
		
		byte[] head = new byte[20];
		int idx = 0;
		
		seq = (++seq < Integer.MAX_VALUE) ? seq : 1;
		
		try{ 
			 System.arraycopy(ToBytes.Short((short)1), 	0, head, idx,	Global.SHO_LEN); 	idx+=Global.SHO_LEN;	// 헤더 유형(2)
			 System.arraycopy(ToBytes.Int((int)0x2001),	0, head, idx, 	Global.INT_LEN); 	idx+=Global.INT_LEN; 	// 아이템 유형 코드 (4)
			 System.arraycopy(ToBytes.Short(opMode), 	0, head, idx, 	Global.SHO_LEN); 	idx+=Global.SHO_LEN;	// 동작모드(2)
			 System.arraycopy(ToBytes.Int(seq), 				0, head, idx, 	Global.INT_LEN); 	idx+=Global.INT_LEN; 	// 순번(4)
			 System.arraycopy(ToBytes.Int(size), 				0, head, idx,	Global.INT_LEN); 	idx+=Global.INT_LEN; 	// 메시지 Body 길이 (4)
			 System.arraycopy(ToBytes.Int(0), 				0, head, idx,	Global.INT_LEN);  	// internal use only
			 
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return head;
	}
	
	
	public static Map<String, Object> ConverObjectToMap(Object obj){
		try {
			//Field[] fields = obj.getClass().getFields(); //private field는 나오지 않음.
			Field[] fields = obj.getClass().getDeclaredFields();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			for(int i=0; i<=fields.length-1;i++){
				fields[i].setAccessible(true);
				resultMap.put(fields[i].getName(), fields[i].get(obj));
			}
			return resultMap;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}



	
	
	
}
