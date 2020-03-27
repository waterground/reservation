package com.sjh.web.reservation.dto;

import java.sql.Date;

import com.sjh.web.file.dto.FileDto;

public class ReservationDto {
	private int id;
	private int productId;
	private String productName;
	private String memberId;
	private Date createDate;
	private Date date;
	private int people;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public FileDto getImg() {
		return img;
	}
	public void setImg(FileDto img) {
		this.img = img;
	}
	
}
