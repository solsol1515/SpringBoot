package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	// 새 글 등록
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	// 글 수정하기
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	// 글 삭제하기
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	// 글 목록 보기
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 개수 : " + list.size());
		return list;
	} // end of getBoardList

	@Override
	public void saveBoard(BoardVO vo) {
		boardDAO.saveBoard(vo);
	}
	
} // end of class
