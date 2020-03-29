package com.sjh.web.comment.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.comment.dao.ICommentDao;
import com.sjh.web.comment.dto.CommentDto;

@Service
public class CommentService implements ICommentService {

	@Inject
	ICommentDao dao;
	
	@Override
	public CommentDto insertComment(CommentDto comment) {
		return dao.insertComment(comment);
	}
	
	@Override
	public CommentDto selectComment(final int id) {
		return dao.selectComment(id);
	}
	
	@Override
	public void deleteComment(final int id) {
		dao.deleteComment(id);
	}
	
	@Override
	public List<CommentDto> listUpComment(CommentDto comment){
		return dao.listUpComment(comment);
	}
}
