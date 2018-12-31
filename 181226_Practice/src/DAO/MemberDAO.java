package DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Member;

public class MemberDAO {
	
	private SqlSessionFactory fac = MybatisConfig.getSqlSessionFactory();
	
	public int signUp(Member mem) {
		SqlSession session = fac.openSession(); 
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		int result = 0;
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
	
	public Member login(Member mem) {
		SqlSession session = fac.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		Member m = null;
		try {
			m = mapper.login(mem);
			session.commit();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
		return m;
	}	
}
