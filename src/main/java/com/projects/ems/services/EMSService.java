package com.projects.ems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.ems.entity.Employee;
import com.projects.ems.repository.EMSRepository;

@Service
public class EMSService {
	
	@Autowired
	private EMSRepository repository;
	
	
	public Employee getEmpByID(Long id){
		
		Optional<Employee> emp = repository.findById(id);
		
		return emp.get();
	}
	
	public Employee addEmp(Employee emp) {
		Employee emp1 = repository.save(emp);
		return emp1;
	}
	
	public Employee updateEmp(Employee emp) {
		return emp;
	}
	
	public String deleteEmp(Long id) {
		repository.deleteById(id);
		return "Success";
	}
	
	
	
}
