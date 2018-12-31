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
		
		// 회원가입로직( controller ★★★★hidden을 이용한 방법★★★★)
		if (action.equals("signUp")) {
			
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			// 
			MemberDAO dao = new MemberDAO();
			int result = dao.signUp(new Member(id, pw));
			
			// 회원가입 실패 시 (=0) index.jsp
			if (result ==0) {
				// sendRedirect로는 req 객체에 접근할 수  없다.
				// key, value
				req.setAttribute("message", "ID중복으로 회원가입에 실패했습니다.");
				// sendRedirect를 사용하면 setAttribute가 죽어버리기 때문에, 값을 보낼 수 없다.(Garbage Collecter가 먹어버림)
				
				// servlet이 가지고 있는 req, resp를 jsp로 넘기는 '포워딩'이라는 방법
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
				
			// 회원가입 성공 시 (=1) login.jsp
			} else {
				resp.sendRedirect("login.jsp");
				
				
			}
			
		// 로그인 메서드()	
		} else if (action.equals("login")) {
			
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			
			// 내 방법 - 문제가 뭘까?
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
			
//			선생님방법
			MemberDAO dao = new MemberDAO();
			Member result = dao.login(new Member(id, pw));
			
			
			// 로그인 실패시
			if (result == null) {
//				resp.sendRedirect("login.jsp");
				
				req.setAttribute("message", "일치하는 회원정보가 존재하지 않습니다.");
				// ID나 PW 중 무엇이 틀렸는지 알려주지 않는 이유     보안상 
				
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);

			// 로그인 성공시
			} else {
				
				// result란 db에 한번 넣어서 값을 가져온 녀석 (null 이거나 VO객체이거나)
				req.getSession().setAttribute("userId", result.getUserId());
				
				ArrayList<Board> boardList = dao.selectBoard();
				req.setAttribute("boardList", boardList);
				RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
				rd.forward(req, resp);
				
				
//				resp.sendRedirect("success.jsp");
			}
			
		// 게시물 등록 로직
		} else if (action.equals("insertBoard")) {
			String userId= (String) req.getSession().getAttribute("userId");
			
			if (userId==null) { // 로그인을 안 한 상태 or 시간이 오래지나 session이 끊어진 상태
				req.setAttribute("message", "작성 전에 로그인을 해 주세요");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			
				
			// 제대로 로그인 한 상태
			} else {
				String message = req.getParameter("message");
				MemberDAO dao = new MemberDAO();
				dao.insertBoard(new Board(userId, message));

				
				ArrayList<Board> boardList = dao.selectBoard();
				
				//req 객체에 arrayList를 넣음
				req.setAttribute("boardList", boardList);
			
				RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
				rd.forward(req, resp);
				
				
			}
		} 
	}
}
