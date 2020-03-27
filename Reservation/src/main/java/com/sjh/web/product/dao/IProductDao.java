package com.sjh.web.product.dao;

import java.util.List;

import com.sjh.web.product.dto.ProductDto;
import com.sjh.web.promotion.dto.PromotionDto;

public interface IProductDao {

	List<ProductDto> listUpProduct(String categoryName);
	
	int cntProduct(String categoryName);
	
	ProductDto selectProductInfo(int id);

	List<PromotionDto> listUpPromotion();

}