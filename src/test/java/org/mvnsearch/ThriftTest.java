package org.mvnsearch;


import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TJSONProtocol;
import org.junit.jupiter.api.Test;
import uic.Contact;
import uic.User;

/**
 * Unit test for simple App.
 */
public class ThriftTest {

    @Test
    public void testApp() throws Exception {
        Contact contact = new Contact();
        contact.email = "demo@example.com";
        contact.phone = "1343434";
        User user = new User();
        user.setId(1);
        user.setFirstName("jacky");
        user.setLastName("chan");
        user.setAge(40);
        user.setAvatar(new byte[]{1, 2});
        user.setContact(contact);
        TSerializer serializer = new TSerializer(new TJSONProtocol.Factory());
        String json = serializer.toString(user);
        System.out.println(json);
    }
}
