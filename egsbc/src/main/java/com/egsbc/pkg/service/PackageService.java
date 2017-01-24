package com.egsbc.pkg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.configuration.SipRealmVO;
import com.egsbc.pkg.PackageBlockVO;
import com.egsbc.pkg.PackageVO;
import com.egsbc.utils.Bytes;

@Service("packageService")
public class PackageService {
	
	@Resource(name="packageDao")
	private PackageDao packageDao;

	public List<PackageVO> getPackage(int side) throws Exception {
		return packageDao.getPackage(side);
	}
	
	public List<PackageBlockVO> getPackageBlock(PackageBlockVO vo) throws Exception{
		return packageDao.getPackageBlock(vo);
	}
	
	
	/*
	 * create Package
	 */
	public byte[] createPackage(PackageVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getSide()));
			list.add(new ClassTypeVO(vo.getPkgVer()));
			list.add(new ClassTypeVO(vo.getRunning()));
			list.add(new ClassTypeVO(vo.getSize()));
			list.add(new ClassTypeVO(vo.getBuilder()));
			list.add(new ClassTypeVO(vo.getValidate()));
			list.add(new ClassTypeVO(vo.getDateBuild()));
			list.add(new ClassTypeVO(vo.getDateInstall()));
			list.add(new ClassTypeVO(vo.getLicense(), 1024));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
}
