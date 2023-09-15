package com.example.demo.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Getter
@Setter
public class CommandValidationException extends RuntimeException {
    private final transient Errors errors;
    public CommandValidationException(Errors errors) {
        this.errors = errors;
    }
}
