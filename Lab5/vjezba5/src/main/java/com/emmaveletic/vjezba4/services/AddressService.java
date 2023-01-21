package com.emmaveletic.vjezba4.services;

import com.emmaveletic.vjezba4.entities.Address;
import com.emmaveletic.vjezba4.repositories.AddressRepository;

import exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public Address save(Address address) {
        return repository.save(address);
    }

    public Address findById(long id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException("Address not found for the id :" + id));
               
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

   
    public List<Address> findAll(Pageable page) {
        List<Address> data = new ArrayList<>();
         repository.findAll(page).toList().forEach(address -> data.add(address));
        if (data != null) {
            return data;
        } else {
            throw new RecordNotFoundException("Cant found addresses");
        }
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void delete(Address address) {
        repository.delete(address);
    }

}
