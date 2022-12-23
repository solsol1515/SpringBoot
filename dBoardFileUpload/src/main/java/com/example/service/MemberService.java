package com.example.service;

import com.example.domain.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO vo);
	public MemberVO loginSuccess(MemberVO vo);
}
