package Dto;

import java.sql.Date;

public class HistoryDto {
	private int his_num;
	private int  user_num;
	private int  book_num;
	private int return_num;
	private Date postDate;
	private String name;
	
	public int getHis_num() {
		return his_num;
	}
	public void setHis_num(int his_num) {
		this.his_num = his_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getReturn_num() {
		return return_num;
	}
	public void setReturn_num(int return_num) {
		this.return_num = return_num;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public HistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryDto(int user_num, int book_num) {
		super();
		this.user_num = user_num;
		this.book_num = book_num;
	}
	public HistoryDto(int user_num, int book_num, int return_num) {
		super();
		this.user_num = user_num;
		this.book_num = book_num;
		this.return_num = return_num;
	}
	public HistoryDto(int his_num, int user_num, int book_num, int return_num, Date postDate, String name) {
		super();
		this.his_num = his_num;
		this.user_num = user_num;
		this.book_num = book_num;
		this.return_num = return_num;
		this.postDate = postDate;
		this.name = name;
	}
	@Override
	public String toString() {
		return "HistoryDto [his_num=" + his_num + ", user_num=" + user_num + ", book_num=" + book_num + ", return_num="
				+ return_num + ", postDate=" + postDate + "]";
	}
	
	
}
