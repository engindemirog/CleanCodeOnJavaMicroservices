package com.kodlamaio.inventory.business.abstracts;

import com.kodlamaio.inventory.business.dtos.requests.CreateBrandRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedBrandResponse;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
}
