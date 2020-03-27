package com.sjh.web.comment.service;

import java.util.List;

import com.sjh.web.comment.dto.CommentDto;

public interface ICommentService {

	void insertComment(CommentDto comment);

	CommentDto selectComment(int id);

	void deleteComment(int id);

	List<CommentDto> listUpComment(CommentDto comment);

}