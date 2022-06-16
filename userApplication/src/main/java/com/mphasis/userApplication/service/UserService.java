package com.mphasis.userApplication.service;

import java.util.List;

import com.mphasis.userApplication.model.ResponseTemplateVO;
import com.mphasis.userApplication.model.User;

public interface UserService {
	User addUser(User user);

	User getUserById(int userId);

	void updateUser(User user);

	void deleteUserById(int userId);

	List<User> getAllUsers();

	ResponseTemplateVO getEmployeeWithDepartment(int id);

}
