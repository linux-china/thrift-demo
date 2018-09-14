package org.mvnsearch;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import uic.UserService;

/**
 * thrift client
 *
 * @author linux_china
 */
public class ThriftClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 9090));
        transport.open();
        TProtocol protocol = new TCompactProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        System.out.println(client.getNick(1));
        transport.close();
    }
}
