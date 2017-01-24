package com.egsbc.overview.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.overview.CurrentNatEntryVO;
import com.egsbc.utils.Bytes;

@Service("overviewService")
public class OverviewService {
	
	@Resource(name="overviewDao")
	private OverviewDao overviewDao;
	
	public List<CurrentNatEntryVO> getCurrentNatEntry() throws Exception {
		return overviewDao.getCurrentNatEntry();
	}
	
	public byte[] createCurrentNatEntry(CurrentNatEntryVO vo) throws Exception {
		byte[] body = null;
		try{ 
			
			List<Object> list = new ArrayList<Object>();
			
			list.add(vo.getIdx());
			list.add(vo.getCreateDatetime());
			list.add(vo.getNatSvcName());
			list.add(vo.getBucketIndex());
			list.add(vo.getEntryIndex());
			
			list.add(vo.getInSrcIp());
			list.add(vo.getInSrcPort());
			list.add(vo.getInDstIp());
			list.add(vo.getInDstPort());
			
			list.add(vo.getOutSrcIp());
			list.add(vo.getOutSrcPort());
			list.add(vo.getOutDstIp());
			list.add(vo.getOutDstPort());
			
			list.add(vo.getProtocol());
			list.add(vo.getProxyMode());
			list.add(vo.getIpkts());
			
			body = Bytes.arrayCopy(list);
			
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}

}
