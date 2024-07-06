package com.example.employeeportal.service;

import com.example.employeeportal.model.Employee;
import com.example.employeeportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == null || employee.getId().isEmpty()) {
            employee.setId(null);
        }
        return repository.save(employee);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}
