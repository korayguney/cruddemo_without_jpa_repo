package com.koray.cruddemo.rest;

import com.koray.cruddemo.dao.EmployeeDAO;
import com.koray.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable int id) {

        Employee employee = employeeDAO.findById(id);

        if (employee != null)
            return employee;
        else
            throw new IllegalArgumentException("The User with the ID : " + id + " is NOT exist!");
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmp){
        employeeDAO.save(theEmp);
        return theEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmp){
        employeeDAO.save(theEmp);
        return theEmp;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable int id) {
        employeeDAO.deleteById(id);
    }

}
