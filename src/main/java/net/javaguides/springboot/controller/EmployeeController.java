package net.javaguides.springboot.controller;

import java.util.*;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository empr;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return empr.findAll();  //findAll() method returns all entities that are saved to the jpa database
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id)
    {
        Optional<Employee> obj = empr.findById(id);
        Employee emp=new Employee();
        if(obj.isPresent())
            emp =  obj.get();
        return emp;
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) //@RequestBody will convert json passed from postman to java type Employee
    {
        return empr.save(emp);
    }
    //  Throw POST request at Postman http://localhost:8080/api/v1/employees with body
    //  {
    //    "fName" : "Meenal",
    //    "lName" : "Gupta",
    //    "email" : "meenal@gmail.com"
    //}
}
