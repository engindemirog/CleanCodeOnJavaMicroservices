package com.kodlamaio.inventory.api.controllers;

import com.kodlamaio.inventory.business.abstracts.BrandService;
import com.kodlamaio.inventory.business.dtos.requests.CreateBrandRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {
    private BrandService brandService;
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest request){
        return  this.brandService.add(request);
    }
}
