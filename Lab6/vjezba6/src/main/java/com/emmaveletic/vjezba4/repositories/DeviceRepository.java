package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Device;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceRepository extends JpaRepository<Device, Long> {
}