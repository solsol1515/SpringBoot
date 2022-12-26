package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList(BoardVO vo);		// 글 목록 가져오기
	void saveBoard(BoardVO vo);					// 등록하기

	BoardVO getBoard(BoardVO vo);				// 상세보기
	void deleteBoard(BoardVO vo);				// 삭제하기
	void updateBoard(BoardVO vo);				// 수정하기
	
}