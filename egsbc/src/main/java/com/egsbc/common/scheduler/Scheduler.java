package com.egsbc.common.scheduler;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.egsbc.alarm.AlarmDataVO;
import com.egsbc.alarm.AlarmTriggerVO;
import com.egsbc.alarm.service.AlarmService;
import com.egsbc.system.UserEmailServerVO;
import com.egsbc.system.UserEmailVO;
import com.egsbc.system.service.CoreSetService;
import com.egsbc.system.service.UserService;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



@Component
public class Scheduler {
	
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="alarmService")
	private AlarmService alarmService;
	
	@Resource(name="coreSetService")
	private CoreSetService coreSetService;
	
	
	
	@Scheduled(fixedDelay=5000)
	public void cron1() throws Exception{
		
		UserEmailServerVO userEmailServerVO = coreSetService.getUserEmailServer();
		AlarmTriggerVO alarmTriggerVO = alarmService.getAlarmTrigger();
		
		
		/*
		 *  userEmailServerVO.getSendMailFlag() == 1 && alarmTriggerVO.getEtc()== 1 이면
		 */
		if( userEmailServerVO != null && 
			userEmailServerVO.getSendMailFlag() == 1 && 
			alarmTriggerVO != null && 
			alarmTriggerVO.getEtc()== 1){
			
			// get user mail list
			List<UserEmailVO> userEmailList = userService.getUserEmail();
			
			if(userEmailServerVO != null && userEmailList.size() > 0){
				
				// get alarm data
				List<AlarmDataVO> alarmDataList = alarmService.getAlarmDataForEmail();
				
				for(AlarmDataVO alarmDataVO : alarmDataList){
					
					for(UserEmailVO userEmailVO : userEmailList){
						
						String createDatetime = alarmDataVO.getCreateDatetime().substring(0, alarmDataVO.getCreateDatetime().lastIndexOf("."));
						
						// subject
						String subject = "[SABER-V] alarm occurred (" + createDatetime + ")"; 
						
						// text
						String text = "";
						text += "Date of created : " + createDatetime + "\r\n";
						text += "Alarm level : " + getAlarmLevel(alarmDataVO.getAlarmLevel()) + "\r\n";
						text += "Alarm code : " + alarmDataVO.getAlarmCode() + "\r\n";
						text += "Alarm description : " + alarmDataVO.getCauseDescription() + "\r\n";
						text += "Alarm parameter : " + alarmDataVO.getAlarmCauseParam() + "\r\n";
						
						// from user
						String fromUser = "saber_admin";
						
						// to user
						String toUser = userEmailVO.getEmailAddress();
						
						
						// send mail
						//sendMail("smtp.gmail.com", 587, "ahnks1349@gmail.com", "ccas1999", subject, text, fromUser, toUser);
						sendMail(userEmailServerVO, subject, text, fromUser, toUser);
					}
					
					// 보낸표시,  if send OK, set ETC = '1'
					alarmService.setAlarmDataEtcClear(alarmDataVO.getIdx());
				}
				
				//---------------- trigger T_ETC set 0  -------------------------------------- 
				alarmService.setAlarmTriggerEtcZero();
			}
		}
		
	}
	

	private void sendMail(UserEmailServerVO userEmailServerVO, String subject, String text, String fromUser, String toUser) {
		 
		String host = userEmailServerVO.getServerDomain();
		
		try {
			  
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(host);
			sender.setPort(userEmailServerVO.getPort());
			sender.setUsername(userEmailServerVO.getEmailAddress());
			sender.setPassword(userEmailServerVO.getPassword());
			
			Properties prop = new Properties();
			prop.setProperty("mail.smtp.auth", "true");
			if(userEmailServerVO.getUseSsl()==0){
				prop.setProperty("mail.smtp.starttls.enable", "true");
				prop.setProperty("mail.smtp.ssl.trust", host);
			}else{
				prop.setProperty("mail.smtp.ssl.enable", "true");
				prop.setProperty("mail.smtp.ssl.trust", host);
			}
			sender.setJavaMailProperties(prop);
			
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setSubject(subject);
			helper.setFrom(fromUser);
			helper.setTo(toUser);
			helper.setText(text);
			
			sender.send(message);
		 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	private String getAlarmLevel(short level){
		if(level == 1) return "Information";
		else if(level == 2) return "Minor Alarm";
		else if(level == 3) return "Major Alarm";
		else if(level == 4) return "Critical Alarm";
		else return "";
	}
	
	
}
