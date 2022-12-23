package com.example.service;

import java.util.HashMap;
import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;

public interface BoardService {
	
	public List<BoardVO> getBoardList(BoardVO vo);
	public HashMap getBoard(BoardVO vo);
	public void saveBoard(BoardVO bvo, FileVO fvo);
	
	public void deleteBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	
}
