package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Board;
import VO.Member;

public class MemberDAO {

	private SqlSessionFactory fac = MybatisConfig.getSqlSessionFactory();

	// ȸ������ �޼���
	// SqlSessionFactory�� ���ؼ� SqlSession�� �����ͼ� ����Ѵ�.
	public int signUp(Member mem) {
		SqlSession session = fac.openSession();

		// ������� interface���� ���� XML�� ä���ִ�.
		MemberMapper mapper = session.getMapper(MemberMapper.class);

		int result = 0;

		// �� �κп��� ������ ���� �� �ֱ� ������ try / catch�� ���
		try {
			result = mapper.signUp(mem);
			session.commit();
		} catch (Exception e) {
			return result;
		} finally {
			session.close();
		}

		return result;
	}

	// �α��� �޼���
	public Member login(Member mem) {
		SqlSession session = fac.openSession();

		// MemberMapper �������̽��� ��üȭ ��Ŵ
		MemberMapper mapper = session.getMapper(MemberMapper.class);

		Member m = null;
		try {
			// DB���ٰ� mem�Ѱ��༭ Ȯ��
			m = mapper.login(mem);
			session.commit();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
		return m;
	}

	public void insertBoard(Board board) {
		SqlSession session = fac.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);

		try {
			mapper.insertBoard(board);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public ArrayList<Board> selectBoard() {
		ArrayList<Board> boardList = null;

		SqlSession session = fac.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		try {
			boardList = mapper.selectBoard();
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}
}