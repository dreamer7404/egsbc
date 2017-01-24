package com.egsbc.overview.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.overview.CurrentNatEntryVO;

@Repository("overviewDao")
public class OverviewDao {

	@Resource(name="sqlSession2")
	private SqlSession sqlSession2;
	
	public List<CurrentNatEntryVO> getCurrentNatEntry() throws Exception {
		return sqlSession2.selectList("OverviewDao.getCurrentNatEntry");
    }
}
