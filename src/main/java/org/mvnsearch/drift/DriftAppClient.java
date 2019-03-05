package org.mvnsearch.drift;

import com.google.common.collect.ImmutableList;
import com.google.common.net.HostAndPort;
import io.airlift.drift.client.DriftClientFactory;
import io.airlift.drift.client.address.SimpleAddressSelector;
import io.airlift.drift.client.address.SimpleAddressSelectorConfig;
import io.airlift.drift.codec.ThriftCodecManager;
import io.airlift.drift.transport.netty.client.DriftNettyClientConfig;
import io.airlift.drift.transport.netty.client.DriftNettyMethodInvokerFactory;

/**
 * drift client app
 *
 * @author linux_china
 */
@SuppressWarnings("UnstableApiUsage")
public class DriftAppClient {
    public static void main(String[] args) {
        DriftClientFactory driftClientFactory = driftClientFactory();
        AccountService accountService = driftClientFactory.createDriftClient(AccountService.class).get();
        Account account = accountService.findById(1);
        System.out.println(account.getName());
    }


    public static DriftClientFactory driftClientFactory() {
        SimpleAddressSelectorConfig simpleAddressSelectorConfig = new SimpleAddressSelectorConfig();
        simpleAddressSelectorConfig.setAddressesList(ImmutableList.of(HostAndPort.fromParts("localhost", 9090)));
        DriftNettyMethodInvokerFactory<?> methodInvokerFactory = DriftNettyMethodInvokerFactory.createStaticDriftNettyMethodInvokerFactory(new DriftNettyClientConfig());
        return new DriftClientFactory(new ThriftCodecManager(), methodInvokerFactory, new SimpleAddressSelector(simpleAddressSelectorConfig));
    }
}
