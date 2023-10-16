package io.github.lunasaw.gbproxy.client.transmit.response.cancel;

import javax.sip.ResponseEvent;

import org.springframework.stereotype.Component;

import io.github.lunasaw.sip.common.transmit.event.response.SipResponseProcessorAbstract;

/**
 * CANCEL响应处理器
 *
 * @author weidian
 */
@Component
public class CancelResponseProcessor extends SipResponseProcessorAbstract {

    public static final String METHOD = "CANCEL";

    private String method = METHOD;

    /**
     * 处理CANCEL响应
     *
     * @param evt
     */
    @Override
    public void process(ResponseEvent evt) {

    }

}
