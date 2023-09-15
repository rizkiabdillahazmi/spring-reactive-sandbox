package com.example.demo.service.command.impl;

import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.MapperUtil;
import com.example.demo.model.dto.CarDTO;
import com.example.demo.model.service.CreateNewCarRequest;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.AbstractCommand;
import com.example.demo.service.command.CreateNewCarCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Service
@RequiredArgsConstructor
public class CreateNewCarCommandImpl extends AbstractCommand<CarDTO, CreateNewCarRequest> implements CreateNewCarCommand {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public Mono<CarDTO> doExecute(CreateNewCarRequest request) {
        return Mono.fromCallable(() -> carRepository.save(carMapper.mapToCar(request)))
                .publishOn(Schedulers.boundedElastic())
                .map(MapperUtil.MAP_TO_CAR_DTO);
    }
}
