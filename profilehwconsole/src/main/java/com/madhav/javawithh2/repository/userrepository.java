package com.madhav.javawithh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhav.javawithh2.entity.employee;

@Repository
public interface userrepository extends JpaRepository<employee,Long>{

}