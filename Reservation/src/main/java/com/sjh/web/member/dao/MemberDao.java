package com.sjh.web.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sjh.web.member.dto.MemberDto;

@Repository
public class MemberDao implements IMemberDao {
	private static final String NAMESPACE = "com.sjh.web.mappers.member.MemberMapper";

	private final SqlSession sqlSession;
	
	@Inject
	public MemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public MemberDto checkMember(final MemberDto m) {
		return sqlSession.selectOne(NAMESPACE + ".check", m);
	}
	
	@Override
	public void insertMember(final MemberDto m) {
		sqlSession.insert(NAMESPACE + ".insert", m);
	}
	
	@Override
	public void deleteMember(final MemberDto m) {
		sqlSession.delete(NAMESPACE + ".delete", m);
	}
}
