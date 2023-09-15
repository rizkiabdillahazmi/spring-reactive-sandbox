package com.example.demo.repository;

import com.example.demo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rizki Abdillah Azmi on 13-Sep-23
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
