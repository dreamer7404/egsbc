package com.egsbc.configuration.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.egsbc.common.ClassTypeVO;
import com.egsbc.configuration.NatServiceVO;
import com.egsbc.configuration.SipConfigCertificationVO;
import com.egsbc.configuration.SipRealmVO;
import com.egsbc.configuration.TlsCertFileInfoVO;
import com.egsbc.configuration.TlsConfigVO;
import com.egsbc.utils.Bytes;

@Service("certificationService")
public class CertificationService  {
	
	private static final Logger logger = LoggerFactory.getLogger(CertificationService.class);

	@Resource(name="certificationDao")
	private CertificationDao certificationDao;
	
	@Value("${EccPath}") private String EccPath;
	@Value("${RsaPath}") private String RsaPath;
	@Value("${RsaPemPath}") private String RsaPemPath;
	@Value("${RsaDerPath}") private String RsaDerPath;
	@Value("${EccPemPath}") private String EccPemPath;
	@Value("${EccDerPath}") private String EccDerPath;
	
	
	public List<TlsConfigVO> getTlsConfig() throws Exception {
		return certificationDao.getTlsConfig();
	}
	
	/*
	 * createTlsConfig
	 */
	public byte[] createTlsConfig(TlsConfigVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getTlsVersion());
			list.add(vo.getCertType());
			list.add(vo.getFileType());
			list.add(vo.getVerify());
			list.add(vo.getEtc1());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	/*
	 * createTlsCertFileInfo
	 */
	public byte[] createTlsCertFileInfo(TlsCertFileInfoVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<ClassTypeVO> list = new ArrayList<ClassTypeVO>();
			
			list.add(new ClassTypeVO(vo.getCertMode()));
			list.add(new ClassTypeVO(vo.getFileType()));
			list.add(new ClassTypeVO(vo.getPrivateKeyFileEncryptFlag()));
			list.add(new ClassTypeVO(vo.getDerPassword(), 128));
			list.add(new ClassTypeVO(vo.getOrderedCipherList(), 256));
			
			body = Bytes.arrayCopy2(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	public List<TlsCertFileInfoVO> getTlsCertFileInfo() throws Exception {
		return certificationDao.getTlsCertFileInfo();
	}
	
	public TlsCertFileInfoVO getTlsCertFileInfoApplied () throws Exception {
		return certificationDao.getTlsCertFileInfoApplied();
	}
	
	public List<SipConfigCertificationVO> getSipConfigCertification() throws Exception {
		return certificationDao.getSipConfigCertification();
	}
	
	
	public List<SipConfigCertificationVO> getCertification(int certType)  throws Exception {
		
		// just for testing on Windows PC
		if(System.getProperty("os.name").contains("Windows")){
			EccPath = "C:\\egis\\etc\\pki\\ecc\\";
			RsaPath = "C:\\egis\\etc\\pki\\rsa\\";
			
			RsaPemPath = "C:\\egis\\etc\\pki\\rsa\\pem\\";
			RsaDerPath = "C:\\egis\\etc\\pki\\rsa\\der\\";
			
			EccPemPath = "C:\\egis\\etc\\pki\\ecc\\pem\\";
			EccDerPath = "C:\\egis\\etc\\pki\\ecc\\der\\";
	 	}
		
		
		List<SipConfigCertificationVO> list = new ArrayList<SipConfigCertificationVO>();
		
		
		if(certType==0){ // RSA
			list.addAll(getFileList(RsaPemPath, 0, 0));
			list.addAll(getFileList(RsaDerPath, 0, 1));
		}else if(certType==1){ // ECC
			list.addAll(getFileList(EccPemPath, 1, 0));
			list.addAll(getFileList(EccDerPath, 1, 1));
		}else{ // ALL
			list.addAll(getFileList(RsaPemPath, 0, 0));
			list.addAll(getFileList(RsaDerPath, 0, 1));
			list.addAll(getFileList(EccPemPath, 1, 0));
			list.addAll(getFileList(EccDerPath, 1, 1));
		}
		
		return list; 
		
		
	}
	
	private List<SipConfigCertificationVO> getFileList(String path, int tlsMode, int certType){
		
		List<SipConfigCertificationVO> list = new ArrayList<SipConfigCertificationVO>();
		
		File folder = new File(path);
		if(!folder.exists() || !folder.isDirectory()){
			//logger.info("##################### NOT EXIST!!!!!");
			return list;
		}
		File[] fileList = folder.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		for(int i=0; i<fileList.length; i++){
			File file = fileList[i];
			if(file.isFile()){
				String fileName = file.getName();
				String ext = fileName.substring(fileName.lastIndexOf(".") +  1);
				if(!ext.isEmpty() && (ext.equals("pem") || ext.equals("der"))){

					SipConfigCertificationVO vo = new SipConfigCertificationVO();
					vo.setTlsMode((short)tlsMode);
					vo.setCertType((short)certType);
					vo.setFileName(fileName);
					vo.setFileSize(file.length());
					vo.setFileDate(sdf.format(file.lastModified()));
					list.add(vo);
				}
			}
		}
		
		return list;
	}
	
	public int removeCertificationFiles(String deleteList) {
		
		int deletedCnt = 0;
		
		String[] deleteArray = deleteList.split("@");
		if(deleteArray.length == 0){
			return 0;
		}
		
		for(int i=0; i<deleteArray.length; i++){
			String[] item = deleteArray[i].split(",");
			if(item.length == 3){
				String path = getPath(Integer.parseInt(item[0]), Integer.parseInt(item[1])); // tlsMode, certType
				if(path != null && deleteFile(path, item[2])){ // fileName
					deletedCnt++;
				}
			}
		}
		
		return deletedCnt;
	}
	
	private boolean deleteFile(String path, String fileName){
		File file = new File(path + fileName);
		if(file.delete()){
			return true;
		}
		return false;
	}
	
	private String getPath(int tlsMode, int certType){
		if(tlsMode == 0){
			return (certType== 0) ? RsaPemPath : RsaDerPath;
		}else if(tlsMode == 1){
			return (certType== 0) ? EccPemPath : EccDerPath;
		}
		return null;
	}
	
	
	/*
	 * createSipConfigCertification
	 */
	public byte[] createSipConfigCertification(SipConfigCertificationVO vo)  throws Exception {
		byte[] body = null;
		try{ 
			List<Object> list = new ArrayList<Object>();
			list.add(vo.getTlsVersion());
			list.add(vo.getTlsMode());
			list.add(vo.getCertType());
			list.add(vo.getDerPassword());
			list.add(vo.getVerify());
			
			body = Bytes.arrayCopy(list);
		}catch(Exception e){
			e.getStackTrace();
		}
		return body;
	}
	
	
	public int saveFiles(MultipartHttpServletRequest mptRequest, TlsCertFileInfoVO vo){
		 
		 int tot = 0;
		 
		 try { 
			 tot += saveFile(mptRequest.getFiles("rootCA"), vo);
			 tot += saveFile(mptRequest.getFiles("chainCA"), vo);
			 tot += saveFile(mptRequest.getFiles("localCA"), vo);
			 tot += saveFile(mptRequest.getFiles("localKey"), vo);
		 } catch (IOException e) {
             return -1;
         } 
		 
		 return tot;
	}
	
	private int saveFile(List<MultipartFile> mpf, TlsCertFileInfoVO vo) throws IllegalStateException, IOException{
		int cnt = 0;
		for(int i=0; i<mpf.size(); i++){
			String originalfileName = mpf.get(i).getOriginalFilename(); 
			mpf.get(i).transferTo(new File(getPath(vo.getFileType(), vo.getCertMode()) + originalfileName));
			cnt++;
		}
		return cnt;
	}
	
	
	
	
}
