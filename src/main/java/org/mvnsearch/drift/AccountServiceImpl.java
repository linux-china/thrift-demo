package org.mvnsearch.drift;

/**
 * Account service implementation
 *
 * @author linux_china
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public Account save(Account account) {
        return account;
    }

    @Override
    public Account findById(Integer id) {
        return new Account(id, "Name");
    }
}
