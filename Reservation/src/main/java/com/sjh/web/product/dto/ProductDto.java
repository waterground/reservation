package com.sjh.web.product.dto;

import java.util.List;

import com.sjh.web.file.dto.FileDto;

public class ProductDto {
	// product table
	private int id;
	private String categoryName;
	private String description;
	
	// product_info table
	private String name;
	private String tel;
	private String address;
	private String openingHours;
	private String homepage;
	
	private FileDto mainImg;
	//private List<FileDto> imgList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public FileDto getMainImg() {
		return mainImg;
	}
	public void setMainImg(FileDto mainImg) {
		this.mainImg = mainImg;
	}
	/*
	public List<FileDto> getImgList() {
		return imgList;
	}
	public void setImgList(List<FileDto> imgList) {
		this.imgList = imgList;
	}
	*/
	
}
