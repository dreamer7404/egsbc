package com.egsbc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.configuration.PrimitiveConfigVO;
import com.egsbc.system.NtpConfigVO;
import com.egsbc.system.NtpServerVO;
import com.egsbc.system.UserEmailServerVO;

@Repository("coreSetDao")
public class CoreSetDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public List<PrimitiveConfigVO> getConfigNtp() throws Exception {
		return sqlSession.selectList("CoreSetDao.getConfigNtp");
    }
	
	public List<NtpServerVO> getNtpServer() throws Exception {
		return sqlSession.selectList("CoreSetDao.getNtpServer");
    }
	
	public int addNtpServer(String serverName) throws Exception {
		return sqlSession.insert("CoreSetDao.addNtpServer", serverName);
    }
	
	public int removeNtpServer(List<String> list) throws Exception {
		return sqlSession.insert("CoreSetDao.removeNtpServer", list);
    }
	
	public NtpConfigVO getNtpConfig()  throws Exception {
		return sqlSession.selectOne("CoreSetDao.getNtpConfig");
	}
	
	public UserEmailServerVO getUserEmailServer() throws Exception {
		return sqlSession.selectOne("CoreSetDao.getUserEmailServer");
    }
	
	public int addUserEmailServer (UserEmailServerVO vo) throws Exception {
		return sqlSession.insert("CoreSetDao.addUserEmailServer", vo);
	}
	
	public int setUserEmailServer (UserEmailServerVO vo) throws Exception {
		return sqlSession.update("CoreSetDao.setUserEmailServer", vo);
	}
	
}
