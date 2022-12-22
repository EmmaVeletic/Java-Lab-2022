package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {
}