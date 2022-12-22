package com.emmaveletic.vjezba4.controllers;

import com.emmaveletic.vjezba4.entities.Address;
import com.emmaveletic.vjezba4.entities.Client;
import com.emmaveletic.vjezba4.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/address")
@AllArgsConstructor
@RestController
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping()
    public Iterable<Address> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Address> postAdress(@RequestBody Address newAdress){
        if(!service.existsById(newAdress.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newAdress));
        }
        return ResponseEntity.status(HttpStatus.IM_USED).body(newAdress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@RequestBody Address adress,@PathVariable Long id){
        try{
            Optional<Address> temp = service.findById(id);
            adress.setId(id);
            service.save(adress);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}

