package com.vxd.employee_management_system.repository;

import com.vxd.employee_management_system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);
}
