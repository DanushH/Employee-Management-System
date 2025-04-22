package com.vxd.employee_management_system.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeeMobileNumber;
    private String employeeDesignation;

    @ManyToOne
    @JoinColumn(name = "employeeDepartment", referencedColumnName = "departmentId")
    private Department employeeDepartment;

    private LocalDate employeeJoinedDate;

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeMobileNumber() {
        return employeeMobileNumber;
    }

    public void setEmployeeMobileNumber(String employeeMobileNumber) {
        this.employeeMobileNumber = employeeMobileNumber;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public LocalDate getEmployeeJoinedDate() {
        return employeeJoinedDate;
    }

    public void setEmployeeJoinedDate(LocalDate employeeJoinedDate) {
        this.employeeJoinedDate = employeeJoinedDate;
    }
}
