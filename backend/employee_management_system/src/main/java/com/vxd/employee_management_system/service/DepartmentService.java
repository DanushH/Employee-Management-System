package com.vxd.employee_management_system.service;

import com.vxd.employee_management_system.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO dto);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long id);

    DepartmentDTO updateDepartment(Long id, DepartmentDTO dto);

    void deleteDepartment(Long id);

}
