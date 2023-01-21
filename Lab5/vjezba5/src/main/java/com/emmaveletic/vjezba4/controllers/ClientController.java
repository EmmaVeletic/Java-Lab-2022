package com.emmaveletic.vjezba4.controllers;

import com.emmaveletic.vjezba4.entities.Client;
import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/client")
@RestController
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping()
    public List<Client> getAll(Pageable page){
        return service.findAll(page);
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping()//provjera postoj li taj id, ima li pripadni entitet
    public ResponseEntity<Client> postClient(@RequestBody Client newClient, Pageable page){
        if(service.existsById(newClient.getId())) {
            return new ResponseEntity(HttpStatus.IM_USED);
        }
        List<Client> clientList = (List<Client>) service.findAll(page);
        for(int i=0;i<clientList.size();i++){
            if(!service.existsAddress(newClient)){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            if(!service.existsDevice(newClient)){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        service.save(newClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client,@PathVariable Long id){
        try{
            Client temp = service.findById(id);
            client.setId(id);
            service.save(client);
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

