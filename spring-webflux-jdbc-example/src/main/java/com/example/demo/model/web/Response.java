package com.example.demo.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Jacksonized
public class Response<T> {
    private Integer code;
    private String status;
    private T data;
    private Object errors;

    // ------------------------ STATIC --------------------------- //
    public static <T> Response<T> ok(T data) {
        return Response.status(HttpStatus.OK, data);
    }

    public static <T> Response<T> notFound() {
        return Response.status(HttpStatus.NOT_FOUND, null);
    }

    public static <T> Response<T> okOrNotFound(@Nullable T data) {
        if (Objects.isNull(data)) {
            return Response.status(HttpStatus.NOT_FOUND, null);
        } else {
            return Response.ok(data);
        }
    }

    public static <T> Response<T> status(HttpStatus httpStatus, @Nullable T data) {
        return Response.<T>builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .data(data)
                .build();
    }
}
