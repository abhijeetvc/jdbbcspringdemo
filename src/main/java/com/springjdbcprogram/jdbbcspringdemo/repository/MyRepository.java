package com.springjdbcprogram.jdbbcspringdemo.repository;

import com.springjdbcprogram.jdbbcspringdemo.model.Employee;

import java.util.List;

public interface MyRepository {

    List<Employee> getList();

    Employee getEmployee(Integer id);
}
