package com.springjdbcprogram.jdbbcspringdemo.dao;

import com.springjdbcprogram.jdbbcspringdemo.model.Employee;
import com.springjdbcprogram.jdbbcspringdemo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


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

    @Override
    public String addEmp(Employee e) {
        String sql="insert into employee values (?,?,?)";
        jdbcTemplate.update(sql,new Object[]{e.getId(),e.getName(),e.getCity()});
        return "Data Inserted";
    }

    @Override
    public String updateEmp(Integer id, String name) {
        String sql="update employee set name=? where id=?";
        jdbcTemplate.update(sql,new Object[]{name,id});
        return "Employee Updated";
    }

    @Override
    public List<Map<String, Object>> getCombbinedEmployeeData() {
        String sql=
                "select a.id,a.name as empName,a.city,b.name as deptName from employee a, " +
                        "department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
