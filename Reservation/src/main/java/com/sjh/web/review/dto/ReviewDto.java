package com.sjh.web.review.dto;

import java.sql.Timestamp;
import java.util.List;

import com.sjh.web.file.dto.FileDto;

public class ReviewDto {
	private int id;
	private int reservationId;
	private String memberId;
	private int productId;
	private float rating;
	private String content;
	private Timestamp date;
	private List<FileDto> imgList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public List<FileDto> getImgList() {
		return imgList;
	}
	public void setImgList(List<FileDto> imgList) {
		this.imgList = imgList;
	}
	
}
