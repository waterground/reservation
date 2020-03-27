package com.sjh.web.product.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sjh.web.product.dto.ProductDto;
import com.sjh.web.promotion.dto.PromotionDto;

@Repository
public class ProductDao implements IProductDao {
	private static final String NAMESPACE = "com.sjh.web.mappers.product.ProductMapper";

	private final SqlSession sqlSession;
	
	@Inject
	public ProductDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ProductDto> listUpProduct(final String categoryName){
		return sqlSession.selectList(NAMESPACE + ".listUpProduct", categoryName);
	}
	
	@Override
	public int cntProduct(final String categoryName){
		return sqlSession.selectOne(NAMESPACE + ".cntProduct", categoryName);
	}
	
	@Override
	public ProductDto selectProductInfo(final int id) {
		List<ProductDto> list = sqlSession.selectList(NAMESPACE + ".selectProductInfo", id);
		return list.get(0);
	}
	
	@Override
	public List<PromotionDto> listUpPromotion(){
		return sqlSession.selectList(NAMESPACE + ".listUpPromotion");
	}
}
