package com.egsbc.utils.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.egsbc.utils.FromBytes;
import com.egsbc.utils.Global;
import com.egsbc.utils.IPC;
import com.egsbc.utils.ToBytes;

@Service("ipcService")
public class IPCService {
	
	private static final Logger logger = LoggerFactory.getLogger(IPC.class);
	
	private static int seq = 0;

	@Value("${Host}") 
	private String host;
	
	@Value("${Port}") 
	private int port;
	
	@Value("${SoTimeout}") 
	private int soTimeout;
	
	public byte[] request(int classCode, short opMode, byte[] body) throws Exception {
		
		Socket clientSocket = null;
		DataOutputStream outToServer = null;
		
		byte[] head = null;
		byte[] requestData = null;
		byte[] responseData = null;
        byte[] buff = new byte[3000];
        
        try{
        	
        	// join head and body
        	head = createHeader(classCode, opMode, body.length);
			requestData = new byte[head.length+body.length];
			System.arraycopy(head, 0, requestData, 0, head.length);					// input head
			System.arraycopy(body, 0, requestData, head.length, body.length);		// input body
			
			
			
			//================== DEBUGGING  ===========================================================
			int lineCnt = 1;
			String line="[" + lineCnt + "] ";
			 logger.info("==================== requestData (" + requestData.length + " Bytes) " + host + ":" + port + "===================================");
			 for(int j=0; j < requestData.length; ++j){
				 line += String.format("%02X ", (0xFF & requestData[j]));
				  if((j+1)%10==0){
					  logger.info(line);
					  lineCnt += 1;
					  line="[" + lineCnt + "] ";
			      }
			 }
			 logger.info(line);
			 line = "";
			//================== // DEBUGGING  ===========================================================
        	
        	clientSocket = new Socket(host, port);
        	clientSocket.setSoTimeout(7000); //soTimeout);
		
			// send
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.write(requestData);    
			outToServer.flush();
			
			
			 logger.info("[IPC SEND OK !!!]");
			
			
			// read
			int receivedSize = clientSocket.getInputStream().read(buff);
			if(receivedSize != 0){
				 responseData = new byte[receivedSize];
				 
				 for(int i=0; i < receivedSize; i++){
					 responseData[i] = buff[i];
				 }
			 }
			
			//================== DEBUGGING  ===========================================================
			lineCnt = 1;
			line="[" + lineCnt + "] ";
			logger.info("==================== responseData. (" + responseData.length + " Bytes) " + host + ":" + port + "===================================");
			 for(int j=0; j < responseData.length; ++j){
				 line += String.format("%02X ", (0xFF & responseData[j]));
				  if((j+1)%10==0){
					  logger.info(line);
					  lineCnt += 1;
					  line="[" + lineCnt + "] ";
			      }
			 }
			 logger.info(line);
			//================== // DEBUGGING  ===========================================================
			
        }catch (SocketException e) { 
        	logger.info("############# IPC ERROR : " + getRootCause(e).getMessage());
        	return createErrorFooterr(requestData, Global.ERR_SOCKET, getRootCause(e).getMessage());
        } catch (UnknownHostException e) { 
        	logger.info("############# IPC ERROR : " + getRootCause(e).getMessage());
        	return createErrorFooterr(requestData, Global.ERR_UNKNOWNHOST, getRootCause(e).getMessage());
        } catch (IOException e) { 	
        	logger.info("############# IPC ERROR : " + getRootCause(e).getMessage());
        	return createErrorFooterr(requestData, Global.ERR_IO, getRootCause(e).getMessage());
        }catch(Exception e){
        	logger.info("############# IPC ERROR : " + getRootCause(e).getMessage());
        	return createErrorFooterr(requestData, Global.ERR, getRootCause(e).getMessage());
        }finally{
        	if(outToServer != null){
        		try {
        			outToServer.close();
    			} catch (IOException e) {
    				logger.info("############# IPC ERROR : " + getRootCause(e).getMessage());
    				return createErrorFooterr(requestData, Global.ERR_IO, getRootCause(e).getMessage());
    		    }
        	}
        	if(clientSocket != null){
        		try {
        			clientSocket.close();
    			} catch (IOException e) {
    				logger.info("############# IPC ERROR : " + getRootCause(e).getMessage());
    				return createErrorFooterr(requestData, Global.ERR_IO, getRootCause(e).getMessage());
    		    }
        	}
        }
		
		return responseData;
	}
		
	private static Throwable getRootCause(Throwable throwable) {
	    if (throwable.getCause() != null)
	        return getRootCause(throwable.getCause());

	    return throwable;
	}	
	
	public static byte[] createHeader(int classCode, short opMode, int size){
		
		byte[] head = new byte[20];
		int idx = 0;
		
		seq = (++seq < Integer.MAX_VALUE) ? seq : 1;
		
		try{ 
			 System.arraycopy(ToBytes.Short((short)1), 	0, head, idx,	Global.SHO_LEN); 	idx+=Global.SHO_LEN;	// 헤더 유형(2)
			 System.arraycopy(ToBytes.Int((int)classCode),	0, head, idx, 	Global.INT_LEN); 	idx+=Global.INT_LEN; 	// 아이템 유형 코드 (4)
			 System.arraycopy(ToBytes.Short(opMode), 	0, head, idx, 	Global.SHO_LEN); 	idx+=Global.SHO_LEN;	// 동작모드(2)
			 System.arraycopy(ToBytes.Int(seq), 				0, head, idx, 	Global.INT_LEN); 	idx+=Global.INT_LEN; 	// 순번(4)
			 System.arraycopy(ToBytes.Int(size), 				0, head, idx,	Global.INT_LEN); 	idx+=Global.INT_LEN; 	// 메시지 Body 길이 (4)
			 System.arraycopy(ToBytes.Int(0), 				0, head, idx,	Global.INT_LEN);  	// internal use only
			 
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return head;
	}
	private static byte[] createErrorFooterr(byte[] requestData, int errorCode, String msg) {
		
		byte[] responseData = new byte[requestData.length + Global.ERR_DATA_LEN];
		
		System.arraycopy(requestData, 						0, 	responseData, 0, 																			requestData.length); // requestData
    	System.arraycopy(ToBytes.Int(errorCode), 		0, 	responseData, requestData.length, 													Global.INT_LEN); // errorCode
    	System.arraycopy(ToBytes.Short((short)1), 	0, 	responseData, requestData.length+Global.INT_LEN, 							Global.SHO_LEN); // error array count
    	System.arraycopy(ToBytes.Char64(msg), 		0, 	responseData, requestData.length+Global.INT_LEN+Global.SHO_LEN, 	Global.STR_LEN); // error msg
    	
    	return responseData;
	}

	
	/*
	 * get result list (errorCode + error msg list)
	 * 
	 */
	public List<String> getResultList(byte[] responseData, int bodySize) throws Exception {

		byte[] bError = new byte[Global.INT_LEN];
		 byte[] bMsg = new byte[Global.STR_LEN];
		 int errorCode = 0;
		 
		 int sentSize = bodySize + 20;
		 
		 List<String> resultList = new ArrayList<String>();
		 
		 // get errorCode
		 System.arraycopy(responseData, sentSize, bError, 0, Global.INT_LEN);
		 errorCode = FromBytes.Int(bError);
		 resultList.add(String.valueOf(errorCode));
		 
		 // get error msg
		 if(errorCode != 0){
			 // error msg count
			 short cnt = 0;
			 byte[] bCnt = new byte[Global.SHO_LEN];
			 int idxDataCount =  responseData.length - Global.ERR_DATA_LEN + Global.INT_LEN;
			 System.arraycopy(responseData, idxDataCount, bCnt, 0, Global.SHO_LEN); // get cnt
			 cnt = (short) FromBytes.Short(bCnt);
			 
			 if(cnt > 0 && cnt < 6){
				 for(int i=0; i<cnt; i++){
					 int idx = responseData.length - Global.ERR_DATA_LEN + Global.INT_LEN + Global.SHO_LEN + (Global.STR_LEN * i);
					 System.arraycopy(responseData, idx, bMsg, 0, Global.STR_LEN); // get msg
					 resultList.add(new String(bMsg));
				 }
			 }
		 }
		 
		 return resultList;
	}

}
