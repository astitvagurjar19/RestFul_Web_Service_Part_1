package com.tothenew.rest.webservices.restfulapiwebservices.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Component
public class Employees {
    private static List<EmployeeBean> employeeBeanList = new ArrayList<>();
    private static int employeeCounter=0;

    static {
        employeeBeanList.add(new EmployeeBean(++employeeCounter, "Sam", 30));
        employeeBeanList.add(new EmployeeBean(++employeeCounter, "Tom", 26));
        employeeBeanList.add(new EmployeeBean(++employeeCounter, "Denial", 32));
        employeeBeanList.add(new EmployeeBean(++employeeCounter, "Joy", 32));
    }


    public List<EmployeeBean> findAllEmployees(){
        return employeeBeanList;
    }

    public EmployeeBean findEmployee(int id){
        Predicate<? super EmployeeBean> predicate = employeeBean -> Objects.equals(employeeBean.getId(), id);
        return employeeBeanList.stream().filter(predicate).findFirst().orElse(null);
    }

    public EmployeeBean saveEmployee(EmployeeBean employeeBean){
        employeeBean.setId(++employeeCounter);
        employeeBeanList.add(employeeBean);
        return employeeBean;
    }

    public void editEmployeeOrAdd(EmployeeBean employeeBean){
        boolean employeeFound=false;
        for(EmployeeBean currentEmployee: employeeBeanList){
            if(currentEmployee.getId()==employeeBean.getId()){
                employeeFound=true;
                currentEmployee.setName(employeeBean.getName());
                currentEmployee.setAge(employeeBean.getAge());
            }
        }
        if (!employeeFound){
            employeeBean.setId(++employeeCounter);
            employeeBeanList.add(employeeBean);
        }
    }

    public void deleteEmployeeById(int id){
        Predicate<? super EmployeeBean> predicate = employeeBean -> Objects.equals(employeeBean.getId(),id);
        employeeBeanList.removeIf(predicate);
    }

}
