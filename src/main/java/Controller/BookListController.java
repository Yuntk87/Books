package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import Dto.BookDto;

@WebServlet("/bookList")
public class BookListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDao dao = new BookDao(getServletContext());
		
		List<BookDto> bList = dao.selectList();
		dao.close();
		
		req.setAttribute("bList", bList);
		req.getRequestDispatcher("./bookList.jsp").forward(req, resp);
	}
	
}
