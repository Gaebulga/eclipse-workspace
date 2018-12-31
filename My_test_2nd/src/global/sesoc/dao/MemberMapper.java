package global.sesoc.dao;

import java.util.Map;

import global.sesoc.vo.Member;

public interface MemberMapper {
	/**
	 * 관리자 계정의 이메일과 비밀번호가 맞는지 조회하는 메서드
	 * @param member 안에 입력받은 이메일과 비밀번호가 저장되어 있다.
	 * @return 
	 */
	public Member selectOne(Map<String, String> member);
}
