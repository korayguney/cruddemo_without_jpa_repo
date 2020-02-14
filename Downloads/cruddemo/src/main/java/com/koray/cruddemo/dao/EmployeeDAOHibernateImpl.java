package com.koray.cruddemo.dao;

import com.koray.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository("employeeDAOHibernateImpl")
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        //Employee emp = session.get(Employee.class, id);
        Query<Employee> query = session.createQuery("from Employee where id=:theId", Employee.class);
        query.setParameter("theId",id);
        Employee emp = query.getSingleResult();
        return emp;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("delete from Employee where id=:empId");
        theQuery.setParameter("empId", id);
        theQuery.executeUpdate();
    }


}