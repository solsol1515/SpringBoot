package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public void saveBoard(BoardVO vo);
	
	public void deleteBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
}
