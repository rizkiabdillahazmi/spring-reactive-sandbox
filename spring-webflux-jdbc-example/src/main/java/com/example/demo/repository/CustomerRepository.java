package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Rizki Abdillah Azmi on 15-Sep-23
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
