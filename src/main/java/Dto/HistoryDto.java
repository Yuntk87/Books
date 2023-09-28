package Dto;

import java.sql.Date;

public class HistoryDto {
	private int his_num;
	private String  user_num;
	private String  book_num;
	private String return_val;
	private Date postDate;
	
	
	public int getHis_num() {
		return his_num;
	}
	public void setHis_num(int his_num) {
		this.his_num = his_num;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getBook_num() {
		return book_num;
	}
	public void setBook_num(String book_num) {
		this.book_num = book_num;
	}
	public String getReturn_val() {
		return return_val;
	}
	public void setReturn_val(String return_val) {
		this.return_val = return_val;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	public HistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryDto(int his_num, String user_num, String book_num, String return_val, Date postDate) {
		super();
		this.his_num = his_num;
		this.user_num = user_num;
		this.book_num = book_num;
		this.return_val = return_val;
		this.postDate = postDate;
	}
	
	
	@Override
	public String toString() {
		return "HistoryDto [his_num=" + his_num + ", user_num=" + user_num + ", book_num=" + book_num + ", return_val="
				+ return_val + ", postDate=" + postDate + "]";
	}
	
	
}
