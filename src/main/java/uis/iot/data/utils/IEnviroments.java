package uis.iot.data.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IEnviroments {


    @Value("${broker.uri}")
    public String brokerUrl = "tcp://localhost:1883";

    @Value("${broker.clientId}")
    public String clientId = "serviceMessageClient";

    @Value("${broker.topic}")
    public String topic = "device-messages";
    
}
