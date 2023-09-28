package Dto;

import java.sql.Date;

public class UserDto {
	private int user_num;
	private String name;
	private String password;
	private Date postDate;
	
	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public UserDto(int user_num, String name, String password, Date postDate) {
		super();
		this.user_num = user_num;
		this.name = name;
		this.password = password;
		this.postDate = postDate;
	}
	
	
	@Override
	public String toString() {
		return "UserDto [user_num=" + user_num + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
}
