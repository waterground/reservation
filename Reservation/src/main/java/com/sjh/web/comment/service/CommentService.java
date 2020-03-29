package com.sjh.web.comment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		CommentDto c = dao.insertComment(comment);
		return c;
	}
	
	@Override
	public CommentDto selectComment(final int id) {
		return dao.selectComment(id);
	}
	
	@Override
	public void deleteComment(final CommentDto comment) {
		dao.deleteComment(comment);
	}
	
	@Override
	public Map<String, Object> listUpComment(CommentDto comment){
		
		List<CommentDto> list = dao.listUpComment(comment);
		float ratingAvg = dao.getRatingAvg(comment.getProductId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("ratingAvg", ratingAvg);
		
		return map;
	}
	
	@Override
	public void updateComment(CommentDto comment) {
		dao.updateComment(comment);
	}
}
