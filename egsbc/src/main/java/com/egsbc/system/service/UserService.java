package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egsbc.security.service.CustomUserDetailsService;
import com.egsbc.system.UserAclVO;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserCommandLevelVO;
import com.egsbc.system.UserConfigVO;
import com.egsbc.system.UserEmailVO;
import com.egsbc.system.UserVO;


@Service("userService")
public class UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="customUserDetailsService")
	private CustomUserDetailsService customUserDetailsService;
	
	
	public List<UserVO> getUserList() throws Exception {
		return userDao.getUserList();
	}
	
	public UserVO getUser(String id) throws Exception {
		return userDao.getUser(id);
    }
	
	public UserVO getUser(UserVO vo) throws Exception {
		return userDao.getUser(vo);
    }
	
	public int addUser(UserVO vo) throws Exception {
		return userDao.addUser(vo);
    }
	
	public int changeUserPw(UserVO vo) throws Exception {
		return userDao.changeUserPw(vo);
	}
	
	public int setUserStatus(UserVO vo) throws Exception {
		if(vo.getId() == null || vo.getId().equals("")){
			return 0;
		}
		return userDao.setUserStatus(vo);
	}
	
	public int removeUser(UserVO vo) throws Exception {
		return userDao.removeUser(vo);
	}
	
	public int setPassword(UserVO vo) throws Exception {
		return userDao.setPassword(vo);
	}
	
	public int addManager(UserVO vo) throws Exception {
		return userDao.addManager(vo);
	}
	
	public int checkDupId(UserVO vo) throws Exception {
		return userDao.checkDupId(vo);
	}
	
	public List<UserConfigVO> getManagerConfigure() throws Exception {
		return userDao.getManagerConfigure();
	}
	
	public int addManagerConfigure(UserConfigVO vo) throws Exception {
		return userDao.addManagerConfigure(vo);
	}
	
	public int setManagerConfigure(UserConfigVO vo) throws Exception {
		return userDao.setManagerConfigure(vo);
	}
	
	public List<UserAclVO> getManagerUserAcl() throws Exception {
		return userDao.getManagerUserAcl();
	}
	
	public int addManagerIpAcl(UserAclVO vo) throws Exception {
		return userDao.addManagerIpAcl(vo);
	}
	
	public int removeManagerAcl(UserAclVO vo) throws Exception {
		return userDao.removeManagerAcl(vo);
	}
	public int changeManagerAcl(UserAclVO vo) throws Exception {
		return userDao.changeManagerAcl(vo);
	}
	
	public String getManagerUserAclEnable(String aclEnable)  throws Exception {
		return userDao.getManagerUserAclEnable(aclEnable);
	}
	public List<UserCommandLevelVO> getUserCommandLevel()  throws Exception {
		return userDao.getUserCommandLevel();
	}
	
	public List<UserActionHistoryVO> getUserActionHistory(UserActionHistoryVO vo) throws Exception {
		return userDao.getUserActionHistory(vo);
	}
	
	public int getUserActionHistoryCnt(UserActionHistoryVO vo) throws Exception {
		return userDao.getUserActionHistoryCnt(vo);
	}
	
	public int addUserActionHistory(UserActionHistoryVO vo) throws Exception {
		if(vo.getId() == null || vo.getId().equals("")){
			return 0;
		}
		return userDao.addUserActionHistory(vo);
	}
	
	public int isBlockedLimitTimeOver(UserVO vo)  throws Exception {
		return userDao.isBlockedLimitTimeOver(vo);
	}
	
	public int setUserStatusStayLoggedIn(UserVO vo)  throws Exception {
		return userDao.setUserStatusStayLoggedIn(vo);
	}
	
	public boolean isFirstTime() throws Exception {
		 String digestPw = customUserDetailsService.digest("admin", "admin");
		 UserVO userVO = userDao.getUser("admin");
		 if(userVO == null || userVO.getPw().equals(digestPw)){ // first time
			 return true;
		 }
		 return false;
	}
	
	public List<UserEmailVO> getUserEmail() throws Exception {
		return userDao.getUserEmail();
	}
	public int addUserEmail(UserEmailVO vo) throws Exception {
		return userDao.addUserEmail(vo);
	}
	
	public int removeUserEmail(UserEmailVO vo) throws Exception {
		return userDao.removeUserEmail(vo);
	}
}
