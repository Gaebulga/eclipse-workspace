package DAO;

import java.util.ArrayList;

import VO.Board;
import VO.Member;

public interface MemberMapper {
	
//	resultType가 없으므로 void로 받을 수 있지만,,,제대로 들어가는지 확인하려면 int로 확인하면 좋다
	
	public int signUp(Member mem);// 회원가입
	
	public Member login(Member mem);//로그인
	
	
	// 왜 void인지 물어보자????
	public void insertBoard(Board board);// 게시물 등록
	
	public ArrayList<Board> selectBoard();// 게시물 가져오기
}
