package com.kodlamaio.inventory.business.concretes;

import com.kodlamaio.inventory.business.abstracts.ModelService;
import com.kodlamaio.inventory.business.dtos.requests.CreateModelRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedModelResponse;
import com.kodlamaio.inventory.business.rules.ModelBusinessRules;
import com.kodlamaio.inventory.entities.Brand;
import com.kodlamaio.inventory.entities.Model;
import com.kodlamaio.inventory.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelBusinessRules modelBusinessRules;
    private ModelRepository modelRepository;
    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());

        Model model = new Model();
        model.setId(UUID.randomUUID().toString());
        model.setName(createModelRequest.getName());

        Brand brand = new Brand();
        brand.setId(createModelRequest.getBrandId());

        model.setBrand(brand);

        Model createdModel = this.modelRepository.save(model);

        CreatedModelResponse response = new CreatedModelResponse();
        response.setId(createdModel.getId());
        response.setName(createdModel.getName());
        response.setBrandId(createdModel.getBrand().getId());
        return response;
    }
}
