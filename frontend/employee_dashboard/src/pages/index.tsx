import { useEffect, useState } from 'react';
import { Employee } from '../types/Employee';
import { Department } from '../types/Department';
import * as service from '../services/employeeService';
import * as departmentService from '../services/departmentService';
import EmployeeTable from '../components/EmployeeTable';
import EmployeeForm from '../components/EmployeeForm';
import { Box, Button, Container, Typography } from '@mui/material';

export default function Home() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [editing, setEditing] = useState<Employee | null>(null);
  const [showForm, setShowForm] = useState(false);
  const [departments, setDepartments] = useState<Department[]>([]);

  const loadDepartments = async () => {
    const res = await departmentService.getAllDepartments();
    setDepartments(res.data);
  };

  const loadEmployees = async () => {
    const res = await service.getAllEmployees();
    setEmployees(res.data);
  };

  useEffect(() => {
    loadEmployees();
    loadDepartments();
  }, []);

  const handleSave = async (emp: Employee) => {
    if (emp.employeeId) {
      await service.updateEmployee(emp.employeeId, emp);
    } else {
      await service.createEmployee(emp);
    }
    setShowForm(false);
    setEditing(null);
    loadEmployees();
  };

  const handleDelete = async (id: number) => {
    await service.deleteEmployee(id);
    loadEmployees();
  };

  const handleEdit = (emp: Employee) => {
    setEditing(emp);
    setShowForm(true);
  };

  const handleCreate = () => {
    setEditing({
      employeeFirstName: '',
      employeeLastName: '',
      employeeEmail: '',
      employeeMobileNumber: '',
      employeeDesignation: '',
      employeeDepartmentName: '',
      employeeJoinedDate: new Date().toISOString().slice(0, 10),
    });
    setShowForm(true);
  };

  return (
    <Container sx={{ mt: 4 }}>
      <Box display="flex" justifyContent={'center'} alignItems={'center'}>
        <Typography variant="h4" gutterBottom>Employee Dashboard</Typography>
      </Box>
      {!showForm && <Button variant="contained" onClick={handleCreate}>Add New Employee</Button>}
      {showForm && editing && (
        <EmployeeForm
          initialData={editing}
          onSubmit={handleSave}
          onCancel={() => setShowForm(false)}
          departments={departments}
        />
      )}
      {!showForm && (
        <EmployeeTable employees={employees} onEdit={handleEdit} onDelete={handleDelete} />
      )}

    </Container>
  );
}
