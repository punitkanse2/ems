package com.projects.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.projects.ems.entity.Employee;
import com.projects.ems.services.EMSService;

@Controller
public class EMSController {

	@Autowired
	private EMSService emsService;
	
	@GetMapping
	public Employee getEmployeeById(Long id) {
		return emsService.getEmpByID(id);
	}
	
	@PostMapping
	public String addEmployee(Employee emp) {
		emsService.addEmp(emp);
		return "Success";
	}
	
	@PutMapping
	public String updateEmployee() {
		return "Success";
	}
	
	@DeleteMapping
	public String deleteEmployee(Long id) {
		emsService.deleteEmp(id);
		return "Success";
	}
	
}
