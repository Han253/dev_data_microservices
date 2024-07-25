package uis.iot.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uis.iot.data.documents.DeviceMessage;
import uis.iot.data.dto.DeviceMessageDetail;
import uis.iot.data.repository.DeviceMessageRepository;

@Service
public class DeviceMessageServiceI implements DeviceMessageService {

    @Autowired
    private DeviceMessageRepository repository;
    
    @Override
    public List<DeviceMessageDetail> findByDeviceId(Long deviceId) {
       List<DeviceMessageDetail> list = new ArrayList<>();

       Iterable<DeviceMessage> db_messages = repository.findByDeviceId(deviceId);
        
       db_messages.forEach(message ->{
            DeviceMessageDetail detail = new DeviceMessageDetail();
            detail.setEntity(message);
            list.add(detail);
       });
       
       return list;
    }
    
}
