import { Employee } from '../types/Employee';
import { Department } from '../types/Department';
import { createDepartment } from '../services/departmentService';
import { useState } from 'react';
import {
  Button,
  TextField,
  Box,
  MenuItem,
  Select,
  InputLabel,
  FormControl,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle
} from '@mui/material';

type Props = {
  initialData: Employee;
  onSubmit: (emp: Employee) => void;
  onCancel: () => void;
  departments: Department[];
};

export default function EmployeeForm({ initialData, onSubmit, onCancel, departments }: Props) {
  const [formData, setFormData] = useState<Employee>(initialData);
  const [open, setOpen] = useState(false);
  const [newDepartment, setNewDepartment] = useState<Department>({
    departmentId: 0,
    departmentName: '',
    departmentHeadName: ''
  });
  const [localDepartments, setLocalDepartments] = useState<Department[]>(departments);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleNewDepartmentChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setNewDepartment({ ...newDepartment, [e.target.name]: e.target.value });
  };

  const handleAddDepartment = async () => {
    try {
      const res = await createDepartment(newDepartment);
      const added = res.data;
      setLocalDepartments((prev) => [...prev, added]);
      setFormData((prev) => ({ ...prev, employeeDepartmentName: added.departmentName }));
      setOpen(false);
      setNewDepartment({ departmentId: 0, departmentName: '', departmentHeadName: '' });
    } catch (error) {
      console.error("Error adding department:", error);
    }
  };

  return (
    <>
      <Box component="form" sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField name="employeeFirstName" label="First Name" value={formData.employeeFirstName} onChange={handleChange} required />
        <TextField name="employeeLastName" label="Last Name" value={formData.employeeLastName} onChange={handleChange} required />
        <TextField name="employeeEmail" label="Email" value={formData.employeeEmail} onChange={handleChange} required />
        <TextField name="employeeMobileNumber" label="Mobile Number" value={formData.employeeMobileNumber} onChange={handleChange} required />
        <TextField name="employeeDesignation" label="Designation" value={formData.employeeDesignation} onChange={handleChange} required />
        <FormControl fullWidth required>
          <InputLabel id="department-select-label">Department</InputLabel>
          <Select
            labelId="department-select-label"
            name="employeeDepartmentName"
            value={formData.employeeDepartmentName}
            onChange={(e) => setFormData({ ...formData, employeeDepartmentName: e.target.value })}
            label="Department"
          >
            {localDepartments.map((dept) => (
              <MenuItem key={dept.departmentId} value={dept.departmentName}>
                {dept.departmentName}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <TextField name="employeeJoinedDate" label="Joined Date" type="date" value={formData.employeeJoinedDate} onChange={handleChange} required />
        <Box display="flex" gap={2}>
          <Button type="button" onClick={() => onSubmit(formData)} variant="contained">Save</Button>
          <Button type="button" onClick={onCancel} color="secondary" variant="contained">Cancel</Button>
          <Button onClick={() => setOpen(true)} variant="outlined">+ Add Department</Button>

        </Box>
      </Box>

      <Dialog open={open} onClose={() => setOpen(false)}>
        <DialogTitle>Add New Department</DialogTitle>
        <DialogContent sx={{ display: 'flex', flexDirection: 'column', gap: 2, mt: 1 }}>
          <TextField
            name="departmentName"
            label="Department Name"
            value={newDepartment.departmentName}
            onChange={handleNewDepartmentChange}
            required
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setOpen(false)}>Cancel</Button>
          <Button onClick={handleAddDepartment} variant="contained">Add</Button>
        </DialogActions>
      </Dialog>
    </>
  );
}
