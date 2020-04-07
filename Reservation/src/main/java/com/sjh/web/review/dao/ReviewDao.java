package com.sjh.web.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sjh.web.file.dto.FileDto;
import com.sjh.web.review.dto.ReviewDto;

@Repository
public class ReviewDao implements IReviewDao {
	private static final String NAMESPACE = "com.sjh.web.mappers.review.ReviewMapper";

	private final SqlSession sqlSession;

	@Inject
	public ReviewDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public ReviewDto insertReview(final ReviewDto review) {
		sqlSession.insert(NAMESPACE + ".insert", review);
		sqlSession.insert(NAMESPACE + ".insertRelation", review);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("reviewId", review.getId());
		paramMap.put("fileId", 0);
		for(FileDto ff: review.getImgList()) {
			sqlSession.insert(NAMESPACE + ".insertImg", ff);
			paramMap.replace("fileId", ff.getId());
			sqlSession.insert(NAMESPACE + ".insertImgRelation", paramMap);
		}
		
		sqlSession.update(NAMESPACE + ".updateRating", review);
		return sqlSession.selectOne(NAMESPACE + ".select", review.getId());
	}

	@Override
	public ReviewDto selectReview(final int id) {

		return sqlSession.selectOne(NAMESPACE + ".select", id);
	}

	@Override
	public void deleteReview(final ReviewDto review) {
		sqlSession.delete(NAMESPACE + ".deleteImg", review.getImgList());
		sqlSession.delete(NAMESPACE + ".deleteRelation", review);
		sqlSession.delete(NAMESPACE + ".delete", review);
		sqlSession.update(NAMESPACE + ".updateRating", review);
	}

	@Override
	public List<ReviewDto> listUpReview(ReviewDto review) {
		return sqlSession.selectList(NAMESPACE + ".listUp", review);
	}

	@Override
	public void updateReview(ReviewDto review) {
		sqlSession.update(NAMESPACE + ".update", review);
	}
	
	@Override
	public float getRatingAvg(int productId) {
		return sqlSession.selectOne(NAMESPACE + ".getRatingAvg", productId);
	}
}
