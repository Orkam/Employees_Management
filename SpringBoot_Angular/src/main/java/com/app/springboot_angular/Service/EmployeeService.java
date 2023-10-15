package com.app.springboot_angular.Service;


import com.app.springboot_angular.Model.Employee;

import java.util.List;

public interface EmployeeService {

   List<Employee> listAllEmployees();

   Employee saveEmployee(Employee employee);

   Employee findEmployeeById(long id);

   Employee updateEmployee(Employee employee);
   
   void deleteEmployee(Employee employee);
}
