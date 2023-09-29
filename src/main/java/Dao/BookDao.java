package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import Common.JDBConnect;
import Dto.BookDto;
import Dto.UserDto;

public class BookDao extends JDBConnect{

	public BookDao(ServletContext application) {
		super(application);
		// TODO Auto-generated constructor stub
	}
	
	public int insertBook(BookDto b) {
		int res=0;
		String sql="insert into book(book_name) values(?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1,b.getBook_name());
			res=psmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("도서 등록 중 오류발생");
			e.printStackTrace();
		}return res;
				    
	} 
	
	 public int updateBook(BookDto dto) {
			String sql = "UPDATE book SET book_name=?, location=? WHERE book_num=?";
			int res = 0;
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, dto.getBook_name());
				psmt.setString(2, dto.getLocation());
				psmt.setInt(3, dto.getBook_num());
				res = psmt.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println("도서 수정 중 예외 발생");
				e.printStackTrace();
			}
			return res;
		}
	 
	 public int lendBook(BookDto dto) {
		 String sql = "UPDATE book SET location=?, chk_num=1 WHERE book_num=?";
		 int res = 0;
		 try {
			 psmt = con.prepareStatement(sql);
			 psmt.setString(1, dto.getLocation());
			 psmt.setInt(2, dto.getBook_num());
			 res = psmt.executeUpdate();
		 }
		 catch(SQLException e) {
			 System.out.println("대출처리 중 예외 발생");
			 e.printStackTrace();
		 }
		 return res;
	 }
	 
	 public int returnBook(int num) {
		 String sql = "UPDATE book SET location='', chk_num=0 WHERE book_num=?";
		 int res = 0;
		 try {
			 psmt = con.prepareStatement(sql);
			 psmt.setInt(1, num);
			 res = psmt.executeUpdate();
		 }
		 catch(SQLException e) {
			 System.out.println("도서반납 중 예외 발생");
			 e.printStackTrace();
		 }
		 return res;
	 }
	
	 public int deleteBook(int num) {
			int res=0;
			String sql = "DELETE FROM book WHERE book_num=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setInt(1,num);
				res = psmt.executeUpdate();
			}catch(SQLException e) {
				System.out.println("도서 삭제 중 예외발생");
				e.printStackTrace();
			}
			return res;
		}
	
	public List<BookDto> selectList(){
		ArrayList<BookDto> bList = new ArrayList<BookDto>();
		BookDto dto = null;
		String sql = "SELECT * FROM book";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			    dto = new BookDto();
				dto.setBook_num(rs.getInt(1));
				dto.setBook_name(rs.getString(2));
				dto.setLocation(rs.getString(3));
				dto.setChk_num(rs.getInt(4));
				dto.setPostDate(rs.getDate(5));
				bList.add(dto);
			}
		}
		catch(Exception e) {
			System.out.println("전체도서 조회 중 오류 발생");
			e.printStackTrace();
		}
		return bList;
	}
	
	
	public BookDto selectBook(int num){
		BookDto dto = null;
		String sql = "SELECT * FROM book WHERE book_num = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new BookDto();
				dto.setBook_num(rs.getInt(1));
				dto.setBook_name(rs.getString(2));
				dto.setLocation(rs.getString(3));
				dto.setPostDate(rs.getDate(4));
			}
		}
		catch(Exception e) {
			System.out.println("전체도서 조회 중 오류 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
}
