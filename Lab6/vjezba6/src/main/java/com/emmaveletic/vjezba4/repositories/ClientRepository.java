package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.Null;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
    default boolean existsAdress(Client newClient) {
       return (newClient.getAdress()==null);
    }

    default boolean existsDevice(Client newClient) {
        return (newClient.getDevices().isEmpty() || newClient.getDevices()==null);
    }
    
    default boolean existsAddress(Client newClient) {
        return (newClient.getAdress().equals(null) || newClient.getDevices()==null);
    }
}