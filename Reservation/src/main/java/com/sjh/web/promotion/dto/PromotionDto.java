package com.sjh.web.promotion.dto;

import com.sjh.web.file.dto.FileDto;

public class PromotionDto {
	private int id;
	private int productId;
	private FileDto img;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public FileDto getImg() {
		return img;
	}
	public void setImg(FileDto img) {
		this.img = img;
	}
	
}
