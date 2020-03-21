package com.sjh.web.member.service;

import com.sjh.web.member.dto.MemberDto;

public interface IMemberService {

	MemberDto checkLogin(MemberDto m);

	void removeMember(MemberDto m);

	void addMember(MemberDto m);

}