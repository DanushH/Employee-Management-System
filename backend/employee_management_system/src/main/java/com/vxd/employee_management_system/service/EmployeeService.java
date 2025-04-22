package com.vxd.employee_management_system.service;

import com.vxd.employee_management_system.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedDTO);

    void deleteEmployee(Long id);
}
