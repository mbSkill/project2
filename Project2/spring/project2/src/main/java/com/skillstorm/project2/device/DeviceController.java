package com.skillstorm.project2.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    //get all device
    @GetMapping("/device")
    public ResponseEntity<List<Device>> getDevices(){
        List<Device> devices = deviceService.findAll();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/device/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable(value = "id") int id){
        deviceService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //update : put
    @PutMapping("/device/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable int id, @RequestBody Device deviceDetail){
        Device device= deviceService.finById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Device not exit with ID:"+ id));
        device.setName(deviceDetail.getName());
        device.setNumber(deviceDetail.getNumber());
        device.setUserId(deviceDetail.getUserId());

        Device updateDevice = deviceService.save(device);
        return ResponseEntity.ok(updateDevice);
    }

    // create : post
    @PostMapping("/device")
    public Device createDevice(@RequestBody Device device){
        return  deviceService.save(device);
    }

    //find by ID
    @GetMapping("/device/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable int id){
        Device device = deviceService.finById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device is not exit with id : " + id));
        return ResponseEntity.ok(device);
    }

}
