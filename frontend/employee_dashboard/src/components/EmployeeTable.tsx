import { Employee } from '../types/Employee';
import { Table, TableHead, TableRow, TableCell, TableBody, Button } from '@mui/material';

type Props = {
  employees: Employee[];
  onEdit: (emp: Employee) => void;
  onDelete: (id: number) => void;
};

export default function EmployeeTable({ employees, onEdit, onDelete }: Props) {
  return (
    <Table>
      <TableHead>
        <TableRow>
          <TableCell>Name</TableCell>
          <TableCell>Email</TableCell>
          <TableCell>Mobile</TableCell>
          <TableCell>Designation</TableCell>
          <TableCell>Department</TableCell>
          <TableCell>Joined Date</TableCell>
          <TableCell>Actions</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {employees.map((emp) => (
          <TableRow key={emp.employeeId}>
            <TableCell>{emp.employeeFirstName} {emp.employeeLastName}</TableCell>
            <TableCell>{emp.employeeEmail}</TableCell>
            <TableCell>{emp.employeeMobileNumber}</TableCell>
            <TableCell>{emp.employeeDesignation}</TableCell>
            <TableCell>{emp.employeeDepartmentName}</TableCell>
            <TableCell>{emp.employeeJoinedDate}</TableCell>
            <TableCell>
              <Button onClick={() => onEdit(emp)}>Edit</Button>
              <Button color="error" onClick={() => emp.employeeId && onDelete(emp.employeeId)}>Delete</Button>
            </TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}
