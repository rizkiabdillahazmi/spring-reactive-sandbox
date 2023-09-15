package com.example.demo.service.command;

import com.example.demo.model.dto.CarDTO;
import com.example.demo.model.service.CarByIdRequest;
import com.example.demo.service.Command;

/**
 * Created by Rizki Abdillah Azmi on 15-Sep-23
 */
public interface GetCarByIdCommand extends Command<CarDTO, CarByIdRequest> {
}
