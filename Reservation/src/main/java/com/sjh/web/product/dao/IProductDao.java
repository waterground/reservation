package com.sjh.web.product.dao;

import java.util.List;

import com.sjh.web.product.dto.ProductDto;
import com.sjh.web.promotion.dto.PromotionDto;

public interface IProductDao {

	List<ProductDto> listUpCategory(String categoryName);

	List<ProductDto> listUpAll();
	
	int cntCategory(String categoryName);
	
	int cntAll();
	
	ProductDto selectProductInfo(int id);

	List<PromotionDto> listUpPromotion();

}