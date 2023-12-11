package io.github.lunasaw.gbproxy.client.transmit.request.subscribe.catalog;

import javax.sip.RequestEvent;

import gov.nist.javax.sip.message.SIPRequest;
import io.github.lunasaw.sip.common.entity.query.DeviceQuery;
import io.github.lunasaw.sip.common.subscribe.SubscribeHolder;
import io.github.lunasaw.sip.common.subscribe.SubscribeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.lunasaw.gbproxy.client.transmit.request.subscribe.SubscribeProcessorClient;
import io.github.lunasaw.sip.common.entity.base.DeviceSession;
import io.github.lunasaw.sip.common.entity.response.DeviceSubscribe;
import io.github.lunasaw.sip.common.enums.CmdTypeEnum;
import io.github.lunasaw.sip.common.transmit.event.message.MessageHandler;
import io.github.lunasaw.sip.common.transmit.event.subscribe.SubscribeHandlerAbstract;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理设备通道订阅消息 回复OK
 * 
 * @author luna
 * @date 2023/10/19
 */
@Component
@Slf4j
@Getter
@Setter
public class CatalogNotifyMessageHandler extends SubscribeHandlerAbstract {

    public static final String       CMD_TYPE = CmdTypeEnum.CATALOG.getType();

    @Autowired
    private SubscribeProcessorClient subscribeProcessorClient;

    @Autowired
    private SubscribeHolder          subscribeHolder;

    @Override
    public String getRootType() {
        return MessageHandler.NOTIFY;
    }

    @Override
    public void handForEvt(RequestEvent event) {
        DeviceSession deviceSession = getDeviceSession(event);
        // 订阅消息过来
        String sipId = deviceSession.getSipId();
        SIPRequest request = (SIPRequest)event.getRequest();
        SubscribeInfo subscribeInfo = new SubscribeInfo(request, sipId);
        subscribeHolder.putCatalogSubscribe(sipId, subscribeInfo);

        DeviceQuery deviceQuery = parseXml(DeviceQuery.class);

    }

    @Override
    public String getCmdType() {
        return CMD_TYPE;
    }
}
