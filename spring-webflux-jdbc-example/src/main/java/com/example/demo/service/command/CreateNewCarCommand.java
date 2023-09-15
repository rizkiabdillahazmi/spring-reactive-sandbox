package com.example.demo.service.command;

import com.example.demo.model.dto.CarDTO;
import com.example.demo.model.service.CreateNewCarRequest;
import com.example.demo.service.Command;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
public interface CreateNewCarCommand extends Command<CarDTO, CreateNewCarRequest> {
}
