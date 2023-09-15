package com.example.demo.model.service;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
public class CreateNewCarRequest implements ServiceRequest {
    private Long id;
    @NotBlank
    private String color;
    @NotBlank
    private String brand;
    @NotBlank
    private String type;
    @NotBlank
    private String transmission;
}
