package com.egsbc.configuration.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.configuration.TransportVO;
import com.egsbc.utils.Bytes;

@Service("transportService")
public class TransportService {

	@Resource(name="transportDao")
	private TransportDao transportDao;
	
	public List<TransportVO> getSipTransport() throws Exception {
		return transportDao.getSipTransport();
	}

	public List<TransportVO> getMediaTransport() throws Exception {
		return transportDao.getMediaTransport();
	}

	public List<TransportVO> getNatTransport() throws Exception {
		return transportDao.getNatTransport();
	}
	
	public List<String> getMediaTransportName() throws Exception {
		return transportDao.getMediaTransportName();
	}
	
	public List<String> getSipTransportName(int svcType) throws Exception {
		return transportDao.getSipTransportName(svcType);
	}

	public byte[] createSipTransport(TransportVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getVipName());
			list.add(vo.getSigPort());
			list.add(vo.getSvcType());
			list.add(vo.getTransType());
			list.add(vo.getQosType());
			list.add(vo.getQosValue());
			list.add(vo.getForkingMinport());
			list.add(vo.getForkingMaxport());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	public byte[] createMediaTransport(TransportVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getVipName());
			list.add(vo.getMinPort());
			list.add(vo.getMaxPort());
			list.add(vo.getQosType());
			list.add(vo.getQosValue());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	public byte[] createNatTransport(TransportVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getName());
			list.add(vo.getVipName());
			list.add(vo.getMinPort());
			list.add(vo.getMaxPort());
			list.add(vo.getProtocol());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}

}
