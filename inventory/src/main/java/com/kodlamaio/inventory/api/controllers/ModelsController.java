package com.kodlamaio.inventory.api.controllers;

import com.kodlamaio.inventory.business.abstracts.ModelService;
import com.kodlamaio.inventory.business.dtos.requests.CreateModelRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelsController {
    private ModelService modelService;
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        return  this.modelService.add(createModelRequest);
    }

}
