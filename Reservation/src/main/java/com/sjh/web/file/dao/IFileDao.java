package com.sjh.web.file.dao;

import com.sjh.web.file.dto.FileDto;

public interface IFileDao {
	FileDto selectFile(final int id);
}