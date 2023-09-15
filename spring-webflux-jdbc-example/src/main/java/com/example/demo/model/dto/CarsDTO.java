package com.example.demo.model.dto;

import com.example.demo.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
public class CarsDTO {
    private List<Car> data;
}
