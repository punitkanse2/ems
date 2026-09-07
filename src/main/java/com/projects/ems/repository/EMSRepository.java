package com.projects.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.ems.entity.Employee;

@Repository
public interface EMSRepository extends JpaRepository<Employee, Long> {
	
}
