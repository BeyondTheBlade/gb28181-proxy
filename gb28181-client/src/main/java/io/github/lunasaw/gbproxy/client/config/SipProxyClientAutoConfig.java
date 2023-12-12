package io.github.lunasaw.gbproxy.client.config;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import io.github.lunasaw.gbproxy.client.transmit.request.message.ClientMessageRequestProcessor;
import io.github.lunasaw.gbproxy.client.transmit.request.message.MessageClientHandlerAbstract;
import io.github.lunasaw.gbproxy.client.transmit.request.subscribe.ClientSubscribeRequestProcessor;
import io.github.lunasaw.gbproxy.client.transmit.request.subscribe.SubscribeClientHandlerAbstract;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luna
 * @date 2023/10/16
 */
@Slf4j
@Component
@ComponentScan(basePackages = "io.github.lunasaw.gbproxy.client")
public class SipProxyClientAutoConfig implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() {
        Map<String, MessageClientHandlerAbstract> clientMessageHandlerMap = applicationContext.getBeansOfType(MessageClientHandlerAbstract.class);
        clientMessageHandlerMap.forEach((k, v) -> ClientMessageRequestProcessor.addHandler(v));

        Map<String, SubscribeClientHandlerAbstract> clientSubscribeHandlerMap =
            applicationContext.getBeansOfType(SubscribeClientHandlerAbstract.class);
        clientSubscribeHandlerMap.forEach((k, v) -> ClientSubscribeRequestProcessor.addHandler(v));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
