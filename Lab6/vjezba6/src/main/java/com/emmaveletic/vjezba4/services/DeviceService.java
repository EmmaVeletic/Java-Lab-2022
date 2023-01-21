package com.emmaveletic.vjezba4.services;

import com.emmaveletic.vjezba4.entities.Device;
import com.emmaveletic.vjezba4.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    public Device save(Device device) {
        return repository.save(device);
    }

    public Device findById(long id) {
        return repository.findById(id)
                .orElseGet(null);
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    public List<Device> findAll(Pageable page) {
        List<Device> data = new ArrayList<>();
        repository.findAll(page).toList().forEach(device -> data.add(device));
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("no data found");
        }
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void delete(Device entity) {
        repository.delete(entity);
    }
}

