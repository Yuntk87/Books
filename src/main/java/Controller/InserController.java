package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import Dto.BookDto;

@WebServlet("/regist")
public class InserController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookName = req.getParameter("bookName");
		
		BookDao dao = new BookDao(getServletContext());
		BookDto dto = new BookDto(bookName);
		
		int res = dao.insertBook(dto);
		dao.close();
		
		if(res!=0) {
			System.out.println("도서등록 성공");
			resp.sendRedirect("./bookList");
		} else {
			System.out.println("도서등록 실패");
			resp.sendRedirect("./regist.jsp");
		}
		
		
	}

	
}
