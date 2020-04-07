package com.sjh.web.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sjh.web.file.dto.FileDto;
import com.sjh.web.file.service.IFileService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Inject
	IFileService service;

	private String PATH = "c:/img/";

	public ResponseEntity<Resource> fileUpload(FileDto file, HttpServletResponse response) {
		PATH += "/review";
		String fileName = file.getName();
		File fileImage = new File(PATH + fileName);
		long fileLength = fileImage.length();
		String saveFileName = PATH + fileName;
		int contentTypeIdx = fileName.indexOf(".");
		String contentType = fileName.substring(0, contentTypeIdx);

		try (FileInputStream fis = new FileInputStream(saveFileName); OutputStream out = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = fis.read(buffer)) != -1) {
				out.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_LENGTH, String.valueOf(fileLength))
				.header(HttpHeaders.CONTENT_TYPE, contentType).body(new FileSystemResource(saveFileName));
	}

	@GetMapping("/download/{type}/{id}")
	public void fileDownload(@PathVariable("type") String type, @PathVariable("id") int id, HttpServletResponse response) throws IOException {
		String fileName;
		StringBuilder sb = new StringBuilder("file:///" + PATH + "/" + type + "/");
		
		if(type.equals("logo")) {
			fileName = "logo.png";
		}else {
			FileDto file = service.selectFile(id);
			fileName = file.getName();
		}
		sb.append(fileName);
		
		URL fileUrl = new URL(sb.toString());
		
		IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
	}

}
