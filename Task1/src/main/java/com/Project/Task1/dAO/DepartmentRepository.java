package com.Project.Task1.dAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Task1.model.Department;


@Repository

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}