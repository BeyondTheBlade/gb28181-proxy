package io.github.lunasaw.gbproxy.server.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * <?xml version="1.0" encoding="gb2312"?>
 * <Control>
 * <CmdType>DeviceConfig</CmdType>
 * <SN>150959</SN>
 * <DeviceID>channelId</DeviceID>
 * <BasicParam>
 * <Name>name</Name>
 * <Expiration>30</Expiration>
 * <HeartBeatInterval>300</HeartBeatInterval>
 * <HeartBeatCount>300</HeartBeatCount>
 * </BasicParam>
 * </Control>
 * 
 * @author luna
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "Control")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceConfig extends DeviceQuery {


    @XmlElement(name = "BasicParam")
    public BasicParam basicParam;

    public DeviceConfig(String cmdType, String sn, String deviceId) {
        this.cmdType = cmdType;
        this.sn = sn;
        this.deviceId = deviceId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlRootElement(name = "BasicParam")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class BasicParam {

        @XmlElement(name = "Name")
        public String name;
        @XmlElement(name = "Expiration")
        public String expiration;
        @XmlElement(name = "HeartBeatInterval")
        public String heartBeatInterval;
        @XmlElement(name = "HeartBeatCount")
        public String heartBeatCount;

    }

    public static void main(String[] args) {
        DeviceConfig alarm = new DeviceConfig();
        alarm.setCmdType("DeviceControl");
        alarm.setSn("179173");
        alarm.setDeviceId("123");

        BasicParam basicParam = new BasicParam();
        basicParam.setExpiration("30");
        basicParam.setHeartBeatCount("31");
        basicParam.setHeartBeatInterval("300");
        basicParam.setName("QWWQ");
        alarm.setBasicParam(basicParam);

        System.out.println(alarm);

    }
}
