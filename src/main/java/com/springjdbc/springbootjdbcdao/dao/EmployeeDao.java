package com.springjdbc.springbootjdbcdao.dao;

import com.springjdbc.springbootjdbcdao.model.Employee;
import com.springjdbc.springbootjdbcdao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertData(Employee employee) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),
        employee.getName(),employee.getCity()});
        return "Data inserted successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {

        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        String sql="select * from employee where id=?";
        Employee emp= (Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }

    @Override
    public String updateEmployee(Integer id, String name) {
        String sql="update employee set name=? where id=?";
        jdbcTemplate.update(sql,new Object[]{name,id});
        return "Employee updated successfully";
    }

//    @Override
//    public String updateEmployee(Employee emp) {
//        String sql="update employee set name=?, city=? where id=?";
//        jdbcTemplate.update(sql,new Object[]{emp.getName(),emp.getId()});
//        return "Employee updated successfully";
//
//    }

}
