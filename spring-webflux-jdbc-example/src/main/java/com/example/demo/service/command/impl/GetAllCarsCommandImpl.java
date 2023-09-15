package com.example.demo.service.command.impl;

import com.example.demo.mapper.MapperUtil;
import com.example.demo.model.dto.CarsDTO;
import com.example.demo.model.service.GetCarsRequest;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.AbstractCommand;
import com.example.demo.service.command.GetAllCarsCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Service
@RequiredArgsConstructor
public class GetAllCarsCommandImpl extends AbstractCommand<CarsDTO, GetCarsRequest> implements GetAllCarsCommand {

    private final CarRepository carRepository;

    @Override
    public Mono<CarsDTO> doExecute(GetCarsRequest request) {
        return Mono.fromCallable(carRepository::findAll)
                .map(MapperUtil.MAP_TO_CARS_DTO);
    }
}
