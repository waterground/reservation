package com.sjh.web.comment.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sjh.web.comment.dto.CommentDto;

@Repository
public class CommentDao implements ICommentDao {
	private static final String NAMESPACE = "com.sjh.web.mappers.comment.CommentMapper";

	private final SqlSession sqlSession;
	
	@Inject
	public CommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public CommentDto insertComment(final CommentDto comment){
		sqlSession.insert(NAMESPACE + ".insert", comment);
		sqlSession.insert(NAMESPACE + ".insertRelation", comment);
		return sqlSession.selectOne(NAMESPACE +".select", 0);
	}
	
	@Override
	public CommentDto selectComment(final int id){
		
		return sqlSession.selectOne(NAMESPACE + ".select", id);
	}
	
	@Override
	public void deleteComment(final int id) {
		sqlSession.delete(NAMESPACE + ".deleteRelation", id);
		sqlSession.delete(NAMESPACE + ".delete", id);
	}
	
	@Override
	public List<CommentDto> listUpComment(CommentDto comment){
		return sqlSession.selectList(NAMESPACE + ".listUp", comment);
	}
}
