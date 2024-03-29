package org.mvnsearch;

import net.datafaker.Faker;
import org.apache.thrift.TException;
import uic.Contact;
import uic.User;
import uic.UserService;

/**
 * user service implementation
 *
 * @author linux_china
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public User getUser(int id) throws TException {
        Faker faker = new Faker();
        Contact contact = new Contact();
        contact.setEmail(faker.internet().emailAddress());
        contact.setPhone(faker.phoneNumber().cellPhone());
        User user = new User();
        user.setId(id);
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setAge(40);
        user.setAvatar(new byte[]{1, 2, 3});
        return user;
    }
}
