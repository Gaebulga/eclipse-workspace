package acc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import acc.MybatisConfig;
import acc.dto.Account;

public class AccountDao{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();  
	/**
	 * 인자로 받은 계좌객체를 데이터베이스에 등록한다.
	 */
	public void insert(Account account) {
		SqlSession ss= null;
		
		ss = factory.openSession();
		AccountMapper mapper = ss.getMapper(AccountMapper.class);
		mapper.insert(account);
		ss.commit();
		ss.close();
	}

	/**
	 * 인자로 받은 계좌번호로 데이터베이스에서 삭제한다.
	 */
	public int delete(String accNo) {
		int result = 0;
		
		return result;
	}

	/**
	 * 인자로 받은 계좌객체로 계좌번호가 일치하는 객체의 정보를 수정(객체를 덮어씀)한다.
	 */
	public int update(Account account) {
		int result = 0;
		
		return result;
	}

	/**
	 * 인자로 받은 계좌번호로 데이터베이스에서 일치하는 계좌정보를 불러온다.
	 */
	public Account findByNo(String accNo) {
		
		return null;
	}

	/**
	 * 데이터베이스에 등록된 모든 계좌정보를 불러온다.
	 */
	public List<Account> findListAll() {
		
		return null;
	}

}
