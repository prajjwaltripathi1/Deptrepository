package com.mindtree.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employee.VO.ResponseTemplate;
import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping 
	public Employee add(@RequestBody Employee emp)
	{
		return empService.add(emp);
	}
	
	@GetMapping 
	public List<Employee> listEmp()
	{
		return empService.list();
	}
    
	@GetMapping("/{empId}/{deptId}")
	public String updateDepartment(@PathVariable long empId,@PathVariable long deptId)
	{
		Employee emp = empService.assignDepartment(empId,deptId);
		if(emp!=null)
		{
			return emp.toString();
			
		}
		return "Sorry . DEpartment and Employee Not Found";
	}
	
	@GetMapping("/{empId}")
	public ResponseTemplate empWithDept(@PathVariable long empId)
	{
		return empService.empWithDept(empId);
	}
}
