package com.kodlamaio.filter.repositories;

import com.kodlamaio.filter.entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilterRepository extends MongoRepository<Inventory,String> {
}
