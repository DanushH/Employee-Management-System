package com.vxd.employee_management_system.controller;

import com.vxd.employee_management_system.dto.DepartmentDTO;
import com.vxd.employee_management_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentDTO create(@RequestBody DepartmentDTO dto) {
        return departmentService.saveDepartment(dto);
    }

    @GetMapping
    public List<DepartmentDTO> getAll() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentDTO update(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
        return departmentService.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

}
