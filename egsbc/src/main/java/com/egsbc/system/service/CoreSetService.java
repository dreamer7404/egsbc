package com.egsbc.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.configuration.PrimitiveConfigVO;
import com.egsbc.configuration.StaticACLVO;
import com.egsbc.system.NtpConfigVO;
import com.egsbc.system.NtpDateVO;
import com.egsbc.system.NtpServerVO;
import com.egsbc.system.NtpVO;
import com.egsbc.system.UserEmailServerVO;
import com.egsbc.utils.Bytes;

@Service("coreSetService")
public class CoreSetService {
	
	@Resource(name="coreSetDao")
	private CoreSetDao coreSetDao;
	
	
	public List<PrimitiveConfigVO> getConfigNtp() throws Exception {
		return coreSetDao.getConfigNtp();
	}
	
	public List<NtpServerVO> getNtpServer() throws Exception {
		return coreSetDao.getNtpServer();
	}
	
	public int addNtpServer(String serverName) throws Exception {
		return coreSetDao.addNtpServer(serverName);
	}
	
	public int removeNtpServer(List<String> list) throws Exception {
		return coreSetDao.removeNtpServer(list);
	}
	
	public NtpConfigVO getNtpConfig()  throws Exception {
		return coreSetDao.getNtpConfig();
	}
	
	public UserEmailServerVO getUserEmailServer() throws Exception {
		return coreSetDao.getUserEmailServer();
    }
	
	public int addUserEmailServer (UserEmailServerVO vo) throws Exception {
		return coreSetDao.addUserEmailServer(vo);
	}
	
	public int setUserEmailServer (UserEmailServerVO vo) throws Exception {
		return coreSetDao.setUserEmailServer(vo);
	}
	
	/*
	 * createNtpServer
	 */
	public byte[] createNtpServer(NtpVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			if(vo.getOpMode()==5){ // save(적용)시
				list.add(new ClassTypeVO(vo.getSystemDateTimeMode()));
				list.add(new ClassTypeVO(vo.getNtpClientMinPoll()));
				list.add(new ClassTypeVO(vo.getNtpClientMaxPoll()));
				list.add(new ClassTypeVO(vo.getStaticSystemDateTime(), 64));
				list.add(new ClassTypeVO(vo.getNtpServerMode()));
				list.add(new ClassTypeVO(vo.getNtpServerRestrictIp(), 64));
				list.add(new ClassTypeVO(vo.getNtpServerRestrictIpPrifixLen()));
			}
			else{ // server 추가,삭제시
				list.add(new ClassTypeVO(vo.getNtpHost(), 256));
			}
			
			body = Bytes.arrayCopy2(list);
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createNtpDate
	 */
	public byte[] createNtpDate(NtpDateVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getNtpCommand()));
			list.add(new ClassTypeVO(vo.getSide()));
			list.add(new ClassTypeVO(vo.getDirectlySystemDatetime(), 64));
			list.add(new ClassTypeVO(vo.getOnOffFlag()));
			list.add(new ClassTypeVO(vo.getNtpServerIp(), 64));
			list.add(new ClassTypeVO(vo.getNtpReserved()));
				
			body = Bytes.arrayCopy2(list);
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
}
