package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}