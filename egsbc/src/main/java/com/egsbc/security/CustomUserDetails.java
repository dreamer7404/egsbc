package com.egsbc.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.egsbc.system.UserVO;


public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = -4450269958885980297L;
    private String username;	// id
    private String password;	// pwd
    private String auth;	
    private short status;
    private short loginFailCount; 
     
    public CustomUserDetails(String userName, String password)
    {
        this.username = userName;
        this.password = password;
    }
    
    public CustomUserDetails(UserVO vo){
    	this.username = vo.getId();
    	this.password = vo.getPw();
    	this.auth = String.valueOf(vo.getLevel());
    	this.status = vo.getStatus();
    	this.loginFailCount = vo.getLoginFailCount();
    }
     
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
         
        return authorities;
    }
  
    @Override
    public String getPassword() {
        return password;
    }
  
    @Override
    public String getUsername() {
        return username;
    }
  
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
  
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
  
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
  
    @Override
    public boolean isEnabled() {
        return true;
    }

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(short loginFailCount) {
		this.loginFailCount = loginFailCount;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
    
    
    

}
