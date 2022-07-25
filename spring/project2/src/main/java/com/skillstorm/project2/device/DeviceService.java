package com.skillstorm.project2.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepo;

    public List<Device> findAllByUser(int id){
        return deviceRepo.findAllByUserId(id);
    }

}
