package com.example.demo.service.command;

import com.example.demo.model.dto.CarsDTO;
import com.example.demo.model.service.GetCarsRequest;
import com.example.demo.service.Command;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
public interface GetAllCarsCommand extends Command<CarsDTO, GetCarsRequest> {
}
