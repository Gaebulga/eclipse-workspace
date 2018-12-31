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
		req.setCharacterEncoding("UTF-8");// �ѱ۷� ��� �ѱ��� �ȱ������� ����
		
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
			System.out.println("�ƹ����� ��Ÿ�� �ó�����");
		}
		
		Person p = new Person(id, pw, name, add, phone);
		
		/*
		p.setId(id);
		p.setPw(pw);
		p.setName(name);
		p.setAdd(add);
		p.setPhone(phone);
		*/
		
//		�ڡڡڡ� session�� �ٸ� ��� ��� ���� ���̹Ƿ� �ݵ�� ��������� �ȵȴ�.�ڡڡڡڡ�
		HttpSession session = req.getSession();
		session.setAttribute("myId", id);
//	 == req.getSession().setAttribute("myId", id);
		
//		�� �� toString() ��µ�
//		System.out.println(p.toString());
		System.out.println(p);
		
		resp.sendRedirect("res.jsp");
	}
	
}
