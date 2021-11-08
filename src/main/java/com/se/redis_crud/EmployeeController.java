package com.se.redis_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee e) {
        employeeService.saveEmployee(e);
        return e;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}
