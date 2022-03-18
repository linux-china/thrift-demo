package org.mvnsearch;


import org.apache.thrift.TDeserializer;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TJSONProtocol;
import org.junit.jupiter.api.Test;
import uic.Contact;
import uic.User;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class ThriftTest {

    @Test
    public void testApp() throws Exception {
        Set<String> aliases = new HashSet<>();
        aliases.add("linux_chia");
        aliases.add("leijuan");
        Contact contact = new Contact();
        contact.email = "demo@example.com";
        contact.phone = "1343434";
        User user = new User();
        user.setId(1);
        user.setFirstName("jacky");
        user.setLastName("chan");
        user.setAge(40);
        user.setAvatar(new byte[]{1, 2});
        user.setVip(true);
        user.setAliases(aliases);
        user.setContact(contact);
        TSerializer serializer = new TSerializer(new TJSONProtocol.Factory());
        String json = serializer.toString(user);
        System.out.println(json);
        TDeserializer deserializer = new TDeserializer(new TJSONProtocol.Factory());
        User user2= new User();
        deserializer.deserialize(user2, json.getBytes(StandardCharsets.UTF_8));
        System.out.println(user2);
    }
}
