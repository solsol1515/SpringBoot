package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {
	
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 저장
	void saveBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);
	
	// 글 목록
	List<BoardVO> getBoardList(BoardVO vo);

}
