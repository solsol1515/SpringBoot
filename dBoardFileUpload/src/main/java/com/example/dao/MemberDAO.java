package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.MemberVO;

@Mapper
public interface MemberDAO {
	
	public void insertMember(MemberVO vo);
	public MemberVO loginSuccess(MemberVO vo);
	
}
