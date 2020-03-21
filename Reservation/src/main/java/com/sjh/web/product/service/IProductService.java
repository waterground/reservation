package com.sjh.web.product.service;

import java.util.List;

import com.sjh.web.product.dto.ProductDto;
import com.sjh.web.promotion.dto.PromotionDto;

public interface IProductService {

	List<ProductDto> listUpByCategory(String categoryName);
	
	int getProductCnt(String categoryName);

	ProductDto selectProductInfo(int productId);

	List<PromotionDto> listUpPromotion();

}