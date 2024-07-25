package uis.iot.data.documents;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "device_messages")
public class DeviceMessage {
    
    public String id;

    public String userUuid;

    public Long deviceId;

    public String topic;

    public String timeStamp;

    public Map<String, Object> values;




}
