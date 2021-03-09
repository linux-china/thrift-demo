package org.mvnsearch;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.layered.TFramedTransport;
import uic.UserService;

/**
 * thrift server
 *
 * @author linux_china
 */
public class ThriftServer {
    public static void main(String[] args) throws Exception {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(9090);
        final UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
        TThreadedSelectorServer.Args arg = new TThreadedSelectorServer.Args(socket);
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        arg.selectorThreads(4);
        arg.workerThreads(100);
        TThreadedSelectorServer server = new TThreadedSelectorServer(arg);
        System.out.println("#服务启动-使用:非阻塞&高效二进制编码");
        server.serve();

    }
}
