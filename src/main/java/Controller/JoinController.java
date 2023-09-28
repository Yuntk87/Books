package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dto.UserDto;


@WebServlet("/join")
public class JoinController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		    String name = req.getParameter("name");
		 	String password = req.getParameter("password");
		 	
		 	UserDao dao = new UserDao(req.getServletContext());
		    UserDto dto = new UserDto(name,password);

			int res = dao.insertUser(dto);
			dao.close();
			
			if(res!=0) {
				System.out.println("회원가입 성공");
				resp.sendRedirect("./main.jsp");
			}
			else {
				System.out.println("회원가입 실패");
				req.setAttribute("dto", dto);
				req.setAttribute("msg", "회원가입 실패");
				req.getRequestDispatcher("./join.jsp").forward(req, resp);
			}
	}
	

}
