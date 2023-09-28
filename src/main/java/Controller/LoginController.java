package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Dto.UserDto;



@WebServlet("/login")
public class LoginController extends HttpServlet{
	UserDao dao = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		UserDao dao = new UserDao(req.getServletContext());
		UserDto dto = dao.selectUser(name);
		dao.close();
		
		if(dto == null) {
			System.out.println("로그인 실패");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.print("<script>");
			writer.println("alert('존재하지 않는 아이디 입니다.')");
			writer.print("</script>");
			req.getRequestDispatcher("./main.jsp").forward(req, resp);
			writer.close();
		}
		else if(dto.getName().equals(name) && dto.getPassword().equals(password)) {
			System.out.println("로그인 성공");
			
			HttpSession session = req.getSession();
			session.setAttribute("userName", dto.getName());
			req.getRequestDispatcher("./navi.jsp").forward(req, resp);
		}
	}
	
}