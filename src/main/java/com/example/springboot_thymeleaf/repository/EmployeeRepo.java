package com.example.springboot_thymeleaf.repository;

import com.example.springboot_thymeleaf.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDetails ,Integer> {

    public boolean existsByEmail(String email);

}
