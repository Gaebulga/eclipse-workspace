package DAO;

import java.util.ArrayList;

import VO.Board;
import VO.Member;

public interface MemberMapper {
	
//	resultType�� �����Ƿ� void�� ���� �� ������,,,����� ������ Ȯ���Ϸ��� int�� Ȯ���ϸ� ����
	
	public int signUp(Member mem);// ȸ������
	
	public Member login(Member mem);//�α���
	
	
	// �� void���� �����????
	public void insertBoard(Board board);// �Խù� ���
	
	public ArrayList<Board> selectBoard();// �Խù� ��������
}
