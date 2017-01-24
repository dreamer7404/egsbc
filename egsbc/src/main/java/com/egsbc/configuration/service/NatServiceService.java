package com.egsbc.configuration.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.configuration.NatServiceVO;
import com.egsbc.utils.Bytes;

@Service("natServiceService")
public class NatServiceService  {

	@Resource(name="natServiceDao")
	private NatServiceDao natServiceDao;
	
	
	public List<NatServiceVO> getNatService() throws Exception {
		return natServiceDao.getNatService();
	}
	
	/*
	 * create NatService
	 */
	public byte[] createNatService(NatServiceVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getIdx());
			list.add(vo.getName());
			list.add(vo.getiPType());
			list.add(vo.getProtocol());
			list.add(vo.getProxyMode());
			list.add(vo.getIpkts());
			list.add(vo.getPacketPerSec());
			list.add(vo.getPineHoleDuration());
			list.add(vo.getSourceIp());
			list.add(vo.getIncommingIntfAlias());
			list.add(vo.getIncommingIntfMinPort());
			list.add(vo.getIncommingIntfMaxPort());
			list.add(vo.getOutgoingIntfAlias());
			list.add(vo.getDestinationIp());
			list.add(vo.getDestinationMinPort());
			list.add(vo.getDestinationMaxPort());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
}
