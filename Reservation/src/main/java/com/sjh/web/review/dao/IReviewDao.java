package com.sjh.web.review.dao;

import java.util.List;

import com.sjh.web.review.dto.ReviewDto;

public interface IReviewDao {

	ReviewDto insertReview(ReviewDto review);

	ReviewDto selectReview(int id);

	void deleteReview(ReviewDto review);

	List<ReviewDto> listUpReview(ReviewDto review);
	
	void updateReview(ReviewDto review);
	
	float getRatingAvg(int productId);

}