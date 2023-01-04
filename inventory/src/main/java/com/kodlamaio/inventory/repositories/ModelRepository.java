package com.kodlamaio.inventory.repositories;

import com.kodlamaio.inventory.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,String> {
    boolean existsByNameIgnoreCase(String name);
}
