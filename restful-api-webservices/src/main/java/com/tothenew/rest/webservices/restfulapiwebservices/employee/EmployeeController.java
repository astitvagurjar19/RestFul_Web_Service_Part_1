package com.tothenew.rest.webservices.restfulapiwebservices.employee;


import com.tothenew.rest.webservices.restfulapiwebservices.employee.exceptions.EmployeeNotFound;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    private Employees employees;

    public EmployeeController(Employees employees) {
        this.employees = employees;
    }

    //GET All the employee
    @GetMapping(path = "/employees")
    public List<EmployeeBean> findAllEmoloyees() {
        return employees.findAllEmployees();
    }

    //GET  employee by id
    @GetMapping(path = "/employees/{id}")
    public EmployeeBean findEmployeeById(@PathVariable int id) {
        EmployeeBean employeeBean = employees.findEmployee(id);
        if(employeeBean==null){
            throw new EmployeeNotFound("id: "+id);
        }
        return employees.findEmployee(id);
    }

    @DeleteMapping(path ="/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id){
        employees.deleteEmployeeById(id);
    }

    @PutMapping(path = "/employees")
    public void editEmployeeOrAdd(@RequestBody EmployeeBean employeeBean){
        employees.editEmployeeOrAdd(employeeBean);
    }

    //POST employee
    @PostMapping(path = "/employees")
    public void saveNewEmployee(@Valid @RequestBody EmployeeBean employeeBean) {
         employees.saveEmployee(employeeBean);
    }
}