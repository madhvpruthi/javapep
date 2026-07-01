package com.madhav.javawithh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.madhav.javawithh2.entity.employee;

public interface employeerepo extends JpaRepository<employee, Long> {

}