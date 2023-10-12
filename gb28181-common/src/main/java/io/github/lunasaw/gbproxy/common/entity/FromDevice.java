package io.github.lunasaw.gbproxy.common.entity;

import lombok.Data;

/**
 * @author luna
 * @date 2023/10/12
 */
@Data
public class FromDevice extends Device {

    /**
     * fromTag用于标识SIP消息的发送方，每个SIP消息都应该包含一个fromTag字段，这个字段的值是由发送方生成的随机字符串，用于标识该消息的发送方。在SIP消息的传输过程中，每个中间节点都会将fromTag字段的值保留不变，以确保消息的发送方不变。
     */
    private String fromTag;
}
