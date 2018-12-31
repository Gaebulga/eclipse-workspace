package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// (1번째 방식)이 요청은 내가 받을게요 라고 표시하는 방식
@WebServlet("/memberJoin")
public class FirstServlet extends HttpServlet{

//	alt shift s 로   override/implements method에서 무엇을 불러 올 수 있는 지 확인
//	doGet, doPost를 불러오자
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는애 - request,  나가는 애 respon
		
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));
		
//		resp.getWriter().println("<html><head></head><body><h1>"+req.getParameter("id")+"Welcome to the HELL!!</h1></body></html>");
		req.getSession().setAttribute("id", req.getParameter("id")); //키, 밸류
		
		resp.sendRedirect("result.jsp");
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
//	get방식의 요청을 처리하는 메소드와  post방식의 요청을 처리하는 메서드가 있다.
	
	
}
