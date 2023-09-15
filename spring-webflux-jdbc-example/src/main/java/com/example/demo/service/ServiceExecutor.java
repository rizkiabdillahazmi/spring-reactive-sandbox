package com.example.demo.service;

import com.example.demo.model.service.ServiceRequest;
import reactor.core.publisher.Mono;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
public interface ServiceExecutor {
    <T1, T2 extends ServiceRequest> Mono<T1> execute(Class<? extends Command<T1,T2>> commandClass, Mono<T2> requestMono);
}
