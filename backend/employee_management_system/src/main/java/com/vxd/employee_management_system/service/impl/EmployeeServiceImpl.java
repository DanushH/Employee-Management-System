package com.vxd.employee_management_system.service.impl;

import com.vxd.employee_management_system.dto.EmployeeDTO;
import com.vxd.employee_management_system.entity.Department;
import com.vxd.employee_management_system.entity.Employee;
import com.vxd.employee_management_system.repository.DepartmentRepository;
import com.vxd.employee_management_system.repository.EmployeeRepository;
import com.vxd.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Department department = departmentRepo.findByDepartmentNameIgnoreCase(dto.getEmployeeDepartmentName())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee employee = new Employee();

        employee.setEmployeeFirstName(dto.getEmployeeFirstName());
        employee.setEmployeeLastName(dto.getEmployeeLastName());
        employee.setEmployeeEmail(dto.getEmployeeEmail());
        employee.setEmployeeMobileNumber(dto.getEmployeeMobileNumber());
        employee.setEmployeeDesignation(dto.getEmployeeDesignation());
        employee.setEmployeeJoinedDate(dto.getEmployeeJoinedDate());
        employee.setEmployeeDepartment(department);

        Employee saved = employeeRepo.save(employee);

        dto.setEmployeeId(saved.getEmployeeId());
        return dto;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepo.findAll().stream().map(emp -> {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setEmployeeId(emp.getEmployeeId());
            dto.setEmployeeFirstName(emp.getEmployeeFirstName());
            dto.setEmployeeLastName(emp.getEmployeeLastName());
            dto.setEmployeeEmail(emp.getEmployeeEmail());
            dto.setEmployeeMobileNumber(emp.getEmployeeMobileNumber());
            dto.setEmployeeDesignation(emp.getEmployeeDesignation());
            dto.setEmployeeJoinedDate(emp.getEmployeeJoinedDate());
            if (emp.getEmployeeDepartment() != null) {
                dto.setEmployeeDepartmentName(emp.getEmployeeDepartment().getDepartmentName());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepo.findById(id).map(emp -> {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setEmployeeId(emp.getEmployeeId());
            dto.setEmployeeFirstName(emp.getEmployeeFirstName());
            dto.setEmployeeLastName(emp.getEmployeeLastName());
            dto.setEmployeeEmail(emp.getEmployeeEmail());
            dto.setEmployeeMobileNumber(emp.getEmployeeMobileNumber());
            dto.setEmployeeDesignation(emp.getEmployeeDesignation());
            dto.setEmployeeJoinedDate(emp.getEmployeeJoinedDate());
            if (emp.getEmployeeDepartment() != null) {
                dto.setEmployeeDepartmentName(emp.getEmployeeDepartment().getDepartmentName());
            }
            return dto;
        }).orElse(null);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        return employeeRepo.findById(id).map(emp -> {
            emp.setEmployeeFirstName(dto.getEmployeeFirstName());
            emp.setEmployeeLastName(dto.getEmployeeLastName());
            emp.setEmployeeEmail(dto.getEmployeeEmail());
            emp.setEmployeeMobileNumber(dto.getEmployeeMobileNumber());
            emp.setEmployeeDesignation(dto.getEmployeeDesignation());
            emp.setEmployeeJoinedDate(emp.getEmployeeJoinedDate());
            if (dto.getEmployeeDepartmentName() != null && !dto.getEmployeeDepartmentName().isEmpty()) {
                Department dept = departmentRepo.findByDepartmentNameIgnoreCase(dto.getEmployeeDepartmentName())
                        .orElseThrow(() -> new RuntimeException("Department not found"));
                emp.setEmployeeDepartment(dept);
            }

            Employee updated = employeeRepo.save(emp);
            dto.setEmployeeId(updated.getEmployeeId());
            return dto;
        }).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
