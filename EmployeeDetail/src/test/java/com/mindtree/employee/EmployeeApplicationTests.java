package com.mindtree.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.repository.EmployeeRepository;

@SpringBootTest
class EmployeeApplicationTests {

	
	@Autowired
    private EmployeeRepository employeeRepo;
 
    @Test
    void isEmployeeExitsById() {
        Employee employee = new Employee( "Amiya",23000,"Male",23,2);
        employeeRepo.save(employee);
        Employee actualResult = employeeRepo.findById(1001);
        boolean isFound = false;
        if(actualResult !=null)
        	isFound=true;
        assertThat(isFound).isTrue();
    }

}
