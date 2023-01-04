package com.kodlamaio.inventory.repositories;

import com.kodlamaio.inventory.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,String> {
    boolean existsByNameIgnoreCase(String name);
}
