package com.app.springboot_angular.Service;

import com.app.springboot_angular.Exeptions.ResourceNotFoundException;
import com.app.springboot_angular.Model.Employee;
import com.app.springboot_angular.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(long id) {
        Employee employeeFound =  employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found: " + id));

        return employeeFound;

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

	@Override
	public void deleteEmployee(Employee employee) {
		
		employeeRepository.delete(employee);
		
	}
}
