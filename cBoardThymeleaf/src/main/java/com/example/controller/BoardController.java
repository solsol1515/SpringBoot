package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// DB를 타지 않는 페이지들 Mapping (DB와 연동되지 않는 페이지)
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "board/"+step;
	}
	
	// 게시판 목록 보기
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO(); // 지금은 이 객체 역할없음
		List<BoardVO> list = boardService.getBoardList(vo);
		System.out.println("[Controller : getBoardList 요청] 리스트 결과 개수 : "+list.size());
		
		m.addAttribute("boardList", list);
	}
	
	// 게시판 상세 보기
	@RequestMapping("/getBoard")
	public void getBoard(BoardVO vo, Model m) {
		BoardVO result = boardService.getBoard(vo);
		System.out.println("[Controller : getBoard 요청] 상세보기 : "+result.getSeq());
		
		m.addAttribute("board", result);
	}
	
	// 게시판 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		System.out.println("[Controller : deleteBoard 요청]");
		return "redirect:getBoardList";
	}
	
	// 게시판 등록
	@RequestMapping("/saveBoard")
	public String saveBoard(BoardVO vo) {
		boardService.saveBoard(vo);
		System.out.println("[Controller : insertBoard 요청] 새글등록 : "+vo.getTitle());
		return "redirect:getBoardList";
	}
	
	// 게시판 수정
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		System.out.println("[Controller : updateBoard 요청] 글 수정 ");
		return "redirect:getBoard?seq="+vo.getSeq();
	}
	
}
