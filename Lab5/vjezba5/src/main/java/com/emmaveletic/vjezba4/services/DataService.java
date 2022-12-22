package com.emmaveletic.vjezba4.services;


import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DataService {
    @Autowired
    private DataRepository repository;

    public <S extends Data> S save(S entity) {
        return repository.save(entity);
    }

    public <S extends Data> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    public Optional<Data> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return repository.existsById(aLong);
    }

    public Iterable<Data> findAll() {
        return repository.findAll();
    }

    public Iterable<Data> findAllById(Iterable<Long> longs) {
        return repository.findAllById(longs);
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public void delete(Data entity) {
        repository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    public void deleteAll(Iterable<? extends Data> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}

