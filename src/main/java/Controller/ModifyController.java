package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import Dto.BookDto;

@WebServlet("/modify")
public class ModifyController extends HttpServlet {

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
		req.getRequestDispatcher("./management.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookName = req.getParameter("bookName");
		String location = req.getParameter("location");
		int bookNum = Integer.parseInt(req.getParameter("bookNum"));
		
		BookDao dao = new BookDao(getServletContext());
		BookDto dto = new BookDto(bookNum,bookName,location);
		
		int res = dao.updateBook(dto);
		if(res!=0) {
			System.out.println("도서수정 성공");
			resp.sendRedirect("./bookList");
		} else {
			System.out.println("도서수정 실패");
			resp.sendRedirect("./management.jsp");
		}
	}
	
}
