package com.emmaveletic.vjezba4.repositories;

import com.emmaveletic.vjezba4.entities.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Long> {
}