package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	// 글 목록 가져오기
	@Override
	public List<BoardVO> getBoardList(BoardVO vo){
		return (List<BoardVO>)boardRepo.findAll(); // repository 찾기 findAll()
	} // end of getBoardList()

	
	// 게시글 등록하기
	public void saveBoard(BoardVO vo) {
		boardRepo.save(vo);
	} // end of saveBoard()


	// 글 상세내용 가져오기
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardRepo.findById(vo.getSeq()).get(); // 시퀀스 번호로 id값 찾아서 요소 가져오기?
	} // end of getBoard()


	// 삭제하기
	public void deleteBoard(BoardVO vo) {
		boardRepo.deleteById(vo.getSeq());
	} // end of deleteBoard()

	
	// 수정하기
	public void updateBoard(BoardVO vo) {
		BoardVO result = boardRepo.findById(vo.getSeq()).get(); // 등록되어 있는 값 가지고 오기
		result.setTitle(vo.getTitle());							// 수정할 데이터로 변경해주기
		result.setContent(vo.getContent());						
		
		boardRepo.save(result);									// 변경한 값 저장하기?
	} // end of updateBoard()
	
	
}
