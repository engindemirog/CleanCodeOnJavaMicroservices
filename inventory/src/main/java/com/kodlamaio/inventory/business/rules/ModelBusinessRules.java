package com.kodlamaio.inventory.business.rules;

import com.kodlamaio.inventory.repositories.ModelRepository;
import com.kodlamaio.inventory.utils.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelNameExists(String name) {
        if (this.modelRepository.existsByNameIgnoreCase(name)){
            throw  new BusinessException("Model name exists");
        }
    }
}
