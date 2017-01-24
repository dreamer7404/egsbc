package com.egsbc.security.service;

import java.security.MessageDigest;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.egsbc.security.CustomUserDetails;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.UserService;

@Service ("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Resource(name="userService")
	private UserService userService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		CustomUserDetails customUserDetails = null;
		try {
			UserVO userVO = userService.getUser(username);
			
			customUserDetails = new CustomUserDetails(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customUserDetails;
	}
	
	public String digest(String id, String pw) throws Exception{
		 
		MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
		
		 String input = pw + "#@3!3#" + id;
		 sh.update(input.getBytes()); 
		 byte byteData[] = sh.digest();
		 
		 StringBuffer sb = new StringBuffer(); 
		 for(int i = 0 ; i < byteData.length ; i++){
			 sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		 }
		 
		 return sb.toString();
	}

}
