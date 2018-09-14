package org.mvnsearch;

import org.apache.thrift.TException;
import uic.UserService;

/**
 * user service implementation
 *
 * @author linux_china
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public String getName() throws TException {
        return "你好，这里是Java世界";
    }

    @Override
    public String getNick(int id) throws TException {
        return "雷锋：" + id;
    }
}
