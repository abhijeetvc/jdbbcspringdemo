package com.springjdbcprogram.jdbbcspringdemo.controller;

import com.springjdbcprogram.jdbbcspringdemo.dao.EmployeeDao;
import com.springjdbcprogram.jdbbcspringdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/employee")
    public List<Employee> getEmployeeList(){
        return employeeDao.getList();
    }

    @GetMapping(value="/emp/{id}")
    public Employee getEmp(@PathVariable Integer id){

        return employeeDao.getEmployee(id);
    }

}
