package com.mphasis.userApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.mphasis.userApplication.dAO.UserRepository;
import com.mphasis.userApplication.model.Department;
import com.mphasis.userApplication.model.ResponseTemplateVO;
import com.mphasis.userApplication.model.User;

@Repository
public class UserServicesImpl implements UserService {
	
	private String getDepartmentURI = "http://DEPARTMENT-SERVICE/department/";

	@Autowired
	  private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	  @Override
	  public User addUser(User user) {
	    return repository.save(user);
	  }
	  @Override
	  public User getUserById(int userId) {
	    return repository.findById(userId).get();
	  }
	  @Override
	  public List<User> getAllUsers(){
	    return repository.findAll();
	  }
	  
	  @Override
	  public void updateUser(User user) {
	    // check if the user with the passed id exists or not
	    User userDB = repository.findById(user.getUserId()).orElseThrow();
	    userDB.setFirstName("shubham");
	    // If user exists then updated
	    repository.save(user);
	  }
	  
	  @Override
	  public void deleteUserById(int userId) {
	    try {
	      repository.deleteById(userId);  
	    }catch(DataAccessException ex){
	      throw new RuntimeException(ex.getMessage());
	    }
	
}
	  public ResponseTemplateVO getEmployeeWithDepartment(int id) {
			// TODO Auto-generated method stub 
			ResponseTemplateVO responseTemplateVO = new	ResponseTemplateVO();
			Optional<User> emp = repository.findById(id);
			User user = emp.get();

			Department department = restTemplate.getForObject(getDepartmentURI + emp.get().getDepartmentId(),Department.class);

			responseTemplateVO.setUser(user);
			responseTemplateVO.setDepartment(department);

			return responseTemplateVO;
		}
}
	
