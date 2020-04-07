package com.sjh.web.review.service;

import java.util.Map;

import com.sjh.web.review.dto.ReviewDto;

public interface IReviewService {

	ReviewDto insertReview(ReviewDto review);

	ReviewDto selectReview(int id);

	void deleteReview(ReviewDto review);

	Map<String, Object> listUpReview(ReviewDto review);
	
	void updateReview(ReviewDto review);

}