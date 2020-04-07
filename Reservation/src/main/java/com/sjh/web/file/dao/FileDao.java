package com.sjh.web.file.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sjh.web.file.dto.FileDto;

@Repository
public class FileDao implements IFileDao {
	private static final String NAMESPACE = "com.sjh.web.mappers.file.FileMapper";

	private final SqlSession sqlSession;
	
	@Inject
	public FileDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public FileDto selectFile(final int id){
		return sqlSession.selectOne(NAMESPACE + ".select", id);
	}
}
