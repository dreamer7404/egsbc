package com.egsbc.system.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.egsbc.common.service.CommonService;
import com.egsbc.report.DbBackupHistoryVO;
import com.egsbc.report.service.DbBackupHistoryService;
import com.egsbc.system.DbBackupRestoreVO;
import com.egsbc.system.service.DbBackupRestoreService;
import com.egsbc.utils.Global;
import com.egsbc.utils.service.ByteService;
import com.egsbc.utils.service.DownloadView;
import com.egsbc.utils.service.IPCService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class DbBackupRestoreController {

	
	@Resource(name="ipcService")
	 private IPCService ipcService;
	
	@Resource(name="byteService")
	 private ByteService byteService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="downloadView")
	private DownloadView downloadView;
	
	@Resource(name="dbBackupRestoreService")
	private DbBackupRestoreService dbBackupRestoreService;
	
	@Resource(name="dbBackupHistoryService")
	private DbBackupHistoryService dbBackupHistoryService;
	
	
	
	@Value("${DbBackupUploadPath}") 
	private String dbBackupUploadPath;
	
	@Value("${DbDataPath}") 
	private String dbDataPath;
	
	
	
	 /*
	 * uploadDbRestore
	 */
	 @RequestMapping(value = "/uploadDbRestore", method = {RequestMethod.POST})
	 public ModelAndView uploadDbRestore(MultipartHttpServletRequest mptRequest) throws Exception {
		 
//		 ModelAndView mav = new ModelAndView();
		 
		 int result = 0;
		 
		 String dbName = mptRequest.getParameter("dbName");
		 
		 Iterator<?> fileIter = mptRequest.getFileNames();
		 if (fileIter.hasNext()) {
		 	MultipartFile mFile = mptRequest.getFile((String)fileIter.next());
		 	
		 	if(mFile.getSize() > 0){
//				 	long size = mFile.getSize();
			 	
			 	String fileName = mFile.getOriginalFilename();
//			 	String saveName = System.currentTimeMillis() + "-" + fileName;
			 	
			 	String path = "";
			 	if(System.getProperty("os.name").contains("Windows")){
			 		dbBackupUploadPath = "D:\\temp\\";
			 	}
			 	
			 	path = dbBackupUploadPath + fileName;
			 	
			 	File file = new File(path);
			 	
			 	// save
			 	mFile.transferTo(file);
			 	
			 	
			
			 	
			 	
//			 	Thread.sleep(500);
//			 	
//			 	if(file.exists()){// OK,  redirect
//			 		mav.setViewName("redirect:/takeDbRestore?opMode=6&dbName="+dbName+"&fileName="+saveName);
//			 	}else{ // fail to save file
//			 		mav.setViewName("jsonView");
//			 		mav.addObject("result", commonService.setErrorList(Global.ERR_FILE_SAVE_FAILURE, "Fail, Save upload-file!"));
//			 	}
		 	}else{ // file size = 0
//		 		mav.setViewName("jsonView");
//		 		mav.addObject("result", commonService.setErrorList(Global.ERR_FILE_SIZE_ZERO, "Fail, Upload-file size is zero!"));
		 		
		 		result = -1;
		 	}
		  
		 }else{ // no attached upload file
//			mav.setViewName("jsonView");
//		 	mav.addObject("result", commonService.setErrorList(Global.ERR_FILE_NO_ATTACH, "Fail, No upload-file!"));
			 
			 result = -2;
		 }
		 
		 return new ModelAndView("jsonView", "result", result);
	 }
	 
	 /*
	  * take Restore
	  */
	 @RequestMapping(value = "/takeDbRestore", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView takeDbRestore(@ModelAttribute DbBackupRestoreVO vo, BindingResult bindingResult) throws Exception {
		 byte[] body = dbBackupRestoreService.createDbRestore(vo);
		 byte[] responseData =ipcService.request(Global.IPC_DATABASE, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
	 }
	 
	 
	 /*
	 * downloadDbBackup
	 */
	 @RequestMapping(value = "/downloadDbBackup", method = {RequestMethod.POST})
	 public ModelAndView downloadDbBackup(@ModelAttribute DbBackupRestoreVO vo,  BindingResult bindingResult) throws Exception {
		 
		 byte[] body = dbBackupRestoreService.createDbBackup(vo);
		 byte[] responseData =ipcService.request(Global.IPC_DATABASE, vo.getOpMode(), body);
		 List<String> resultList = byteService.getResultList(responseData, body.length);
		 return new ModelAndView("jsonView", "result", resultList);
		 
		
	 }
	 
	 
	 
	 
	 /*
	  * dbBackup
	  */
	 @RequestMapping(value = "/dbBackup", method = {RequestMethod.POST})
	 public ModelAndView dbBackup(String dbName) throws Exception {
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		 String datetime = formatter.format (new Date());
		 
		 String backupFileName = dbBackupUploadPath + dbName + "-" + datetime + ".tar.gz";
		 String cmd = "cd " + dbDataPath + "; tar -cvzf " + backupFileName + " " + dbName;
		 
		 
		 ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c",  cmd);
		 processBuilder.redirectErrorStream(true);
		 Process process = processBuilder.start();
		 
		 process.waitFor();
		 
		 
	 	// insert R_DB_BACKUP_HISTORY 
		 dbBackupHistoryService.addDbBackupHistory(new DbBackupHistoryVO(dbName, backupFileName));
		 
		 return new ModelAndView("jsonView", "result", 1);
	 }
	 
	 
	 
	 
	 
	 /*
	  * getPeriodicDbBackupList
	  */
	 
	 @RequestMapping(value = "/getPeriodicDbBackupList", method = {RequestMethod.POST})
	 public ModelAndView getPeriodicDbBackupList() throws Exception {

		 if(System.getProperty("os.name").contains("Windows")){
			 dbBackupUploadPath = "D:\\temp\\";
		 }
		 
		 JSONArray array = new JSONArray();
		 JSONObject obj =  null; 
			
		 
		 File folder = new File(dbBackupUploadPath);

		 File[] listOfFiles = folder.listFiles();
		 for (int i = 0; i < listOfFiles.length; i++) {
			 File file = listOfFiles[i];
			 if (file.isFile()) {
				 
				 String fileName = file.getName();
				 String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				 
				 if(ext.equals("gz")){
					 
					 long size = file.length();
					 
					 BasicFileAttributes  attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
					 String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(attr.creationTime().toMillis());
					 
					 obj = new JSONObject(); 
					 obj.put("date", date);
					 obj.put("fileName", fileName);
					 obj.put("size", size);
					 
					 array.add(obj);
				 }
		     } 
	    }
		 
		 ModelAndView mav = new ModelAndView("jsonView");
		 mav.addObject("draw", 1);
		 mav.addObject("recordsTotal", array.size());
		 mav.addObject("recordsFiltered", array.size());
		 mav.addObject("data", array);
		 return mav;
	 }
	 
	//
	 
	 
	 /*
	  * removeDbBackupList
	  */
	 
	 @RequestMapping(value = "/removeDbBackupList", method = {RequestMethod.POST})
	 public ModelAndView removeDbBackupList(HttpServletRequest request) throws Exception {

		 if(System.getProperty("os.name").contains("Windows")){
			 dbBackupUploadPath = "D:\\temp\\";
		 }
		 
		 String fileName = request.getParameter("fileName").toString();
		 int result = 0;
		 
		 File folder = new File(dbBackupUploadPath);

		 File[] listOfFiles = folder.listFiles();
		 for (int i = 0; i < listOfFiles.length; i++) {
			 File file = listOfFiles[i];
			 if (file.isFile()) {
				 if(file.getName().equals(fileName)){
						 file.delete();
						 result = 1;
				 }
			 }
		 }
		 
		 return new ModelAndView("jsonView", "result", result);
	 }
		 
	
	 /*
	  * downloadDbBackupByList
	  */
	 @RequestMapping(value = "/downloadDbBackupByList", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView downloadDbBackupByList(HttpServletRequest request) throws Exception {
		 
		 if(System.getProperty("os.name").contains("Windows")){
			 dbBackupUploadPath = "D:\\temp";
		 }
		 
		 String fileName = request.getParameter("fileName").toString();
		 
		 File file = new File(dbBackupUploadPath + File.separator +  fileName );
		 
		 return new ModelAndView("downloadView", "downloadFile", file);
	 }
	 
	 /*
	  * extractDbBackupList
	  */
	 @RequestMapping(value = "/extractDbBackupList", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView extractDbBackupList(HttpServletRequest request) throws Exception {
		 if(System.getProperty("os.name").contains("Windows")){
			 dbBackupUploadPath = "D:\\temp\\";
		 }
		 
		 String fileName = request.getParameter("fileName").toString();
		 
		 // tar
		 
		 String cmd = "cd " + dbDataPath + " ; tar -xvzmf " + dbBackupUploadPath + fileName;
		 
		 ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c",  cmd);
		 processBuilder.redirectErrorStream(true);
		 Process process = processBuilder.start();
		 
		 process.waitFor();
		 
		 // restart
		 
		 String cmd2 = "service mariadb restart";
		 
		 ProcessBuilder processBuilder2 = new ProcessBuilder("/bin/bash", "-c",  cmd2);
		 processBuilder2.redirectErrorStream(true);
		 Process process2 = processBuilder2.start();
		 
		 process2.waitFor();
		 
		 
		 return new ModelAndView("jsonView", "result", 1);
	 }
	 
	 
	 
}
