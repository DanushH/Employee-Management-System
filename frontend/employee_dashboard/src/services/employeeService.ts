import axios from 'axios';
import { Employee } from '../types/Employee';

const BASE_URL = 'http://localhost:8080/api/employees';

export const getAllEmployees = () => axios.get<Employee[]>(BASE_URL);
export const getEmployeeById = (id: number) => axios.get<Employee>(`${BASE_URL}/${id}`);
export const createEmployee = (employee: Employee) => axios.post<Employee>(BASE_URL, employee);
export const updateEmployee = (id: number, employee: Employee) =>
    axios.put<Employee>(`${BASE_URL}/${id}`, employee);
export const deleteEmployee = (id: number) => axios.delete(`${BASE_URL}/${id}`);