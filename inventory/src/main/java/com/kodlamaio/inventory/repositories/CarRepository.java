package com.kodlamaio.inventory.repositories;

import com.kodlamaio.inventory.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,String> {
}
