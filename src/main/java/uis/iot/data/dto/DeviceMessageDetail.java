package uis.iot.data.dto;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import uis.iot.data.documents.DeviceMessage;

@Data
@NoArgsConstructor
public class DeviceMessageDetail {


    public String id;
    public String userUuid;
    public Long deviceId;
    public String topic;
    public String timeStamp;
    public Map<String, Object> values;


    public void setEntity(DeviceMessage entity) {

        this.id = entity.getId();
        this.userUuid = entity.getUserUuid();
        this.deviceId = entity.getDeviceId();
        this.topic = entity.getTopic();
        this.timeStamp = entity.getTimeStamp();
        this.values = entity.getValues();
        
    }

    
}
