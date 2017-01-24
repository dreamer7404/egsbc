package com.egsbc.configuration.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.configuration.PrimitiveNwIntfVO;
import com.egsbc.utils.Bytes;

@Service("interfaceService")
public class InterfaceService{
	
	@Resource(name="interfaceDao")
	private InterfaceDao interfaceDao;

	public List<PrimitiveNwIntfVO> getInterface() throws Exception {
		return interfaceDao.getInterface();
	}

	public List<String> getInterfaceNameList() throws Exception {
		return interfaceDao.getInterfaceNameList();
	}
	
	public List<PrimitiveNwIntfVO> getInterfaceAliasList() throws Exception {
		return interfaceDao.getInterfaceAliasList();
	}

	public List<String> getInterfaceNameListForAdd() throws Exception {
		return interfaceDao.getInterfaceNameListForAdd();
	}
	
	public List<String> getInterfaceAliasForNat() throws Exception {
		return interfaceDao.getInterfaceAliasForNat();
	}
	
	

//	public byte[] createInterface(PrimitiveNwIntfVO vo) throws Exception {
//		
//		byte[] tmp = new byte[1024];
//		byte[] body = null;
//		int idx = 0;
//		
//		try{ 
//			System.arraycopy(ToBytes.Int(vo.getIdx()),						0, tmp, idx, Global.INT_LEN);  idx+=Global.INT_LEN;	// T_SIDE
//			System.arraycopy(ToBytes.Short(vo.getSide()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	// T_SIDE
//			System.arraycopy(ToBytes.Char64(vo.getIntfName()), 		0, tmp, idx, Global.STR_LEN); idx+=Global.STR_LEN; 	// T_INTF_NAME
//			System.arraycopy(ToBytes.Char64(vo.getIntfAlias()), 		0, tmp, idx, Global.STR_LEN); idx+=Global.STR_LEN;	// T_INTF_ALIAS
//			System.arraycopy(ToBytes.Short(vo.getSide()), 				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_INTF_TYPE
//			System.arraycopy(ToBytes.Short(vo.getIntfMedia()), 		0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_INTF_MEDIA
//			System.arraycopy(ToBytes.Short(vo.getIntfUsage()), 		0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_INTF_USAGE
//			System.arraycopy(ToBytes.Short(vo.getIntfSindex()), 		0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_INTF_SINDEX
//			System.arraycopy(ToBytes.Char64(vo.getIntfParent()),		0, tmp, idx, Global.STR_LEN); idx+=Global.STR_LEN;	//T_INTF_PARENT
//			System.arraycopy(ToBytes.Short(vo.getIntfUsedFlag()),		0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_INTF_USED_FLAG
//			System.arraycopy(ToBytes.Short(vo.getIpMode()),			0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_IP_MODE
//			System.arraycopy(ToBytes.Short(vo.getIpType()),			0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_IP_TYPE
//			System.arraycopy(ToBytes.Char64(vo.getIp()),					0, tmp, idx, Global.STR_LEN); idx+=Global.STR_LEN;	//T_IP
//			System.arraycopy(ToBytes.Short(vo.getIpPrefix()),			0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_IP_PREFIX
//			System.arraycopy(ToBytes.Char64(vo.getGateway()),		0, tmp, idx, Global.STR_LEN); idx+=Global.STR_LEN;	//T_GATEWAY
//			System.arraycopy(ToBytes.Char64(vo.getVmac()),			0, tmp, idx, Global.STR_LEN); idx+=Global.STR_LEN;	//T_VMAC
//			System.arraycopy(ToBytes.Short(vo.getLrside()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_LRSIDE
//			
//			System.arraycopy(ToBytes.Short(vo.getExtLink()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_EXT_LINK
//			System.arraycopy(ToBytes.Short(vo.getExtNego()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_EXT_NEGO
//			System.arraycopy(ToBytes.Short(vo.getExtSpeed()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_EXT_SPEED
//			System.arraycopy(ToBytes.Short(vo.getExtFlowCtrl()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_EXT_FLOWCTRL
//			System.arraycopy(ToBytes.Short(vo.getExtDummy1()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_EXT_DUMMY1
//			System.arraycopy(ToBytes.Short(vo.getExtDummy2()),				0, tmp, idx, Global.SHO_LEN); idx+=Global.SHO_LEN;	//T_EXT_DUMMY2
//			
//			body = new byte[idx];
//			System.arraycopy(tmp, 0, body, 0, idx);
//					
//		}catch(Exception e){
//			e.getStackTrace();
//		}
//		
//		return body;
//	}
	
	public byte[] createInterface(PrimitiveNwIntfVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getIdx());
			list.add(vo.getSide());
			list.add(vo.getIntfName());
			list.add(vo.getIntfAlias());
			list.add(vo.getIntfType());
			list.add(vo.getIntfMedia());
			list.add(vo.getIntfUsage());
			list.add(vo.getIntfSindex());
			list.add(vo.getIntfParent());
			list.add(vo.getIntfUsedFlag());
			list.add(vo.getIpMode());
			list.add(vo.getIpType());
			list.add(vo.getIp());
			list.add(vo.getIpPrefix());
			list.add(vo.getSrcRouteFlag());
			list.add(vo.getGateway());
			list.add(vo.getVmac());
			list.add(vo.getLrside());
			list.add(vo.getExtLink());
			list.add(vo.getExtNego());
			list.add(vo.getExtSpeed());
			list.add(vo.getExtFlowCtrl());
			list.add(vo.getExtDummy1());
			list.add(vo.getExtDummy2());
			list.add(vo.getDummy1());
			list.add(vo.getDummy2());
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}

}
