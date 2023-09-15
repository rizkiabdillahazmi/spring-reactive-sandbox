package com.example.demo.service.command.impl;

import com.example.demo.mapper.MapperUtil;
import com.example.demo.model.dto.CarDTO;
import com.example.demo.model.service.CarByIdRequest;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.AbstractCommand;
import com.example.demo.service.command.GetCarByIdCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Rizki Abdillah Azmi on 15-Sep-23
 */
@Service
@RequiredArgsConstructor
public class GetCarByIdCommandImpl extends AbstractCommand<CarDTO, CarByIdRequest> implements GetCarByIdCommand {
    private final CarRepository carRepository;

    @Override
    public Mono<CarDTO> doExecute(CarByIdRequest request) {
        return Mono.fromSupplier(() -> carRepository.findById(Long.valueOf(request.getCarId()))
                        .map(MapperUtil.MAP_TO_CAR_DTO)
                        .orElse(null))
                .publishOn(Schedulers.boundedElastic());
    }
}
