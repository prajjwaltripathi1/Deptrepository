package com.mindtree.Department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Department.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findById(long id);
	

}
