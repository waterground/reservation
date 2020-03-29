package com.sjh.web.comment.service;

import java.util.Map;

import com.sjh.web.comment.dto.CommentDto;

public interface ICommentService {

	CommentDto insertComment(CommentDto comment);

	CommentDto selectComment(int id);

	void deleteComment(CommentDto comment);

	Map<String, Object> listUpComment(CommentDto comment);
	
	void updateComment(CommentDto comment);

}