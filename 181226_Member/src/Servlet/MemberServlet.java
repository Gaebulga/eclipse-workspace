package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import VO.Board;
import VO.Member;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		
		// ȸ�����Է���( controller �ڡڡڡ�hidden�� �̿��� ����ڡڡڡ�)
		if (action.equals("signUp")) {
			
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			// 
			MemberDAO dao = new MemberDAO();
			int result = dao.signUp(new Member(id, pw));
			
			// ȸ������ ���� �� (=0) index.jsp
			if (result ==0) {
				// sendRedirect�δ� req ��ü�� ������ ��  ����.
				// key, value
				req.setAttribute("message", "ID�ߺ����� ȸ�����Կ� �����߽��ϴ�.");
				// sendRedirect�� ����ϸ� setAttribute�� �׾������ ������, ���� ���� �� ����.(Garbage Collecter�� �Ծ����)
				
				// servlet�� ������ �ִ� req, resp�� jsp�� �ѱ�� '������'�̶�� ���
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
				
			// ȸ������ ���� �� (=1) login.jsp
			} else {
				resp.sendRedirect("login.jsp");
				
				
			}
			
		// �α��� �޼���()	
		} else if (action.equals("login")) {
			
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			
			// �� ��� - ������ ����?
//			MemberDAO dao = new MemberDAO();
//			
//			Member member = new Member(id, pw);
//			member = dao.login(member);
//			
//			if (member.getUserId().equals(req.getParameter("userId")) 
//					&& member.getUserId().equals(req.getParameter("userPw")) ) {
//				resp.sendRedirect("success.jsp");
//			} else {
//				resp.sendRedirect("login.jsp");
//			}	
			
//			�����Թ��
			MemberDAO dao = new MemberDAO();
			Member result = dao.login(new Member(id, pw));
			
			
			// �α��� ���н�
			if (result == null) {
//				resp.sendRedirect("login.jsp");
				
				req.setAttribute("message", "��ġ�ϴ� ȸ�������� �������� �ʽ��ϴ�.");
				// ID�� PW �� ������ Ʋ�ȴ��� �˷����� �ʴ� ����     ���Ȼ� 
				
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);

			// �α��� ������
			} else {
				
				// result�� db�� �ѹ� �־ ���� ������ �༮ (null �̰ų� VO��ü�̰ų�)
				req.getSession().setAttribute("userId", result.getUserId());
				
				ArrayList<Board> boardList = dao.selectBoard();
				req.setAttribute("boardList", boardList);
				RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
				rd.forward(req, resp);
				
				
//				resp.sendRedirect("success.jsp");
			}
			
		// �Խù� ��� ����
		} else if (action.equals("insertBoard")) {
			String userId= (String) req.getSession().getAttribute("userId");
			
			if (userId==null) { // �α����� �� �� ���� or �ð��� �������� session�� ������ ����
				req.setAttribute("message", "�ۼ� ���� �α����� �� �ּ���");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			
				
			// ����� �α��� �� ����
			} else {
				String message = req.getParameter("message");
				MemberDAO dao = new MemberDAO();
				dao.insertBoard(new Board(userId, message));

				
				ArrayList<Board> boardList = dao.selectBoard();
				
				//req ��ü�� arrayList�� ����
				req.setAttribute("boardList", boardList);
			
				RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
				rd.forward(req, resp);
				
				
			}
		} 
	}
}
