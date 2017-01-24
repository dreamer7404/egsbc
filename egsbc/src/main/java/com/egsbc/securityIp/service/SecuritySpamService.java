package com.egsbc.securityIp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.securityIp.GeoIpExcludeVO;
import com.egsbc.securityIp.SecSpamCallVO;
import com.egsbc.securityIp.SecSpamImVO;
import com.egsbc.securityIp.SecSpamVO;
import com.egsbc.utils.Bytes;

@Service("securitySpamService")
public class SecuritySpamService {
	
	@Resource(name="securitySpamDao")
	private SecuritySpamDao securitySpamDao;
	
	public SecSpamVO getSecSpam() throws Exception {
		return securitySpamDao.getSecSpam();
	}
	
	public SecSpamCallVO getSecSpamCall() throws Exception {
		return securitySpamDao.getSecSpamCall();
	}
	
	public SecSpamImVO getSecSpamIm() throws Exception {
		return securitySpamDao.getSecSpamIm();
	}
	
	
	/*
	 * createSecSpam
	 */
	
	public byte[] createSecSpam(SecSpamVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getEnable());
			list.add(vo.getActionMode());
			list.add(vo.getDuration());
			list.add(vo.getDropDuration());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	/*
	 * createSecSpamCall
	 */
	
	public byte[] createSecSpamCall(SecSpamCallVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getLimitEnable());
			list.add(vo.getLimitCount());
			list.add(vo.getDurationEnable());
			list.add(vo.getDurationCount());
			list.add(vo.getDurationS());
			list.add(vo.getIntervalEnable());
			list.add(vo.getIntervalCount());
			list.add(vo.getIntervalS());
			list.add(vo.getRejectEnable());
			list.add(vo.getRejectCount());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createSecSpamIm
	 */
	
	public byte[] createSecSpamIm(SecSpamImVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getLimitEnable());
			list.add(vo.getLimitCount());
			list.add(vo.getIntervalEnable());
			list.add(vo.getIntervalCount());
			list.add(vo.getIntervalS());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
}
