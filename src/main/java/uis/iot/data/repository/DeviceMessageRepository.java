package uis.iot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import uis.iot.data.documents.DeviceMessage;

public interface DeviceMessageRepository extends MongoRepository<DeviceMessage, String> {

    List<DeviceMessage> findByDeviceId(Long deviceId);
    
}
