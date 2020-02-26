package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee(Long id, String name, int age, String phone, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String name, int age, String phone, Department department) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.department = department;
    }

}
