package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import Common.JDBConnect;
import Dto.UserDto;

public class UserDao extends JDBConnect {

	public UserDao(ServletContext application) {
		super(application);
		// TODO Auto-generated constructor stub
	}
	
	public int insertUser(UserDto u ) {
		int res=0;
		String sql="insert into user(name,password) values(?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1,u.getName());
			psmt.setString(2,u.getPassword());
			res=psmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("회원가입 중 오류발생");
			e.printStackTrace();
		}return res;
				    
	}  
	
	public UserDto selectUser(String name) {
		UserDto u = null; 
		try {
			String sql = "select * from user where name=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,  name);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				u = new UserDto();
				u.setUser_num(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("회원조회중 오류발생");
			e.printStackTrace();
		}
		return u;
	}
	
	
	public List<UserDto> UserList(){
		ArrayList<UserDto> uList = new ArrayList<UserDto>();
		UserDto dto = null;
		String sql = "SELECT * FROM user";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			    dto = new UserDto();
				dto.setUser_num(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setPostDate(rs.getDate(4));
				uList.add(dto);
			}
		}
		catch(Exception e) {
			System.out.println("전체도서 조회 중 오류 발생");
			e.printStackTrace();
		}
		return uList;
	}
	
}
