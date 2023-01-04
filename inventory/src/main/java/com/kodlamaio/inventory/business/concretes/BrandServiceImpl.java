package com.kodlamaio.inventory.business.concretes;

import com.kodlamaio.common.events.inventories.BrandCreatedEvent;
import com.kodlamaio.inventory.business.abstracts.BrandService;
import com.kodlamaio.inventory.business.dtos.requests.CreateBrandRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedBrandResponse;
import com.kodlamaio.inventory.business.rules.BrandBusinessRules;
import com.kodlamaio.inventory.entities.Brand;
import com.kodlamaio.inventory.kafka.producers.InventoryProducer;
import com.kodlamaio.inventory.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;
    private InventoryProducer inventoryProducer;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setId(UUID.randomUUID().toString());

        Brand createdBrand =  brandRepository.save(brand);

        CreatedBrandResponse response = new CreatedBrandResponse();
        response.setId(createdBrand.getId());
        response.setName(createdBrand.getName());


        BrandCreatedEvent brandCreatedEvent = new BrandCreatedEvent();
        brandCreatedEvent.setId(response.getId());
        brandCreatedEvent.setName(response.getName());
        inventoryProducer.sendMessage(brandCreatedEvent);

        return response;
    }
}