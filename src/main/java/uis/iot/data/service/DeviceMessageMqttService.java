package uis.iot.data.service;

import org.springframework.messaging.Message;;

public interface DeviceMessageMqttService {
    
    Boolean saveMqttDeviceMessage(Message<?> message);
}
