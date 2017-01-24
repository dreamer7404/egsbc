package com.egsbc.configuration.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.configuration.StaticACLVO;
import com.egsbc.utils.Bytes;

@Service("staticACLService")
public class StaticACLService  {

	@Resource(name="staticACLDao")
	private StaticACLDao staticACLDao;
	
	
	public List<StaticACLVO> getStaticACL(int usageACL) throws Exception {
		return staticACLDao.getStaticACL(usageACL);
	}
	
	public String getPrimitiveConfig(String argString) throws Exception {
		return staticACLDao.getPrimitiveConfig(argString);
	}
	
	/*
	 * createStaticACL
	 */
	public byte[] createStaticACL(StaticACLVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getIdx()));
			list.add(new ClassTypeVO(vo.getUsageACL()));
			list.add(new ClassTypeVO(vo.getIpType()));
			list.add(new ClassTypeVO(vo.getProtocol()));
			list.add(new ClassTypeVO(vo.getActionACL()));
			list.add(new ClassTypeVO(vo.getSourceIp()));
			list.add(new ClassTypeVO(vo.getSourcePort()));
			list.add(new ClassTypeVO(vo.getDestinationIp()));
			list.add(new ClassTypeVO(vo.getDestinationPort()));
			list.add(new ClassTypeVO(vo.getDescription(), 128));
			
			body = Bytes.arrayCopy2(list);
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
}
