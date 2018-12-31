package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);	//doPost와 같은 처리를 하겠다[파라미터만 받아서 같은처리]
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("action");
		if (action.equals("join")) {
			
		String id = req.getParameter("userId");
		
		String pw = req.getParameter("userPw");
		
		System.out.println(id + " " + pw);
		
		HttpSession session = req.getSession();
		session.setAttribute("userId", id);		// (,)앞에 오는 key값은 아무렇게 지정가능,  id라는 value를 저장
		
		resp.sendRedirect("index.jsp");
		
		} else if (action.equals("logout")) {
			
			HttpSession session = req.getSession();
			session.invalidate();	//세션 초기화
			resp.sendRedirect("index.jsp");
		
		}
		
	}
	
}
