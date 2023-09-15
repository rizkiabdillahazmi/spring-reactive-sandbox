package com.example.demo.model.service;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCarsRequest implements ServiceRequest {
    @Positive
    private int page;
    @Positive
    private int pageSize;
}
