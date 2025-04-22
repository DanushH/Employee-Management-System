package com.vxd.employee_management_system.service.impl;

import com.vxd.employee_management_system.dto.DepartmentDTO;
import com.vxd.employee_management_system.entity.Department;
import com.vxd.employee_management_system.entity.Employee;
import com.vxd.employee_management_system.repository.DepartmentRepository;
import com.vxd.employee_management_system.repository.EmployeeRepository;
import com.vxd.employee_management_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO dto) {
        Department department = new Department();
        department.setDepartmentName(dto.getDepartmentName());

        if (dto.getDepartmentHeadName() != null) {
            Optional<Employee> headOpt = employeeRepo.findAll()
                    .stream()
                    .filter(emp -> emp.getEmployeeFirstName().equalsIgnoreCase(dto.getDepartmentHeadName()))
                    .findFirst();
            headOpt.ifPresent(department::setDepartmentHead);
        }

        Department saved = departmentRepo.save(department);

        dto.setDepartmentId(saved.getDepartmentId());
        return dto;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepo.findAll().stream().map(dept -> {
            DepartmentDTO dto = new DepartmentDTO();
            dto.setDepartmentId(dept.getDepartmentId());
            dto.setDepartmentName(dept.getDepartmentName());
            if (dept.getDepartmentHead() != null) {
                dto.setDepartmentHeadName(dept.getDepartmentHead().getEmployeeFirstName());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepo.findById(id).map(dept -> {
            DepartmentDTO dto = new DepartmentDTO();
            dto.setDepartmentId(dept.getDepartmentId());
            dto.setDepartmentName(dept.getDepartmentName());
            if (dept.getDepartmentHead() != null) {
                dto.setDepartmentHeadName(dept.getDepartmentHead().getEmployeeFirstName());
            }
            return dto;
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
        return departmentRepo.findById(id).map(dept -> {
            dept.setDepartmentName(dto.getDepartmentName());

            if (dto.getDepartmentHeadName() != null) {
                Optional<Employee> headOpt = employeeRepo.findAll()
                        .stream()
                        .filter(emp -> emp.getEmployeeFirstName().equalsIgnoreCase(dto.getDepartmentHeadName()))
                        .findFirst();
                headOpt.ifPresent(dept::setDepartmentHead);
            }

            Department updated = departmentRepo.save(dept);
            dto.setDepartmentId(updated.getDepartmentId());
            return dto;
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepo.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        departmentRepo.deleteById(id);
    }

}
