package uis.iot.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uis.iot.data.dto.DeviceMessageDetail;
import uis.iot.data.service.DeviceMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/deviceMessage")
public class DeviceMessageController {

    @Autowired
    private DeviceMessageService service;

    @GetMapping("/{device_id}")
    public List<DeviceMessageDetail> getDeviceMessages(@PathVariable Long device_id) {
        return service.findByDeviceId(device_id);
    }

}
