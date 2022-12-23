package com.example.domain;

import lombok.Data;

// Board_file 테이블과 매핑하는 VO
@Data
public class FileVO {

	private Long 	fileId;			// 파일 아이디?
	private String 	origFilename;	// 원래 파일 이름?
	private String 	filename;		// 파일 이름
	private String 	filePath;		// 파일 경로
	
}
