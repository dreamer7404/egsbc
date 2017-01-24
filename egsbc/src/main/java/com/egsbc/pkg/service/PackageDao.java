package com.egsbc.pkg.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.egsbc.pkg.PackageBlockVO;
import com.egsbc.pkg.PackageVO;

@Repository("packageDao")
public class PackageDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<PackageVO> getPackage(int side) throws Exception {
		return sqlSession.selectList("PackageDao.getPackage", side);
    }
	
	public List<PackageBlockVO> getPackageBlock(PackageBlockVO vo) throws Exception {
		return sqlSession.selectList("PackageDao.getPackageBlock", vo);
    }

}
