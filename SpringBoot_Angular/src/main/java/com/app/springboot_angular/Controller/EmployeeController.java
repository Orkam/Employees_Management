/**
 * @author Gustavo Guevara
 */
package com.app.springboot_angular.Controller;

import com.app.springboot_angular.Model.Employee;
import com.app.springboot_angular.Service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> listAllEmployees() {
        return employeeService.listAllEmployees();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable long id) {

        Employee employeeFound = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employeeFound);

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeNewDetails) {
        Employee employeeFound = employeeService.findEmployeeById(id);

        BeanUtils.copyProperties(employeeNewDetails,employeeFound);
        Employee employeeUpdated = employeeService.updateEmployee(employeeFound);
        return ResponseEntity.ok(employeeUpdated);


    }
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deteleteEmployee(@PathVariable Long id){
    	
    Employee employee=	 employeeService.findEmployeeById(id);
    
    employeeService.deleteEmployee(employee);
    
    return ResponseEntity.ok(employee);
    
    }
}
