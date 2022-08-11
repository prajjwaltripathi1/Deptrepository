package com.mindtree.Department.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Department.Entity.Department;
import com.mindtree.Department.VO.RequestTemplate;


@Service
public interface DepartmentService {
	Department add(Department dept);
	List<Department> list();
	Department update(long id, String name);
	Department searchById(long id);
	List<RequestTemplate> listwithEmp();
	RequestTemplate specificDeptEmployee(long dept_id);
	

}
