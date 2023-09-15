package com.example.demo.service.impl;

import com.example.demo.model.service.ServiceRequest;
import com.example.demo.service.Command;
import com.example.demo.service.ServiceExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Component
@RequiredArgsConstructor
public class ServiceExecutorImpl implements ServiceExecutor {

    private final ApplicationContext applicationContext;

    @Override
    public <T1, T2 extends ServiceRequest> Mono<T1> execute(Class<? extends Command<T1, T2>> commandClass, Mono<T2> requestMono) {
        Command<T1, T2> command = applicationContext.getBean(commandClass);
        return command.execute(requestMono);
    }
}
