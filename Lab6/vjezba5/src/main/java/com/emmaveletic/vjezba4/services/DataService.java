package com.emmaveletic.vjezba4.services;

import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.entities.DataDTO;
import com.emmaveletic.vjezba4.repositories.DataRepository;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DataService {
    
	@Autowired
    private DataRepository repository;
	@Autowired
	private DeviceService deviceService;
    

   
    public Data findById(long id) {
        return repository.findById(id)
                .orElseGet(null);
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    public List<Data> findAll(Pageable page) {
        List<Data> data = new ArrayList<>();
        repository.findAll(page).toList().forEach(electricityData -> data.add(electricityData));
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
    
    public Data save(DataDTO dataDTO) {
        Data newData = new Data();
        newData.setDate(dataDTO.getDate());
        newData.setTime(dataDTO.getTime());
        newData.setValue(dataDTO.getValue());
        newData.setDevice(deviceService.findById(dataDTO.getDeviceId()));
        System.out.println(newData);
        return repository.save(newData);
    }
    
   


}

