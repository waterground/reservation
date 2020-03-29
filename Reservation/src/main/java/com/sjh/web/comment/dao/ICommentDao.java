package com.sjh.web.comment.dao;

import java.util.List;

import com.sjh.web.comment.dto.CommentDto;

public interface ICommentDao {

	CommentDto insertComment(CommentDto comment);

	CommentDto selectComment(int id);

	void deleteComment(CommentDto comment);

	List<CommentDto> listUpComment(CommentDto comment);
	
	void updateComment(CommentDto comment);
	
	float getRatingAvg(int productId);

}