package com.example.demo.config;

import com.example.demo.web.CarHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    @Value("${web.api.car-path}")
    private String carPath;

    @Value("${web.api.car-path-id}")
    private String carPathId;

    private final CarHandler carHandler;

    @Bean
    public WebProperties.Resources resources(){
        return new WebProperties.Resources();
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route()
                .GET(carPath, accept(MediaType.APPLICATION_JSON), carHandler::listCars)
                .GET(carPathId, accept(MediaType.APPLICATION_JSON), carHandler::getCarById)
                .POST(carPath, accept(MediaType.APPLICATION_JSON), carHandler::createCar)
                .build();
    }
}
