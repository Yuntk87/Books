package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import Common.JDBConnect;
import Dto.BookDto;
import Dto.HistoryDto;
import Dto.UserDto;

public class HistoryDao extends JDBConnect{

	public HistoryDao(ServletContext application) {
		super(application);
		// TODO Auto-generated constructor stub
	}
	
	public int insertHistory(HistoryDto dto) {
		int res=0;
		String sql="insert into history(user_num,book_num,return_num) values(?,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,dto.getUser_num());
			psmt.setInt(2,dto.getBook_num());
			psmt.setInt(3,dto.getReturn_num());
			res=psmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("이력 등록 중 오류발생");
			e.printStackTrace();
		}return res;
				    
	}
	
	public List<HistoryDto> HistoryList(int num){
		ArrayList<HistoryDto> hList = new ArrayList<HistoryDto>();
		HistoryDto dto = null;
		String sql = "SELECT his_num,h.user_num,name,book_num, return_num, h.postDate from history h left outer join user u  on h.user_num = u.user_num WHERE h.user_num = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new HistoryDto();
				dto.setHis_num(rs.getInt(1));
				dto.setUser_num(rs.getInt(2));
				dto.setName(rs.getString(3));
				dto.setBook_num(rs.getInt(4));
				dto.setReturn_num(rs.getInt(5));
				dto.setPostDate(rs.getDate(6));
				hList.add(dto);
			}
		}
		catch(Exception e) {
			System.out.println("전체도서 조회 중 오류 발생");
			e.printStackTrace();
		}
		return hList;
	}
	
}
