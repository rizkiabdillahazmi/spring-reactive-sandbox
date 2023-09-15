package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

/**
 * Created by Rizki Abdillah Azmi on 15-Sep-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

}
