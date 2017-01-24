package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.system.UserAclVO;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserCommandLevelVO;
import com.egsbc.system.UserConfigVO;
import com.egsbc.system.UserEmailVO;
import com.egsbc.system.UserVO;

@Repository("userDao")
public class UserDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public List<UserVO> getUserList() throws Exception {
		return sqlSession.selectList("UserDao.getUserList");
    }
	
	public UserVO getUser(String id) throws Exception {
		return sqlSession.selectOne("UserDao.getUser", id);
    }
	
	public UserVO getUser(UserVO vo) throws Exception {
		return sqlSession.selectOne("UserDao.getUser", vo);
    }
	
	public int addUser(UserVO vo) throws Exception {
		return sqlSession.insert("UserDao.addUser", vo);
    }
	
	public int changeUserPw(UserVO vo) throws Exception {
		return sqlSession.update("UserDao.changeUserPw", vo);
	}
	
	public int setUserStatus(UserVO vo) throws Exception {
		return sqlSession.update("UserDao.setUserStatus", vo);
    }
	
	public int removeUser(UserVO vo) throws Exception {
		return sqlSession.delete("UserDao.removeUser", vo);
    }
	
	public int setPassword(UserVO vo) throws Exception {
		return sqlSession.update("UserDao.setPassword", vo);
    }
	
	public int addManager(UserVO vo) throws Exception {
		return sqlSession.insert("UserDao.addManager", vo);
    }
	
	public int checkDupId(UserVO vo) throws Exception {
		return sqlSession.selectOne("UserDao.checkDupId", vo);
    }
	
	public List<UserConfigVO> getManagerConfigure() throws Exception {
		return sqlSession.selectList("UserDao.getManagerConfigure");
	}
	
	public int addManagerConfigure(UserConfigVO vo) throws Exception {
		return sqlSession.update("UserDao.addManagerConfigure", vo);
	}
	
	public int setManagerConfigure(UserConfigVO vo) throws Exception {
		return sqlSession.update("UserDao.setManagerConfigure", vo);
	}
	
	public List<UserAclVO> getManagerUserAcl() throws Exception {
		return sqlSession.selectList("UserDao.getManagerUserAcl");
	}
	
	public int addManagerIpAcl(UserAclVO vo) throws Exception {
		return sqlSession.insert("UserDao.addManagerIpAcl", vo);
	}
	
	public int removeManagerAcl(UserAclVO vo) throws Exception {
		return sqlSession.delete("UserDao.removeManagerAcl", vo);
	}
	
	public int changeManagerAcl(UserAclVO vo) throws Exception {
		return sqlSession.update("UserDao.changeManagerAcl", vo);
	}
	
	public String getManagerUserAclEnable(String aclEnable)  throws Exception {
		return sqlSession.selectOne("UserDao.getManagerUserAclEnable", aclEnable);
	}
	
	public List<UserCommandLevelVO> getUserCommandLevel() throws Exception {
		return sqlSession.selectList("UserDao.getUserCommandLevel");
	}
	
	public List<UserActionHistoryVO> getUserActionHistory(UserActionHistoryVO vo) throws Exception {
		return sqlSession.selectList("UserDao.getUserActionHistory", vo);
	}
	
	public int getUserActionHistoryCnt(UserActionHistoryVO vo) throws Exception {
		return sqlSession.selectOne("UserDao.getUserActionHistoryCnt", vo);
	}
	
	public int addUserActionHistory(UserActionHistoryVO vo) throws Exception {
		return sqlSession.insert("UserDao.addUserActionHistory", vo);
	}
	
	public int isBlockedLimitTimeOver(UserVO vo)  throws Exception {
		return sqlSession.selectOne("UserDao.isBlockedLimitTimeOver", vo);
	}
	
	public int setUserStatusStayLoggedIn(UserVO vo)  throws Exception {
		return sqlSession.update("UserDao.setUserStatusStayLoggedIn", vo);
	}
	
	
	public List<UserEmailVO> getUserEmail() throws Exception {
		return sqlSession.selectList("UserDao.getUserEmail");
	}
	public int addUserEmail(UserEmailVO vo) throws Exception {
		return sqlSession.insert("UserDao.addUserEmail", vo);
	}
	
	public int removeUserEmail(UserEmailVO vo) throws Exception {
		return sqlSession.delete("UserDao.removeUserEmail", vo);
	}
}
