package DAO;

import VO.Member;

public interface MemberMapper {
	
	public int signUp(Member mem);
	
	public Member login(Member mem);
}
