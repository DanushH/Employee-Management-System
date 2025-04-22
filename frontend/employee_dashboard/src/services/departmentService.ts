import axios from "axios";
import { Department } from "../types/Department";

const API = 'http://localhost:8080/api/departments';

export const createDepartment = (department: Department) =>
    axios.post<Department>('http://localhost:8080/api/departments', department);
export const getAllDepartments = () => axios.get<Department[]>(API);
