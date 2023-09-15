package com.example.demo.repository;

import com.example.demo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
