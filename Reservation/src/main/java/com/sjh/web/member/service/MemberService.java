package com.sjh.web.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.member.dao.IMemberDao;
import com.sjh.web.member.dto.MemberDto;

@Service
public class MemberService implements IMemberService {
	
	@Inject
	IMemberDao dao;
	
	@Override
	public MemberDto checkLogin(MemberDto m) {
		return dao.checkMember(m);
	}
	
	@Override
	public void removeMember(MemberDto m) {
		dao.deleteMember(m);
	}
	
	@Override
	public void addMember(MemberDto m) {
		dao.insertMember(m);
	}
}
