package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import Dto.BookDto;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tmp = req.getParameter("bookNum");
		int bookNum = 0;
		
		if(tmp != null) {
			bookNum = Integer.parseInt(tmp);
		}
		
		BookDao dao = new BookDao(getServletContext());
		int res = dao.deleteBook(bookNum);
		dao.close();
		
		if(res==0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
			resp.sendRedirect("./bookList");
		}
	}
	
}
