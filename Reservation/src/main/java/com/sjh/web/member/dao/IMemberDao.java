package com.sjh.web.member.dao;

import com.sjh.web.member.dto.MemberDto;

public interface IMemberDao {

	MemberDto checkMember(MemberDto m);

	void insertMember(MemberDto m);

	void deleteMember(MemberDto m);

}