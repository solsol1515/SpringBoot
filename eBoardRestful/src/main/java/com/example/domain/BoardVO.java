package com.example.domain;

import lombok.Data;

@Data
public class BoardVO {
	
	private int 	seq;		
	private String 	writer;
	private String 	title;
	private String 	content;	// 내용
	private String 	regdate;	// 등록 일자
	private int 	cnt;		// 조회수
	private long 	fileId;		// 파일 아이디 
	
}
