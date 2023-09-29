package Controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/lendBook")
public class LendController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tmp = req.getParameter("bookNum");
		int bookNum = 0;
		
		if(tmp != null) {
			bookNum = Integer.parseInt(tmp);
		}
		
		BookDao dao = new BookDao(getServletContext());
		BookDto dto = dao.selectBook(bookNum);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("./lend.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDao dao = new BookDao(getServletContext());
		UserDao udao = new UserDao(getServletContext());
		HistoryDao hdao = new HistoryDao(getServletContext());
		
		int num = Integer.parseInt(req.getParameter("bookNum"));
		String location = req.getParameter("location");
		
		BookDto dto = new BookDto(num,location);
		int res = dao.lendBook(dto);
		if(res==0) {
			System.out.println("대출 실패");
			dao.close();
		} else {
			System.out.println("대출 성공");
			UserDto udto = udao.selectUser(location);
			int userNum = udto.getUser_num();
			HistoryDto hdto= new HistoryDto(userNum,num,1);
			hdao.insertHistory(hdto);
			dao.close();
			resp.sendRedirect("./bookList");
		}
	}
	
	
	
}
