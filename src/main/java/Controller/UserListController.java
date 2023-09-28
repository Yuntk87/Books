package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import Dao.UserDao;
import Dto.BookDto;
import Dto.UserDto;

@WebServlet("/userList")
public class UserListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDao(getServletContext());
		
		List<UserDto> uList = dao.UserList();
		dao.close();
		
		req.setAttribute("uList", uList);
		req.getRequestDispatcher("./userList.jsp").forward(req, resp);
	}
	
}
