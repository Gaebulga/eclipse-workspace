package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.Person;

@WebServlet("/member2")
public class Member2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");// 한글로 적어도 한글이 안깨지도록 방지
		
		String id = req.getParameter("myId");
		String pw = req.getParameter("myPw");
		String name = req.getParameter("myName");
		String add = req.getParameter("myAddress");
		String phone = req.getParameter("myPhone");
		
		String [] hobby = req.getParameterValues("hobby");
		
		if (hobby!=null) {
			for (String h : hobby) {
				System.out.println(h);
			}
		} else {
			System.out.println("아무고토 센타쿠 시나깠따");
		}
		
		Person p = new Person(id, pw, name, add, phone);
		
		/*
		p.setId(id);
		p.setPw(pw);
		p.setName(name);
		p.setAdd(add);
		p.setPhone(phone);
		*/
		
//		★★★★ session은 다른 언어 배울 때도 쓰이므로 반드시 ㅇ까먹으면 안된다.★★★★★
		HttpSession session = req.getSession();
		session.setAttribute("myId", id);
//	 == req.getSession().setAttribute("myId", id);
		
//		둘 다 toString() 출력됨
//		System.out.println(p.toString());
		System.out.println(p);
		
		resp.sendRedirect("res.jsp");
	}
	
}
