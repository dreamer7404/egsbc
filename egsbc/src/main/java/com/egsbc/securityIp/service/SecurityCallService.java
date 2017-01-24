package com.egsbc.securityIp.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.configuration.PrimitiveConfigVO;
import com.egsbc.securityIp.GeoIpConfigVO;
import com.egsbc.securityIp.GeoIpDateVO;
import com.egsbc.securityIp.GeoIpExcludeVO;
import com.egsbc.securityIp.GeoIpNationVO;
import com.egsbc.securityIp.GeoIpVO;
import com.egsbc.securityIp.SecCallOverseasVO;
import com.egsbc.securityIp.SecCallPatternVO;
import com.egsbc.securityIp.SecGeoIpVO;
import com.egsbc.securityIp.SecImSignaturesVO;
import com.egsbc.securityIp.SecImSignaturesValVO;
import com.egsbc.securityIp.SecOverviewVO;
import com.egsbc.securityIp.SecUserAgentVO;
import com.egsbc.utils.Bytes;

@Service("securityCallService")
public class SecurityCallService {

	@Resource(name="securityCallDao")
	private SecurityCallDao securityCallDao;
	
	
	public SecOverviewVO getSecOverview() throws Exception {
		return securityCallDao.getSecOverview();
	}
	
	public List<SecGeoIpVO> getSecGeoIp() throws Exception {
		return securityCallDao.getSecGeoIp();
	}
	
	public List<GeoIpExcludeVO> getSecGeoExcludeList()  throws Exception {
		return securityCallDao.getSecGeoExcludeList();
	}
	
	
	
	public List<SecUserAgentVO> getSecUserAgent() throws Exception {
		return securityCallDao.getSecUserAgent();
	}
	
	public SecCallPatternVO getSecCallPattern() throws Exception {
		return securityCallDao.getSecCallPattern();
	}
	
	public List<SecCallOverseasVO> getSecCallOverseas() throws Exception {
		return securityCallDao.getSecCallOverseas();
	}
	
	public List<SecCallOverseasVO> getSecCallOverseasUser() throws Exception {
		return securityCallDao.getSecCallOverseasUser();
	}
	
	public List<SecCallOverseasVO> getSecCallGapping() throws Exception {
		return securityCallDao.getSecCallGapping();
	}
	
	public SecImSignaturesVO getSecImSignatureHdr() throws Exception {
		return securityCallDao.getSecImSignatureHdr();
	}
	public List<SecImSignaturesValVO> getSecImSignatureVal() throws Exception {
		return securityCallDao.getSecImSignatureVal();
	}
	
	public List<PrimitiveConfigVO> getGeoIpConfig() throws Exception {
		return securityCallDao.getGeoIpConfig();
	}
	
	public String getSecurityGeoIp() throws Exception {
		return securityCallDao.getSecurityGeoIp();
	}

	public List<GeoIpVO> getGeoIpList(HttpServletRequest request) throws Exception {
		return securityCallDao.getGeoIpList();
	}
	
	public String toAbsolutePath(String maybeRelative) {
	    Path path = Paths.get(maybeRelative);
	    Path effectivePath = path;
	    if (!path.isAbsolute()) {
	        Path base = Paths.get("");
	        effectivePath = base.resolve(path).toAbsolutePath();
	    }
	    return effectivePath.normalize().toString();
	}
	
	public List<GeoIpDateVO> getNationCodeList(String nationCode)  throws Exception {
		return securityCallDao.getNationCodeList(nationCode);
	}
	
	
	/*
	 * createGeoIpExclude
	 */
	
	public byte[] createGeoIpExclude(GeoIpExcludeVO vo) throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getGeoExIpKey(), 32));
			list.add(new ClassTypeVO(vo.getGeoExIpMatchType()));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	/*
	 * createSecOverview
	 */
	public byte[] createSecOverview(SecOverviewVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getSecOvUagentMode());
			list.add(vo.getSecOvUagentPolicy());
			list.add(vo.getSecOvGeoIpMode());
			list.add(vo.getSecOvCallPatternMode());
			list.add(vo.getSecOvCallOverseasMode());
			list.add(vo.getSecOvCallOverseasPolicy());
			list.add(vo.getSecOvCallGappingMode());
			list.add(vo.getSecOvImSignatureMode());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	/*
	 * createGeoIp
	 */
	public byte[] createGeoIp(GeoIpConfigVO vo, SecOverviewVO secOverviewVO) throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			// SecOverviewVO
			list.add(new ClassTypeVO(secOverviewVO.getSecOvUagentMode()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvUagentPolicy()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvGeoIpMode()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvCallPatternMode()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvCallOverseasPolicy()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvCallOverseasPolicy()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvCallGappingMode()));
			list.add(new ClassTypeVO(secOverviewVO.getSecOvImSignatureMode()));
			
			// GeoIpConfigVO
			list.add(new ClassTypeVO(vo.getGeoIpOperMode()));
			list.add(new ClassTypeVO(vo.getGeoIpDbUpdateTime()));
			list.add(new ClassTypeVO(vo.getGeoIpDbAvailableTerm()));
			list.add(new ClassTypeVO(vo.getGeoIpNationRule()));
//			list.add(new ClassTypeVO(vo.getGeoIpNationCount())); // 삭제요청
			
			for(GeoIpNationVO geoIpNationVO : vo.getList()){
				list.add(new ClassTypeVO(geoIpNationVO.getGeoIpNationCode(), 4));
				list.add(new ClassTypeVO(geoIpNationVO.getGeoIpNationAction()));
			}
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	

	
	
	/*
	 * createSecUserAgent
	 */
	
	public byte[] createSecUserAgent(SecUserAgentVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getPolicyMode()));
			list.add(new ClassTypeVO(vo.getCondMethod()));
			list.add(new ClassTypeVO(vo.getCondHeader()));
			list.add(new ClassTypeVO(vo.getCondVal(), 64));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createSecGeoIp
	 */
	
//	public byte[] createSecGeoIp(SecGeoIpVO vo)  throws Exception {
//		byte[] body = null;
//		try{ 
//			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
//			
//			list.add(new ClassTypeVO(vo.getPolicyMode()));
//			list.add(new ClassTypeVO(vo.getCondVal(), 32));
//			
//			body = Bytes.arrayCopy2(list);
//		}catch(Exception e){
//			e.getStackTrace();
//		}
//		return body;
//	}
	
	/*
	 * createSecCallPattern
	 */
	
	public byte[] createSecCallPattern(SecCallPatternVO vo, SecOverviewVO secOverviewVO)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			
			// SecOverviewVO
			list.add(secOverviewVO.getSecOvUagentMode());
			list.add(secOverviewVO.getSecOvUagentPolicy());
			list.add(secOverviewVO.getSecOvGeoIpMode());
			list.add(secOverviewVO.getSecOvCallPatternMode());
			list.add(secOverviewVO.getSecOvCallOverseasPolicy());
			list.add(secOverviewVO.getSecOvCallOverseasPolicy());
			list.add(secOverviewVO.getSecOvCallGappingMode());
			list.add(secOverviewVO.getSecOvImSignatureMode());
						
						
			list.add(vo.getLimitEnable());
			list.add(vo.getLimitMaxCalls());
			list.add(vo.getLimitDurationM());
			list.add(vo.getTotalEnable());
			list.add(vo.getTotalDurationM());
			list.add(vo.getTotalDurationH());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createSecCallOverseas
	 */
	
	public byte[] createSecCallOverseas(SecCallOverseasVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getPolicyMode()));
			list.add(new ClassTypeVO(vo.getLimitMaxCalls()));
			list.add(new ClassTypeVO(vo.getLimitDurationS()));
			list.add(new ClassTypeVO(vo.getCondVal(), 32));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createSecCallOverseasUser
	 */
	
	public byte[] createSecCallOverseasUser(SecCallOverseasVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getPolicyMode()));
			list.add(new ClassTypeVO(vo.getCondVal(), 32));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createSecCallGapping
	 */
	
	public byte[] createSecCallGapping(SecCallOverseasVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getLimitMaxCalls()));
			list.add(new ClassTypeVO(vo.getLimitDurationS()));
			list.add(new ClassTypeVO(vo.getCondVal(), 32));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createSecImSignature
	 */
	
	public byte[] createSecImSignature(SecImSignaturesVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getCondHeader());
			list.add(vo.getCondCheck());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	/*
	 * createSecImSignatureVal
	 */
	
	public byte[] createSecImSignatureVal(SecImSignaturesValVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getCondVal(), 32));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
}
