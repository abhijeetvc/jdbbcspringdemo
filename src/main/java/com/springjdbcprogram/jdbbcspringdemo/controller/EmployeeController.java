package com.springjdbcprogram.jdbbcspringdemo.controller;

import com.springjdbcprogram.jdbbcspringdemo.dao.EmployeeDao;
import com.springjdbcprogram.jdbbcspringdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping(value="/addEmployee")
    public String addEmployee(@RequestBody Employee employee){

        String s=employeeDao.addEmp(employee);
        return s;
    }

    @PutMapping(value="/updateEmployee")
    public String updateEmployee(@RequestParam Integer id,
                                 @RequestParam String name){

        String s=employeeDao.updateEmp(id,name);
        return s;
    }

    @GetMapping(value="/joindata")
    public List<Map<String,Object>> getCombbinedData(){

        return employeeDao.getCombbinedEmployeeData();
    }
}
