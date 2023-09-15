package com.example.demo.mapper;

import com.example.demo.entity.Car;
import com.example.demo.model.service.CreateNewCarRequest;
import org.springframework.stereotype.Component;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Component
public class CarMapper {
    public Car mapToCar(CreateNewCarRequest request) {
        if (request == null) {
            return null;
        }

        var car = Car.builder();
        car.type(request.getType());
        car.brand(request.getBrand());
        car.color(request.getColor());
        car.transmission(request.getTransmission());
        return car.build();
    }
}
