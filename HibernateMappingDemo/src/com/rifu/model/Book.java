package com.rifu.model;

import java.sql.Blob;
import java.util.Date;

public class Book {
	private int id;
	private String bookName;//图书价格
	private float price;//价格
	private boolean specialPrice;//是否为特价
	private Date publishDate;//发布日期
	private String author;
	private String introduction;//简介
	private Blob bookForeground;//图书封面
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(boolean specialPrice) {
		this.specialPrice = specialPrice;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Blob getBookForeground() {
		return bookForeground;
	}
	public void setBookForeground(Blob bookForeground) {
		this.bookForeground = bookForeground;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", specialPrice=" + specialPrice
				+ ", publishDate=" + publishDate + ", author=" + author + ", introduction=" + introduction + "]";
	}
	
	
	
}
