package com.example.demo.model.dto;

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
public class CarDTO {
    private Long id;
    private String color;
    private String brand;
    private String type;
    private String transmission;
}
