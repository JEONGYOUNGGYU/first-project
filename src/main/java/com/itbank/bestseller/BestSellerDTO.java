package com.itbank.bestseller;



import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//	idx         number          default bestseller_seq.nextval primary key,
//	img         varchar2(2000)  not null,
//	bookname    varchar2(100)   not null,
//	writer      varchar2(100)   not null,
//	pdate       date		    not null,
//	price       number          not null

public class BestSellerDTO {

	private int idx;
	private String img;
	private String bookname;
	private String writer;
	private Date pdate;
	private int price;
	private MultipartFile file;
	
	
	
	
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
