package com.egsbc.system.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TcpDumpController {
	
	@Value("${TcpDumpPath}") 
	private String tcpDumpPath;
	
	@Value("${TcpDumpFileName}") 
	private String tcpDumpFileName;
	
	@Value("${TcpDumpZipName}") 
	private String tcpDumpZipName;

	/*
	  * downloadDump
	  */
	 @RequestMapping(value = "/downloadDump", method = {RequestMethod.POST, RequestMethod.GET})
	 public ModelAndView applySystem() throws Exception {
			 
		 //String cmd = "tar -cvzf "+ tcpDumpPath + tcpDumpZipName + "  " + tcpDumpFileName;
		 String cmd = "cd " + tcpDumpPath + ";tar -cvzf " + tcpDumpZipName + " ./" + tcpDumpFileName; 
		 
		 
		 ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c",  cmd);
		 processBuilder.redirectErrorStream(true);
		 Process process = processBuilder.start();
		 
		 process.waitFor();
		 
		 return new ModelAndView("downloadView", "downloadFile", new File(tcpDumpPath + tcpDumpZipName));
	 }
	 
	 
	 /*
	  * remove zip file ??? 시점을 모름...
	  */
	
}
