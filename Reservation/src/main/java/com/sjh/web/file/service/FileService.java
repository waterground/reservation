package com.sjh.web.file.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.file.dao.IFileDao;
import com.sjh.web.file.dto.FileDto;

@Service
public class FileService implements IFileService {

	@Inject
	IFileDao dao;
	
	@Override
	public FileDto selectFile(int id) {
		return dao.selectFile(id);
	}
}
