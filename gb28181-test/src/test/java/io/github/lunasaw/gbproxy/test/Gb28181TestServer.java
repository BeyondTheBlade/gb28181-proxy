package io.github.lunasaw.gbproxy.test;

import javax.sip.message.Request;

import io.github.lunasaw.gbproxy.server.transimit.cmd.ServerSendCmd;
import io.github.lunasaw.sip.common.entity.control.DragZoom;
import io.github.lunasaw.sip.common.utils.SipRequestUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson2.JSON;
import com.luna.common.text.RandomStrUtil;

import io.github.lunasaw.sip.common.entity.Device;
import io.github.lunasaw.sip.common.entity.FromDevice;
import io.github.lunasaw.sip.common.entity.ToDevice;
import io.github.lunasaw.sip.common.layer.SipLayer;
import io.github.lunasaw.sip.common.transmit.SipSender;
import io.github.lunasaw.sip.common.transmit.event.Event;
import io.github.lunasaw.sip.common.transmit.event.EventResult;
import io.github.lunasaw.sip.common.transmit.request.SipRequestProvider;

/**
 * @author luna
 * @date 2023/10/12
 */
@Slf4j
@SpringBootTest(classes = Gb28181ApplicationTest.class)
public class Gb28181TestServer {


    @Autowired
    @Qualifier("serverFrom")
    private Device fromDevice;

    @Autowired
    @Qualifier("serverTo")
    private Device toDevice;

    @BeforeEach
    public void before() {
        // 本地端口监听
        log.info("before::服务端初始化 fromDevice.ip : {} , fromDevice.port : {}", fromDevice.getIp(), fromDevice.getPort());
        SipLayer.addListeningPoint(fromDevice.getIp(), fromDevice.getPort());

    }

    @Test
    public void test_register_server() throws Exception {

    }

    @Test
    public void test_cast_device() {
        System.out.println(JSON.toJSONString(fromDevice));
        System.out.println(JSON.toJSONString(toDevice));
    }

    @Test
    public void test_query() {
        ServerSendCmd.deviceInfo((FromDevice) fromDevice, (ToDevice) toDevice);
    }

    @Test
    public void test_query_catalog() {
        ServerSendCmd.deviceCatalogQuery((FromDevice)fromDevice, (ToDevice)toDevice);
    }

    @Test
    public void control_test() {
        DragZoom dragZoom = new DragZoom();
        dragZoom.setLength("1");
        dragZoom.setWidth("1");
        dragZoom.setMidPointX("1");
        dragZoom.setMidPointY("1");
        dragZoom.setLengthX("1");
        dragZoom.setLengthY("1");

        String s = ServerSendCmd.deviceControlDragIn((FromDevice) fromDevice, (ToDevice) toDevice, dragZoom);
        System.out.println(s);
    }

    @SneakyThrows
    @AfterEach
    public void after() {
        while (true) {

        }
    }
}
