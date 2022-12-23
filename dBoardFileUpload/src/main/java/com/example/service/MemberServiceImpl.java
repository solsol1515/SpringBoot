package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//회원가입
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
		System.out.println("[MemberService] : 회원가입");
	}
	
	//로그인 (아이디체크)
	@Override
	public MemberVO loginSuccess(MemberVO vo) {
		MemberVO result = memberDAO.loginSuccess(vo);
		System.out.println("[MemberService] : 로그인");		
		return result;
	}

}
