package global.sesoc.dao;

import java.util.Map;

import global.sesoc.vo.Member;

public interface MemberMapper {
	/**
	 * ������ ������ �̸��ϰ� ��й�ȣ�� �´��� ��ȸ�ϴ� �޼���
	 * @param member �ȿ� �Է¹��� �̸��ϰ� ��й�ȣ�� ����Ǿ� �ִ�.
	 * @return 
	 */
	public Member selectOne(Map<String, String> member);
}
