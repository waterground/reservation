package com.sjh.web.comment.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjh.web.comment.dto.CommentDto;
import com.sjh.web.comment.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Inject
	ICommentService service;
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ResponseEntity<String> write(@RequestBody CommentDto comment, HttpSession session) {
		
		ResponseEntity<String> entity = null;

		try {
			service.insertComment(comment);
			entity = new ResponseEntity<String>("register Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<CommentDto> list(@RequestParam("productId") int productId) {
		
		CommentDto c = new CommentDto();
		c.setProductId(productId);
		return service.listUpComment(c);
	}
	/*
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseEntity<String> modify(@RequestBody CommentDto comment) {
		ResponseEntity<String> entity = null;
		
		try {
			service.commentUpdate(comment);
			entity = new ResponseEntity<String>("modify Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	*/
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ResponseEntity<String> remove(@RequestBody CommentDto comment) {
		ResponseEntity<String> entity = null;
		
		try {
			service.deleteComment(comment.getId());
			entity = new ResponseEntity<String>("remove Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
