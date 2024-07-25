package uis.iot.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import uis.iot.data.documents.DeviceMessage;
import uis.iot.data.repository.DeviceMessageRepository;

@Service
public class DeviceMessageMqttServiceI implements DeviceMessageMqttService{

    @Autowired
    private DeviceMessageRepository repository;
    

    @Override
    public Boolean saveMqttDeviceMessage(Message<?> message) {
        try {
            Gson g = new Gson();
            DeviceMessage message_obj = g.fromJson(message.getPayload().toString(), DeviceMessage.class);
            repository.save(message_obj);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
