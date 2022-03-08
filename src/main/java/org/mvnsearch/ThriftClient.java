package org.mvnsearch;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;
import uic.UserService;

/**
 * thrift client
 *
 * @author linux_china
 */
public class ThriftClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 9091));
        transport.open();
        TProtocol protocol = new TJSONProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        System.out.println(client.getUser(1));
        transport.close();
    }
}
