package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;
import com.example.service.BoardService;
import com.example.util.MD5Generator;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// DB를 타지 않는 페이지들 Mapping (DB와 연동되지 않는 페이지)
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "board/"+step;
	} // end of viewPage()
	
	
	// 게시판 목록 보기
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO(); // 지금은 이 객체 역할없음
		List<BoardVO> list = boardService.getBoardList(vo);
		System.out.println("[Controller : getBoardList 요청] 리스트 결과 개수 : "+list.size());
		
		m.addAttribute("boardList", list);
	} // end of getBoardList()
	 
	
	// 게시판 상세 보기
	@RequestMapping("/getBoard")
	public void getBoard(BoardVO vo, Model m) {
		HashMap result = boardService.getBoard(vo);
		m.addAttribute("board", result);
		System.out.println("[Controller : getBoard 요청] 상세보기 : " + result);
	} // end of getBoard()
	
	
	// 게시판 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		System.out.println("[Controller : deleteBoard 요청]");
		return "redirect:getBoardList";
	} // end of deleteBoard()
	
	
	// 게시판 수정
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		System.out.println("[Controller : updateBoard 요청] 글 수정 ");
		return "redirect:getBoard?seq="+vo.getSeq();
	} // end of updateBoard()
	
	
	// 게시판 등록
	   @RequestMapping("/saveBoard")
	   public String saveBoard(@RequestParam("file") MultipartFile files,BoardVO vo) throws IOException {
	         try {
	            System.out.println("saveBoard 요청");
	            String origFilename = files.getOriginalFilename();
	            System.out.println("origFilename : " + origFilename);

	            // 파일첨부를한경우에만
	            if( origFilename != null&& !origFilename.equals(""))
	            {      

	               String filename = new MD5Generator(origFilename).toString();
	               /* 실행되는위치의 'files' 폴더에파일이저장됩니다. */
	               String savePath = System.getProperty("user.dir") + "\\files";
	               /* 파일이저장되는폴더가없으면폴더를생성합니다. */
	               if (!new File(savePath).exists()) {
	                  try{
	                     new File(savePath).mkdir();
	                  }
	                  catch(Exception e){
	                     e.getStackTrace();
	                  }
	               }
	               String filepath = savePath + "\\" + filename;
	               System.out.println("filepath : "+filepath);

	               files.transferTo(new File(filepath));

	               FileVO fileVO = new FileVO();
	               fileVO.setOrigFilename(origFilename);
	               fileVO.setFilename(filename);
	               fileVO.setFilePath(filepath);

	               boardService.saveBoard(vo, fileVO);
	               System.out.println("파일첨부인경우");
	            }else {
	               boardService.saveBoard(vo, null);
	               System.out.println("파일첨부가아닌경우");
	            }
	         } catch(Exception e) {
	            System.out.println("파일업로드실패:" + e.getMessage());
	            e.printStackTrace();
	         }
	         return"redirect:/board/getBoardList";
	      }


	
} // end of class
