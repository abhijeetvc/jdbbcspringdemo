package com.springjdbcprogram.jdbbcspringdemo.repository;

import com.springjdbcprogram.jdbbcspringdemo.model.Employee;

import java.util.List;
import java.util.Map;

public interface MyRepository {

    List<Employee> getList();

    Employee getEmployee(Integer id);

    String addEmp(Employee e);

    String updateEmp(Integer id,String name);

    List<Map<String,Object>> getCombbinedEmployeeData();
}
