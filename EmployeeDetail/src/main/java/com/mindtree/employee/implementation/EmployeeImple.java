package com.mindtree.employee.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.employee.VO.Department;
import com.mindtree.employee.VO.ResponseTemplate;
import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.repository.EmployeeRepository;
import com.mindtree.employee.service.EmployeeService;

@Component
public class EmployeeImple implements EmployeeService{
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public Employee add(Employee emp) {
		// TODO Auto-generated method stub
		return (Employee) empRepo.save(emp);
	}
	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	@Override
	public Employee searchById(long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id);
	}
	@Override
	public ResponseTemplate empWithDept(long empId) {
		// TODO Auto-generated method stub
		com.mindtree.employee.VO.ResponseTemplate RT = new ResponseTemplate();
		Employee emp = empRepo.findById(empId);
		
		long dept_id= emp.getDept_id();
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +dept_id, Department.class);
		RT.setDepartment(dept);
		RT.setEmployee(emp);
		
		return RT;
	}
	@Override
	public Employee assignDepartment(long empId, long deptId) {
		// TODO Auto-generated method stub
		Employee emp = empRepo.findById(empId);
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +deptId, Department.class);
		if (emp==null || dept== null);
		{
			return null;
		}
	}
	@Override
	public List<Employee> getByDeptId(long dept_id) {
		// TODO Auto-generated method stub
		return empRepo.getByDeptId(dept_id);
	}
	@Override
	public List<Employee> getEmployeeByDepartmentWithDescAge(long dept_id) {
		// TODO Auto-generated method stub
		return empRepo.getEmployeeByDepartmentWithDescAge(dept_id);
	}
	

}
