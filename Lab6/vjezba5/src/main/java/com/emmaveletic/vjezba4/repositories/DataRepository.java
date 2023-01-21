package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DataRepository extends JpaRepository<Data, Long> {
}