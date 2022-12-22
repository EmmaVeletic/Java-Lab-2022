package com.emmaveletic.vjezba4.services;

import com.emmaveletic.vjezba4.entities.Client;
import com.emmaveletic.vjezba4.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public <S extends Client> S save(S entity) {
        return repository.save(entity);
    }

    public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    public Optional<Client> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return repository.existsById(aLong);
    }

    public Iterable<Client> findAll() {
        return repository.findAll();
    }

    public Iterable<Client> findAllById(Iterable<Long> longs) {
        return repository.findAllById(longs);
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public void delete(Client entity) {
        repository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    public void deleteAll(Iterable<? extends Client> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

     public boolean existsAdress(Client newClient){
        return repository.existsAdress(newClient);
     }

    public boolean existsDevice(Client newClient){
        return repository.existsDevice(newClient);
    }
}

