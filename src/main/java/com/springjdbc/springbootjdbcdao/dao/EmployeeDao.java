package com.springjdbc.springbootjdbcdao.dao;

import com.springjdbc.springbootjdbcdao.model.Employee;
import com.springjdbc.springbootjdbcdao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
