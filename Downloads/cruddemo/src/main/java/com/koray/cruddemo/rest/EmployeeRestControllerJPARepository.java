package com.koray.cruddemo.rest;

import com.koray.cruddemo.dao.EmployeeJpaRepository;
import com.koray.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jparepo")
public class EmployeeRestControllerJPARepository {

    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    public EmployeeRestControllerJPARepository(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeJpaRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findById(@PathVariable int id) {

        Optional<Employee> employee = employeeJpaRepository.findById(id);

        if (employee != null)
            return employee;
        else
            throw new IllegalArgumentException("The User with the ID : " + id + " is NOT exist!");
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmp){
        employeeJpaRepository.save(theEmp);
        return theEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmp){
        employeeJpaRepository.save(theEmp);
        return theEmp;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable int id) {
        employeeJpaRepository.deleteById(id);
    }


}
