package org.mvnsearch.drift;


import com.google.common.collect.ImmutableSet;
import io.airlift.drift.codec.ThriftCodecManager;
import io.airlift.drift.server.DriftServer;
import io.airlift.drift.server.DriftService;
import io.airlift.drift.server.stats.NullMethodInvocationStatsFactory;
import io.airlift.drift.transport.netty.server.DriftNettyServerConfig;
import io.airlift.drift.transport.netty.server.DriftNettyServerTransportFactory;

/**
 * drift server app
 *
 * @author linux_china
 */
public class DriftAppServer {
    public static void main(String[] args) {
        // netty config
        DriftNettyServerConfig config = new DriftNettyServerConfig();
        config.setPort(9090);
        DriftServer driftServer = new DriftServer(
                new DriftNettyServerTransportFactory(config), //netty transport
                new ThriftCodecManager(),  //thrift codec
                new NullMethodInvocationStatsFactory(),
                ImmutableSet.of(new DriftService(new ScribeImpl())),  //services
                ImmutableSet.of());

        // start the server (it should be shutdown when no longer needed)
        driftServer.start();
    }
}
