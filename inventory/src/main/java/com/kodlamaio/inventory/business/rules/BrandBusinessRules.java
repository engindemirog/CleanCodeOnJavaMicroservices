package com.kodlamaio.inventory.business.rules;


import com.kodlamaio.inventory.business.dtos.requests.CreateBrandRequest;
import com.kodlamaio.inventory.repositories.BrandRepository;
import com.kodlamaio.inventory.utils.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByNameIgnoreCase(name)){
            throw  new BusinessException("Brand name exists");
        }
    }

}
