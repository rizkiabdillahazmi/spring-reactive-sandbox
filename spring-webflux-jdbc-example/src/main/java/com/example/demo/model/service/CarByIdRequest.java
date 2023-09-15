package com.example.demo.model.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Rizki Abdillah Azmi on 15-Sep-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarByIdRequest implements ServiceRequest {
    @Positive
    @Min(1)
    private String carId;
}
