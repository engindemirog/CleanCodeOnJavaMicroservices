package com.kodlamaio.inventory.business.concretes;

import com.kodlamaio.common.events.inventories.InventoryCreatedEvent;
import com.kodlamaio.inventory.business.abstracts.CarService;
import com.kodlamaio.inventory.business.dtos.requests.CreateCarRequest;
import com.kodlamaio.inventory.business.dtos.responses.CreatedCarResponse;
import com.kodlamaio.inventory.entities.Car;
import com.kodlamaio.inventory.entities.Model;
import com.kodlamaio.inventory.kafka.producers.InventoryProducer;
import com.kodlamaio.inventory.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private InventoryProducer inventoryProducer;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        //business rules

        Car car = new Car();
        car.setDailyPrice(createCarRequest.getDailyPrice());
        car.setPlate(createCarRequest.getPlate());
        car.setState(1);
        car.setModelYear(createCarRequest.getModelYear());

        Model model = new Model();
        model.setId(createCarRequest.getModelId());
        car.setModel(model);

        car.setId(UUID.randomUUID().toString());

        Car createdCar = carRepository.save(car);

        CreatedCarResponse createdCarResponse = new CreatedCarResponse();
        createdCarResponse.setId(createdCar.getId());
        createdCarResponse.setState(createdCar.getState());
        createdCarResponse.setPlate(createdCar.getPlate());
        createdCarResponse.setModelYear(createdCar.getModelYear());
        createdCarResponse.setDailyPrice(createdCar.getDailyPrice());
        createdCarResponse.setModelId(createdCar.getModel().getId());

        createInventoryCreatedEvent(createdCar);

        return createdCarResponse;
    }

    private void createInventoryCreatedEvent(Car createdCar) {
        InventoryCreatedEvent inventoryCreatedEvent = new InventoryCreatedEvent();
        inventoryCreatedEvent.setCarId(createdCar.getId());
        inventoryCreatedEvent.setPlate(createdCar.getPlate());
        inventoryCreatedEvent.setState(createdCar.getState());
        inventoryCreatedEvent.setDailyPrice(createdCar.getDailyPrice());
        inventoryCreatedEvent.setModelYear(createdCar.getModelYear());
        inventoryCreatedEvent.setModelId(createdCar.getModel().getId());
        inventoryCreatedEvent.setBrandId(createdCar.getModel().getBrand().getId());
        inventoryCreatedEvent.setBrandName(createdCar.getModel().getBrand().getName());
        inventoryCreatedEvent.setModelName(createdCar.getModel().getName());

        this.inventoryProducer.sendMessage(inventoryCreatedEvent);
    }
}
