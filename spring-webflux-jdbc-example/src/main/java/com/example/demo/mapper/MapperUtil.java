package com.example.demo.mapper;

import com.example.demo.entity.Car;
import com.example.demo.model.dto.CarDTO;
import com.example.demo.model.dto.CarsDTO;
import com.example.demo.model.service.CreateNewCarRequest;

import java.util.List;
import java.util.function.Function;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
public class MapperUtil {
    private MapperUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static final Function<CreateNewCarRequest, Car> MAP_TO_CAR = data -> Car.builder()
            .id(data.getId())
            .brand(data.getBrand())
            .type(data.getType())
            .color(data.getColor())
            .transmission(data.getTransmission())
            .build();

    public static final Function<Car, CarDTO> MAP_TO_CAR_DTO = data -> CarDTO.builder()
            .id(data.getId())
            .brand(data.getBrand())
            .type(data.getType())
            .color(data.getColor())
            .transmission(data.getTransmission())
            .build();

    public static final Function<List<Car>, List<CarDTO>> MAP_TO_CAR_LIST_DTO = data -> data.stream()
            .map(MAP_TO_CAR_DTO)
            .toList();

    public static final Function<List<Car>, CarsDTO> MAP_TO_CARS_DTO = data -> CarsDTO.builder().data(data).build();
}
