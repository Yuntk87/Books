package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import Dao.HistoryDao;
import Dao.UserDao;
import Dto.BookDto;
import Dto.HistoryDto;
import Dto.UserDto;

@WebServlet("/return")
public class ReturnController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDao dao = new BookDao(getServletContext());
		UserDao udao = new UserDao(getServletContext());
		HistoryDao hdao = new HistoryDao(getServletContext());
		
		int bookNum = Integer.parseInt(req.getParameter("bookNum"));
		String location = req.getParameter("location");
		
		int res = dao.returnBook(bookNum);
		if(res!=0) {
			System.out.println("도서반납 성공");
			UserDto udto = udao.selectUser(location);
			int userNum = udto.getUser_num();
			HistoryDto hdto= new HistoryDto(userNum,bookNum,0);
			hdao.insertHistory(hdto);
			dao.close();
			resp.sendRedirect("./bookList");
		} else {
			System.out.println("도서반납 실패");
			dao.close();
			resp.sendRedirect("./bookList");
		}
		
	}
	
}
