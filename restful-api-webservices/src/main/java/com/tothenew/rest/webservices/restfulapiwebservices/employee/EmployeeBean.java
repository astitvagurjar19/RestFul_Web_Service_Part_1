package com.tothenew.rest.webservices.restfulapiwebservices.employee;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class EmployeeBean {
    private int id;
    @Size(min = 2)
    private String name;
   @Min(value = 18)
   @Max(value = 60)
    private int age;

    public EmployeeBean(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Employees [Id: "+id+", Name:"+name+", Age: "+age+"]";
    }
}
