package com.springjdbc.springbootjdbcdao.repository;

import com.springjdbc.springbootjdbcdao.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    String insertData(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    String updateEmployee(Integer id,String name);

    //String updateEmployee(Employee emp);
}
