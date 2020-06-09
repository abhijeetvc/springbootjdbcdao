package com.springjdbc.springbootjdbcdao.controller;

import com.springjdbc.springbootjdbcdao.dao.EmployeeDao;
import com.springjdbc.springbootjdbcdao.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping(value="/save1")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeDao.insertData(employee);
    }

    @GetMapping(value="/getallemp")
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    @GetMapping(value="/getemp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        Employee e=employeeDao.getEmployeeById(id);
        return e;
    }

    @PutMapping(value="/update/{id}/{name}")
    public String updateEmp(@PathVariable Integer id,
                            @PathVariable String name){
        return employeeDao.updateEmployee(id,name);
    }

    @GetMapping(value="/combinedata")
    public List<Map<String,Object>> getJoinData(){
        return employeeDao.getCombinedData();
    }

//    @PutMapping(value="/update")
//    public String updateEmp(@RequestBody Employee emp){
//        return employeeDao.updateEmployee(emp);
//    }
}
