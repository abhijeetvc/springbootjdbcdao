package com.springjdbc.springbootjdbcdao.dao;

import com.springjdbc.springbootjdbcdao.model.Employee;
import com.springjdbc.springbootjdbcdao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertData(Employee employee) {
        String sql="insert into employee values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),
        employee.getName(),employee.getCity(),employee.getDepartment().getId()});
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

    @Override
    public List<Map<String, Object>> getCombinedData() {

        String sql="select a.id,a.name,a.city,b.name as deptName from employee a, department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

//    @Override
//    public String updateEmployee(Employee emp) {
//        String sql="update employee set name=?, city=? where id=?";
//        jdbcTemplate.update(sql,new Object[]{emp.getName(),emp.getId()});
//        return "Employee updated successfully";
//
//    }

// If the department is not existing, then user will enter the new department name and the insert the
    // new employee against that department.

// Uploading of file along with employee data. STore file to some directory and add the file path
// to database against the employee
}
