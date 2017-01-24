package com.egsbc.utils.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.egsbc.utils.FromBytes;
import com.egsbc.utils.Global;

@Service("byteService")
public class ByteService {

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
