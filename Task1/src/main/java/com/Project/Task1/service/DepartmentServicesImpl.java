package com.Project.Task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.Project.Task1.dAO.DepartmentRepository;
import com.Project.Task1.model.Department;


@Service
public class DepartmentServicesImpl implements DepartmentService {
@Autowired
private DepartmentRepository repository;

@Override
public Department addDepartment(Department department) {
	// TODO Auto-generated method stub
	return repository.save(department);
}

@Override
public Department getdepartmentById(int departmentId) {
	// TODO Auto-generated method stub
	return repository.findById(departmentId).get();
}

@Override
public void updatedepartment(Department department) {
	// TODO Auto-generated method stub
	 Department departmentDB = repository.findById(department.getDepartmentId()).orElseThrow();
	 //findById(user.getUserId()).orElseThrow();
			 
	    // If user exists then updated
	    repository.save(department);
	
}

@Override
public void deletedepartmentById(int department_id) {
	// TODO Auto-generated method stub
	try {
	      repository.deleteById(department_id);  
	    }catch(DataAccessException ex){
	      throw new RuntimeException(ex.getMessage());
	    }
	
}

@Override
public List<Department> getAllDepartment() {
	// TODO Auto-generated method stub
	return repository.findAll();
}


	
	
	
	
	

}
