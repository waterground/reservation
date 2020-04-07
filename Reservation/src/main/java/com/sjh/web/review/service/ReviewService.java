package com.sjh.web.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.review.dao.IReviewDao;
import com.sjh.web.review.dto.ReviewDto;

@Service
public class ReviewService implements IReviewService {

	@Inject
	IReviewDao dao;

	@Override
	public ReviewDto insertReview(ReviewDto review) {
		ReviewDto c = dao.insertReview(review);
		return c;
	}

	@Override
	public ReviewDto selectReview(final int id) {
		return dao.selectReview(id);
	}

	@Override
	public void deleteReview(final ReviewDto review) {
		dao.deleteReview(review);
	}

	@Override
	public Map<String, Object> listUpReview(ReviewDto review) {

		List<ReviewDto> list = dao.listUpReview(review);
		float ratingAvg = dao.getRatingAvg(review.getProductId());

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("ratingAvg", ratingAvg);

		return map;
	}

	@Override
	public void updateReview(ReviewDto review) {
		dao.updateReview(review);
	}
}
