package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FileDAO;
import com.example.domain.FileVO;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public void insertFile(FileVO vo) {
		fileDAO.insertFile(vo);
	} // end of insertFile()

	@Override
	public FileVO selectFile(FileVO vo) {
		
		return fileDAO.selectFile(vo);
	} // end of selectFile()

	@Override
	public long selectId() {
		
		return fileDAO.selectId();
	} // end of selectId()

} // end of class