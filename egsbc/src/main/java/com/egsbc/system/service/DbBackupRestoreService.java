package com.egsbc.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.system.DbBackupRestoreVO;
import com.egsbc.utils.Bytes;

@Service("dbBackupRestoreService")
public class DbBackupRestoreService {
	

	/*
	 * create DbRestore
	 */
	public byte[] createDbRestore(DbBackupRestoreVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getDbName(), 256));
			list.add(new ClassTypeVO(vo.getFileName(), 256));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	
	/*
	 * create DbBackup
	 */
	public byte[] createDbBackup(DbBackupRestoreVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getDbName(), 256));
			list.add(new ClassTypeVO(vo.getFileName(), 256));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
}
