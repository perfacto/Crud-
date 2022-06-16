package com.Project.Task1.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Task1.model.Department;
import com.Project.Task1.service.DepartmentService;

@RestController
@RequestMapping("/department")

public class DepartmentController {

	@Autowired
	  DepartmentService departmentService;
	
	// Insert user record
	  @PostMapping("/save")
	  @ResponseStatus(HttpStatus.CREATED)
	  public Department addDepartment(@RequestBody Department department) {

	    return departmentService.addDepartment(department);
	    
	  }
	  // Fetch all user records
	  
	  @GetMapping("/")
	  public List<Department> getAllUsers(){
	    return departmentService.getAllDepartment();
	  }
	  
	  // Fetch single user
	  @GetMapping("/{id}")
	  public Department getUserById(@PathVariable("id") int userId){
	    return departmentService.getdepartmentById(userId);
	  }
	  
	  // Update user record
	  @PutMapping("/updateuser")
	  public ResponseEntity<String> updatedepartment(@RequestBody Department department) {  
	    try {
	      departmentService.updatedepartment(department);
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(NoSuchElementException ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	  }
	  // Delete user record
	  @DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable int id){
	    try {
	      departmentService.deletedepartmentById(id);
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(RuntimeException ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	  }

}
