package io.github.lunasaw.sip.common.enums;

import io.github.lunasaw.sip.common.entity.control.*;
import io.github.lunasaw.sip.common.utils.SipRequestUtils;
import lombok.SneakyThrows;
import org.dom4j.Element;
import org.springframework.util.ObjectUtils;

import javax.sip.header.ContentTypeHeader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum DeviceControlType {

    /**
     * 云台控制
     * 上下左右，预置位，扫描，辅助功能，巡航
     */
    PTZ("PTZCmd", "云台控制", null),
    /**
     * 远程启动
     */
    TELE_BOOT("TeleBoot", "远程启动", null),
    /**
     * 录像控制
     */
    RECORD("RecordCmd", "录像控制", null),
    /**
     * 布防撤防
     */
    GUARD("GuardCmd", "布防撤防", DeviceControlGuard.class),
    /**
     * 告警控制
     */
    ALARM("AlarmCmd", "告警控制", DeviceControlAlarm.class),
    /**
     * 强制关键帧
     */
    I_FRAME("IFameCmd", "强制关键帧", DeviceControlIFame.class),
    /**
     * 拉框放大
     */
    DRAG_ZOOM_IN("DragZoomIn", "拉框放大", DeviceControlDragIn.class),
    /**
     * 拉框缩小
     */
    DRAG_ZOOM_OUT("DragZoomOut", "拉框缩小", DeviceControlDragOut.class),
    /**
     * 看守位
     */
    HOME_POSITION("HomePosition", "看守位", DeviceControlPosition.class);

    private final String val;

    private final String desc;

    private final Class<?> clazz;

    private static final Map<String, DeviceControlType> MAP = new ConcurrentHashMap<>();


    DeviceControlType(String val, String desc, Class<?> clazz) {
        this.val = val;
        this.desc = desc;
        this.clazz = clazz;
    }

    // hash Map
    public static DeviceControlType getType(String val) {
        if (ObjectUtils.isEmpty(val)) {
            return null;
        }
        for (DeviceControlType deviceControlType : DeviceControlType.values()) {
            if (deviceControlType.getVal().equals(val)) {
                return deviceControlType;
            }
        }
        return null;
    }

    @SneakyThrows
    public static DeviceControlType getDeviceControlType(String key) {
        if (MAP.containsKey(key)) {
            return MAP.get(key);
        } else {
            DeviceControlType type = getType(key);
            MAP.put(key, type);
            return type;
        }
    }


    public Class<?> getClazz() {
        return clazz;
    }

    public String getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }
}
