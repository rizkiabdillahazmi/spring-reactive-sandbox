package com.example.demo.web.exception;

import com.example.demo.service.exception.CommandValidationException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Rizki Abdillah Azmi on 14-Sep-23
 */
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        LinkedHashMap<String, Object> errorMap = new LinkedHashMap<>();
        Throwable error = getError(request);
        if (error instanceof CommandValidationException commandValidationException) {
            errorMap.putIfAbsent("message", commandValidationException.getErrors()
                    .getFieldErrors()
                    .stream()
                    .sorted(Comparator.comparing(FieldError::getField))
                    .collect(Collectors.groupingBy(FieldError::getField,
                            LinkedHashMap::new,
                            Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList()))));
        } else {
            errorMap.put("timestamp", new Date());
            errorMap.put("path", request.path());
            errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorMap.put("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            errorMap.put("requestId", request.exchange().getRequest().getId());
            errorMap.put("message ", "please contact dev!");
        }
        return errorMap;
    }
}
