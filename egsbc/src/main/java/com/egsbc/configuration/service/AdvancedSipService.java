package com.egsbc.configuration.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.configuration.PrimitiveNwIntfVO;
import com.egsbc.configuration.SipConfigExtVO;
import com.egsbc.configuration.SipConfigServiceVO;
import com.egsbc.configuration.SipConfigStackVO;
import com.egsbc.configuration.SipConfigTimerVO;
import com.egsbc.utils.Bytes;

@Service("advancedSipService")
public class AdvancedSipService{
	
	@Resource(name="advancedSipDao")
	private AdvancedSipDao advancedSipDao;

	public List<SipConfigStackVO> getSipConfigStack() throws Exception {
		return advancedSipDao.getSipConfigStack();
	}
	
	public List<SipConfigTimerVO> getSipConfigTimer() throws Exception {
		return advancedSipDao.getSipConfigTimer();
	}
	
	public List<SipConfigServiceVO> getSipConfigService() throws Exception {
		return advancedSipDao.getSipConfigService();
	} //
	
	public List<SipConfigExtVO> getSipConfigExt() throws Exception {
		return advancedSipDao.getSipConfigExt();
	}
	
	
	public byte[] createSipStatck(SipConfigStackVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			list.add(vo.getWorkThreadCount());
			list.add(vo.getDispatchThreadCount());
			list.add(vo.getCallObjectCount());
			list.add(vo.getTcpTimeout());
			list.add(vo.getTcpMsgSize());
			list.add(vo.getUdpMsgSize());
			list.add(vo.getKeepAliveTime());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	} 
	
	
	public byte[] createSipConfigTimer(SipConfigTimerVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			list.add(vo.getTimerT1());
			list.add(vo.getTimerK());
			list.add(vo.getTimerJ());
			list.add(vo.getTimerD());
			list.add(vo.getTimerI());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	} 
	
	public byte[] createSipConfigService(SipConfigServiceVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			list.add(vo.getProvider());
			list.add(vo.getRingBackTimeout());
			list.add(vo.getResponseTimeout());
			list.add(vo.getActCount());
			list.add(vo.getActInterval());
			list.add(vo.getFailCount());
			list.add(vo.getFailInterval());
			list.add(vo.getSwitchOn());
			list.add(vo.getPassertMode());
			list.add(vo.getCaEnable());
			list.add(vo.getCaInterval());
			list.add(vo.getCaForceDrop());
			list.add(vo.getSrtpEncType());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	} 
	
	public byte[] createSipConfigExt(SipConfigExtVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			list.add(vo.getLogSupport());
			list.add(vo.getLogMsg());
			list.add(vo.getLogInfoLevel());
			list.add(vo.getLogInfoClass());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	} 

}
