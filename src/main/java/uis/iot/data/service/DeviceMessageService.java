package uis.iot.data.service;

import java.util.List;

import uis.iot.data.dto.DeviceMessageDetail;

public interface DeviceMessageService {
    

    List<DeviceMessageDetail> findByDeviceId(Long deviceId);

}
