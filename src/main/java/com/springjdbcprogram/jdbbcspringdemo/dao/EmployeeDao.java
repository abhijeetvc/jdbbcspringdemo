package com.springjdbcprogram.jdbbcspringdemo.dao;

import com.springjdbcprogram.jdbbcspringdemo.model.Employee;
import com.springjdbcprogram.jdbbcspringdemo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDao implements MyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getList() {

        String sql="select id as empId,emp_name as empName from employee";
        List<Employee> list=jdbcTemplate.
                query(sql,new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployee(Integer id) {

        String sql="select * from employee where id=?";
        Employee emp= (Employee) jdbcTemplate
                .queryForObject(sql,
                new Object[]{id},
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }
}
