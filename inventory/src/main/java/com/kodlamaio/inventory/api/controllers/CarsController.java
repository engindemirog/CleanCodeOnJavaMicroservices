package com.kodlamaio.inventory.api.controllers;

import com.kodlamaio.inventory.business.abstracts.CarService;
import com.kodlamaio.inventory.business.dtos.requests.CreateBrandRequest;
import com.kodlamaio.inventory.business.dtos.requests.CreateCarRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedBrandResponse;
import com.kodlamaio.inventory.business.dtos.responses.CreatedCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarsController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return  this.carService.add(createCarRequest);
    }
}
