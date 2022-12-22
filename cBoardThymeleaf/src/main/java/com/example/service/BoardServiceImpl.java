package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 개수 : "+ list.size());
		return list;
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		BoardVO result = boardDAO.getBoard(vo);
		System.out.println("[BoardService] 상세보기 : "+result.getSeq());
		return result;
	}

	@Override
	public void saveBoard(BoardVO vo) {
		boardDAO.saveBoard(vo);
		System.out.println("[BoardService] 새 글 등록");

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		System.out.println("[BoardService] 글 삭제");
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		System.out.println("[BoardService] 글 수정");
	}

}
