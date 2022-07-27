package com.skillstorm.project2.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public List<Device> findAllByUser(int id){
        return deviceRepository.findAllByUserId(id);
    }


    public List<Device> findAll(){
        return deviceRepository.findAll();
    }

    public void deleteById(int id) {
        try{
            deviceRepository.deleteById(id);
        }catch (Exception e)
        {e.printStackTrace();}
    }

    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public Optional<Device> finById(int id){
        return deviceRepository.findById(id);
    }

}
