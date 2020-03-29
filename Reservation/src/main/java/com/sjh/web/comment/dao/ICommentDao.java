package com.sjh.web.comment.dao;

import java.util.List;

import com.sjh.web.comment.dto.CommentDto;

public interface ICommentDao {

	CommentDto insertComment(CommentDto comment);

	CommentDto selectComment(int id);

	void deleteComment(int id);

	List<CommentDto> listUpComment(CommentDto comment);

}