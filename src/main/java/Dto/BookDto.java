package Dto;

import java.sql.Date;

public class BookDto {
	private int book_num;
	private String  book_name;
	private String location;
	private int chk_num;
	private Date postDate;
	
	
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getChk_num() {
		return chk_num;
	}
	public void setChk_num(int chk_num) {
		this.chk_num = chk_num;
	}
	
	
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookDto(int book_num, String book_name, String location, int chk_num, Date postDate) {
		super();
		this.book_num = book_num;
		this.book_name = book_name;
		this.location = location;
		this.chk_num = chk_num;
		this.postDate = postDate;
	}
	public BookDto(String book_name) {
		super();
		this.book_name = book_name;
	}
	
	public BookDto(int book_num, String book_name, String location) {
		super();
		this.book_num = book_num;
		this.book_name = book_name;
		this.location = location;
	}
	
	public BookDto(int book_num, String location) {
		super();
		this.book_num = book_num;
		this.location = location;
	}
	@Override
	public String toString() {
		return "BookDto [book_num=" + book_num + ", book_name=" + book_name + ", location=" + location + ", chk_num="
				+ chk_num + ", postDate=" + postDate + "]";
	}
	

}
