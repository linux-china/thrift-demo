package org.mvnsearch.drift;

import io.airlift.drift.annotations.ThriftMethod;
import io.airlift.drift.annotations.ThriftService;

/**
 * account service
 *
 * @author linux_china
 */
@ThriftService
public interface AccountService {
    @ThriftMethod
    Account save(Account account);

    @ThriftMethod
    Account findById(Integer id);
}