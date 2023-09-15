package com.example.demo.service;

import com.example.demo.model.service.ServiceRequest;
import com.example.demo.service.exception.CommandValidationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */

public abstract class AbstractCommand<T1, T2 extends ServiceRequest> implements Command<T1, T2>, ApplicationContextAware, InitializingBean {
    protected Validator validator;
    protected ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public final void afterPropertiesSet() {
        this.validator = applicationContext.getBean(Validator.class);
    }
    @Override
    public final Mono<T1> execute(Mono<T2> requestMono) {
        return requestMono.flatMap(request -> {
            Errors errors = new BeanPropertyBindingResult(request, "request");
            validator.validate(request, errors);
            if (!errors.hasErrors()) {
                return doExecute(request);
            } else {
                return Mono.error(new CommandValidationException(errors));
            }
        });
    }

    public abstract Mono<T1> doExecute(T2 request);
}
