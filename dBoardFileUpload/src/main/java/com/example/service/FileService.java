package com.example.service;

import com.example.domain.FileVO;

public interface FileService {

	public void 	insertFile(FileVO vo);
	public FileVO 	selectFile(FileVO vo);
	public long 	selectId();
	
}
