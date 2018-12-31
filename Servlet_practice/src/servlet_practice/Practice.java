package servlet_practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class Practice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));
	
		req.getSession().setAttribute("id", req.getParameter("id"));
		
		resp.sendRedirect("res.jsp");
	}
	
}
