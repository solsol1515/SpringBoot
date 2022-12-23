package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardVO;

@Mapper
public interface BoardDAO {
	
	// mapper 의 id와 함수명이 동일해야함
	public List<BoardVO> getBoardList(BoardVO vo);
	public HashMap getBoard(BoardVO vo);
	public void saveBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void updateCnt(BoardVO vo);
	
}