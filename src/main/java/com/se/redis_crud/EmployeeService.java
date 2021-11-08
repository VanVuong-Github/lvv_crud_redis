package com.se.redis_crud;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeService {
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;
    private final static String EMPLOYEE_KEY = "EMPLOYEE";

    public EmployeeService(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void saveEmployee(Employee employee){
        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);
    }
    public List<Employee> getAllEmployees() {
        return hashOperations.values(EMPLOYEE_KEY);
    }

    public Employee findEmployeeById(int id) {
        return (Employee)  hashOperations.get(EMPLOYEE_KEY, id);
    }

    public void updateEmployee(Employee employee) {
        saveEmployee(employee);
    }

    public void deleteEmployee(int id) {
        hashOperations.delete(EMPLOYEE_KEY, id);
    }
}
