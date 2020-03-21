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
		
		if(categoryName.equals("all")) {
			return dao.listUpAll();
		}else {
			return dao.listUpCategory(categoryName);
		}
		
	}
	
	@Override
	public int getProductCnt(String categoryName) {
		
		if(categoryName.equals("all")) {
			return dao.cntAll();
		}else {
			return dao.cntCategory(categoryName);
		}
		
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
