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

@WebServlet("/userHistory")
public class UserHistoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HistoryDao dao = new HistoryDao(getServletContext());
		String tmp = req.getParameter("userNum");
		int num = 0;
		if(tmp != null) {
			num = Integer.parseInt(tmp);
		}
		
		List<HistoryDto> hList = dao.HistoryList(num);
		dao.close();
		
		req.setAttribute("hList", hList);
		req.getRequestDispatcher("./userHistory.jsp").forward(req, resp);
	}
	
}
