package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.QueryAnnoRepository;

@Controller
public class QueryAnnoController {
	
	@Autowired
	private QueryAnnoRepository repo;
	// [1] JPQL
	/*
	@RequestMapping("queryAnno")
	public String queryAnno(Model m) {
		m.addAttribute("boardList", repo.queryAnnotation("구"));
		return "/board/getBoardList";
	} // end of queryAnno()
	*/
	
	// [2] SQL
	@RequestMapping("queryAnno")
	public String queryAnno(Model m) {
		m.addAttribute("boardList", repo.queryAnnotation2("구"));
		return "/board/getBoardList";
	} // end of queryAnno()
	
	// [3] 숙제
	/*
	@RequestMapping("queryAnno")
	public String queryAnno(Model m) {
		m.addAttribute("boardList", repo.queryAnnotation3("구"));
		return "/board/getBoardList";
	} // end of queryAnno()
	*/
}// end of class
