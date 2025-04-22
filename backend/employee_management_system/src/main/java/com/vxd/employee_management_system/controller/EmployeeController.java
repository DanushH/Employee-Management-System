package com.vxd.employee_management_system.controller;

import com.vxd.employee_management_system.dto.EmployeeDTO;
import com.vxd.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        return employeeService.saveEmployee(dto);
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
