package org.mvnsearch;

import com.facebook.nifty.core.*;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import uic.UserService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Nifty server
 *
 * @author linux_china
 */
public class NiftyServer {
    public static void main(String[] args) throws Exception {
        // Create the handler
        UserService.Iface serviceInterface = new UserServiceImpl();

        // Create the processor
        TProcessor processor = new UserService.Processor(serviceInterface);

        // Build the server definition
        ThriftServerDefBuilder serverDefBuilder = new ThriftServerDefBuilder().withProcessor(processor).listen(9090);
        serverDefBuilder.protocol(new TCompactProtocol.Factory());
        ThriftServerDef serverDef = serverDefBuilder.build();

        // Create the server transport

        NettyServerConfigBuilder builder = new NettyServerConfigBuilder();
        NettyServerConfig config = builder.build();
        final NettyServerTransport server = new NettyServerTransport(serverDef, config, new DefaultChannelGroup());

        // Create netty boss and executor thread pools
        ExecutorService bossExecutor = Executors.newCachedThreadPool();
        ExecutorService workerExecutor = Executors.newCachedThreadPool();

        // Start the server
        server.start(new NioServerSocketChannelFactory(bossExecutor, workerExecutor));

        // Arrange to stop the server at shutdown
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    server.stop();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}
