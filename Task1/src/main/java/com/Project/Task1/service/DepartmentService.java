package com.Project.Task1.service;

import java.util.List;

import com.Project.Task1.model.Department;



public interface DepartmentService {
	Department addDepartment(Department department);
	Department getdepartmentById(int userId);
	  void updatedepartment(Department department);
	  void deletedepartmentById(int userId);
	 List<Department> getAllDepartment();
}
