package com.example.demo.web;

import com.example.demo.model.service.CreateNewCarRequest;
import com.example.demo.model.service.CarByIdRequest;
import com.example.demo.model.service.GetCarsRequest;
import com.example.demo.model.web.Response;
import com.example.demo.service.ServiceExecutor;
import com.example.demo.service.command.CreateNewCarCommand;
import com.example.demo.service.command.GetAllCarsCommand;
import com.example.demo.service.command.GetCarByIdCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Map;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */

@Component
@RequiredArgsConstructor
public class CarHandler {

    private final ServiceExecutor serviceExecutor;

    public Mono<ServerResponse> createCar(ServerRequest serverRequest) {
        Mono<CreateNewCarRequest> requestMono = serverRequest.bodyToMono(CreateNewCarRequest.class);

        var response = serviceExecutor.execute(CreateNewCarCommand.class, requestMono)
                .map(Response::ok)
                .subscribeOn(Schedulers.boundedElastic());

        return ServerResponse.ok().body(response, Response.class);
    }

    public Mono<ServerResponse> listCars(ServerRequest serverRequest) {
        Map<String, String> queryParams = serverRequest.queryParams().toSingleValueMap();
        String page = queryParams.getOrDefault("page", "1").replaceAll("\\D", "");
        String pageSize = queryParams.getOrDefault("pageSize", "50").replaceAll("\\D", "");

        var serviceRequest = GetCarsRequest.builder()
                .page(Integer.parseInt(page.isBlank() ? "0" : page))
                .pageSize(Integer.parseInt(pageSize.isBlank() ? "0" : pageSize))
                .build();

        var response = serviceExecutor.execute(GetAllCarsCommand.class, Mono.just(serviceRequest))
                .flatMap(carsDTO -> Mono.just(carsDTO.getData()))
                .map(Response::ok)
                .subscribeOn(Schedulers.boundedElastic());

        return ServerResponse.ok().body(response, Response.class);
    }

    public Mono<ServerResponse> getCarById(ServerRequest serverRequest) {
        var serviceRequest = CarByIdRequest.builder()
                .carId(serverRequest.pathVariable("carId"))
                .build();

        var response = serviceExecutor.execute(GetCarByIdCommand.class, Mono.just(serviceRequest))
                .map(Response::ok)
                .defaultIfEmpty(Response.notFound())
                .subscribeOn(Schedulers.boundedElastic());

        return ServerResponse.ok().body(response, Response.class);
    }
}
