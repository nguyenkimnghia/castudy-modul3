package com.codegym.controller;

import com.codegym.mapper.DepartmentMapper;
import com.codegym.mapper.EmployeeMapper;
import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.service.EmployeeService;
import com.codegym.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    EmployeeService employeeService;

//    @ModelAttribute("departments")
//    public Iterable<Department> departments() {
//        return departmentService.findAllDepartment();
//    }

    @GetMapping(value = "/home")
    public List<EmployeeMapper> listEmployee(){
        List<EmployeeMapper> employees = employeeService.findAll();
        System.out.println(employees);
        return employees;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeMapper employee, UriComponentsBuilder ucBuilder){
        employeeService.addEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @PostMapping( value = "/departmentbyid")
    public DepartmentMapper getDepartmentById(@RequestBody Long id) {
       DepartmentMapper departmentMapper = departmentService.findDepartmentById(id);
       return departmentMapper;
    }

    @GetMapping(value = "/departments")
    public List<DepartmentMapper> getListDepartment() {
        List<DepartmentMapper> departmentMappers = departmentService.findAllDepartment();
        return departmentMappers;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteCustomer(@PathVariable("id") long id) {

        Employee customer = employeeService.findById(id);
        if (customer == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {

        Employee employee1 = employeeService.findById(id);

        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employee1.setPhone(employee.getPhone());
        employee1.setDepartment(employee.getDepartment());

        employeeService.save(employee1);
        return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
    }

}
