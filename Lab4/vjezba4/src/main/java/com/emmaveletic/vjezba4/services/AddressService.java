package com.emmaveletic.vjezba4.services;

import com.emmaveletic.vjezba4.entities.Address;
import com.emmaveletic.vjezba4.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public <S extends Address> S save(S entity) {
        return repository.save(entity);
    }

    public <S extends Address> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    public Optional<Address> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return repository.existsById(aLong);
    }

    public Iterable<Address> findAll() {
        return repository.findAll();
    }

    public Iterable<Address> findAllById(Iterable<Long> longs) {
        return repository.findAllById(longs);
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public void delete(Address entity) {
        repository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    public void deleteAll(Iterable<? extends Address> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
