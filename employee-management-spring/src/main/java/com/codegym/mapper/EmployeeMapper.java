package com.codegym.mapper;

public class EmployeeMapper {
    private Long id;
    private String name;
    private int age;
    private String phone;
    private Long idDepartment;

    public EmployeeMapper(Long id, String name, int age, String phone, Long idDepartment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.idDepartment = idDepartment;
    }

    public EmployeeMapper(String name, int age, String phone, Long idDepartment) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.idDepartment = idDepartment;
    }

    public EmployeeMapper() {
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

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }
}
