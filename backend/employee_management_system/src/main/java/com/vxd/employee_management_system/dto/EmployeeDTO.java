package com.vxd.employee_management_system.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeeMobileNumber;
    private String employeeDesignation;
    private String employeeDepartmentName;
    private LocalDate employeeJoinedDate;

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

    public String getEmployeeDepartmentName() {
        return employeeDepartmentName;
    }

    public void setEmployeeDepartmentName(String employeeDepartmentName) {
        this.employeeDepartmentName = employeeDepartmentName;
    }

    public LocalDate getEmployeeJoinedDate() {
        return employeeJoinedDate;
    }

    public void setEmployeeJoinedDate(LocalDate employeeJoinedDate) {
        this.employeeJoinedDate = employeeJoinedDate;
    }
}
