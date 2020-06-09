package com.springjdbc.springbootjdbcdao.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String name;
    private String city;

    private Department department;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
}
