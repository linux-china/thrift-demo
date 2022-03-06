package org.mvnsearch;


import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.junit.jupiter.api.Test;
import uic.User;

/**
 * Unit test for simple App.
 */
public class ThriftTest {

    @Test
    public void testApp() throws Exception {
        User user = new User();
        user.setId(1);
        user.setFirstName("jacky");
        user.setLastName("chan");
        user.setAge(40);
        TSerializer serializer = new TSerializer(new TSimpleJSONProtocol.Factory());
        String json = serializer.toString(user);
        System.out.println(json);
    }
}
