package com.kodlamaio.filter.business.concretes;

import com.kodlamaio.filter.business.abstracts.FilterService;
import com.kodlamaio.filter.entities.Inventory;
import com.kodlamaio.filter.repositories.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {
    private FilterRepository filterRepository;

    @Override
    public void add(Inventory inventory) {
         this.filterRepository.save(inventory);
    }
}
