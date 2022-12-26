package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.persistence.SampleQueryRepository;

@Controller
public class SampleQueryController {
	
	@Autowired
	private SampleQueryRepository repo;
	
	@RequestMapping("/sampleQuery")
	public String sampleQuery(Model m) {
		Pageable paging = PageRequest.of(1, 2);	// 1페이지에 있는 글 2개 보여주세요. (0페이지부터 시작)
		List<BoardVO> result = repo.findAll(paging);
		m.addAttribute("boardList", result);
		
		return "board/getBoardList";
	} // end of sampleQuery()
	
} // end of class
