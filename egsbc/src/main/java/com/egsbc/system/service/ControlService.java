package com.egsbc.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.system.PrimitiveSysDupVO;
import com.egsbc.system.PrimitiveSysProcessVO;
import com.egsbc.system.ProcessControlVO;
import com.egsbc.system.SystemControlVO;
import com.egsbc.utils.Bytes;

@Service("controlService")
public class ControlService {
	
	@Resource(name="controlDao")
	private ControlDao controlDao;

	public byte[] createSystemControl(SystemControlVO vo) throws Exception {
		byte[] body = null;
		
		ProcessControlVO vo2 = new ProcessControlVO();
		
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getControlClass());
			list.add(vo.getControlHost());
			list.add(vo.getSystemControlMode());
			list.add(vo.getSystemControlOpMode());
			list.add(vo.getSystemControlDummy1());
			list.add(vo.getSystemControlDummy2());
			
			// ProcessControlVO dummy
			list.add(vo2.getProcess());
			list.add(vo2.getProcessControlMode());
			list.add(vo2.getProcessControlDummy1());
			list.add(vo2.getProcessControlDummy2());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return body;
	}

	public byte[] createProcessControl(ProcessControlVO vo) throws Exception {
		byte[] body = null;
		SystemControlVO vo2 = new SystemControlVO();
		
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getControlClass());
			list.add(vo.getControlHost());
			
			// SystemControlVO dummy
			list.add(vo2.getSystemControlMode());
			list.add(vo2.getSystemControlOpMode());
			list.add(vo2.getSystemControlDummy1());
			list.add(vo2.getSystemControlDummy2());
			
			list.add(vo.getProcess()); // 0 ~ 8
			list.add(vo.getProcessControlMode()); // 0, 1
			list.add(vo.getProcessControlDummy1());
			list.add(vo.getProcessControlDummy2());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return body;
	}
	
	
	

	
	public List<PrimitiveSysProcessVO> getPrimitiveSysProcess() throws Exception {
		return controlDao.getPrimitiveSysProcess();
	}
	
	

}
