package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}