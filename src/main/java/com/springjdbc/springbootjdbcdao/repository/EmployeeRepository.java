package com.springjdbc.springbootjdbcdao.repository;

import com.springjdbc.springbootjdbcdao.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    String insertData(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    String updateEmployee(Integer id,String name);

    //String updateEmployee(Employee emp);

    List<Map<String,Object>> getCombinedData();
}
