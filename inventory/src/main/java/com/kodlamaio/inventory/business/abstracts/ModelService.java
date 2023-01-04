package com.kodlamaio.inventory.business.abstracts;

import com.kodlamaio.inventory.business.dtos.requests.CreateModelRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedModelResponse;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
}
