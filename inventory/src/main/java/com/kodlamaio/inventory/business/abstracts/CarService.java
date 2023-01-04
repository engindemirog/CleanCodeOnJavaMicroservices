package com.kodlamaio.inventory.business.abstracts;

import com.kodlamaio.inventory.business.dtos.requests.CreateCarRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedCarResponse;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);
}
