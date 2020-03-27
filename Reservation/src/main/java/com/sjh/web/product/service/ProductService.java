package com.sjh.web.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sjh.web.product.dao.IProductDao;
import com.sjh.web.product.dto.ProductDto;
import com.sjh.web.promotion.dto.PromotionDto;

@Service
public class ProductService implements IProductService {
	
	@Inject
	IProductDao dao;
	
	@Override
	public List<ProductDto> listUpByCategory(String categoryName) {
		
		return dao.listUpProduct(categoryName);
		
	}
	
	@Override
	public int getProductCnt(String categoryName) {
		
		return dao.cntProduct(categoryName);

	}
	
	@Override
	public ProductDto selectProductInfo(int productId) {
		return dao.selectProductInfo(productId);
	}
	
	@Override
	public List<PromotionDto> listUpPromotion() {
		return dao.listUpPromotion();
	}
	
}
