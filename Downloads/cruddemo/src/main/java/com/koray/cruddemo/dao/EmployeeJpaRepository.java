package com.koray.cruddemo.dao;

import com.koray.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
