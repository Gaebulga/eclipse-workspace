package acc.dao;

import java.util.List;

import acc.dto.Account;

public interface AccountMapper {

    public int insert(Account account);

    public int update(Account account);

    public int delete(String accNo);

    public Account findByNo(String accNo);

    public List<Account> findListAll();

}
