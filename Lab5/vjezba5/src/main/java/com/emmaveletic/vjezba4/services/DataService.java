package com.emmaveletic.vjezba4.services;


import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    @Autowired
    private DataRepository repository;

    public Data save(Data entity) {
        return repository.save(entity);
    }

    public Data findById(long id) {
        return repository.findById(id)
                .orElseGet(null);
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    public List<Data> findAll() {
        List<Data> data = new ArrayList<>();
        repository.findAll()
                .forEach(electricityData -> data.add(electricityData));
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("no data found");
        }
    }

    public List<Data> findAllById(Iterable<Long> longs) {
        List<Data> data = new ArrayList<>();
        repository.findAll().
                forEach(electricityData -> data.add(electricityData));
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

    public void delete(Data entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }


}

