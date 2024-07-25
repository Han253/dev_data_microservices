package uis.iot.data;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import uis.iot.data.service.DeviceMessageMqttService;
import uis.iot.data.utils.IEnviroments;

@SpringBootApplication
public class DataApplication {

	@Autowired
	private DeviceMessageMqttService mqttService;

	@Autowired
	private IEnviroments env;


	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}

	@Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

	@Bean
    public MessageProducer inbound() {
        
        System.out.println(env.brokerUrl);
        System.out.println(env.clientId);
        System.out.println(env.topic);


        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
						env.brokerUrl,
                        env.clientId,
                        env.topic);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            private final Logger LOGGER = LoggerFactory.getLogger(MessageHandler.class);
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                LOGGER.info("MQTT RECIBE MESSAGE: "+message.toString());
                mqttService.saveMqttDeviceMessage(message);
            }

        };
    }




}
