package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardVO;

@Mapper
public interface BoardDAO {

	public void insertBoard(BoardVO vo);			// 새 글 작성
	public void updateBoard(BoardVO vo);			// 글 수정
	public void deleteBoard(BoardVO vo);			// 글 삭제
	public void saveBoard(BoardVO vo);				 
	public BoardVO getBoard(BoardVO vo) ;			// 상세 글 내용 가져오기 
	public List<BoardVO> getBoardList(BoardVO vo);	// 글 목록
	
}
/*
 * 	기본적인 구조라면,
 *  인터페이스를 구현한 클래스 필요 BoardDAOImpl.java
 *  그 클래스에 @Repository 지정 필요
 */