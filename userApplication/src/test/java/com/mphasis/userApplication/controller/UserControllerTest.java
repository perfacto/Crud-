package com.mphasis.userApplication.controller;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mphasis.userApplication.model.Department;
import com.mphasis.userApplication.model.ResponseTemplateVO;
import com.mphasis.userApplication.model.User;
import com.mphasis.userApplication.service.UserService;



public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;
	
    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void testAddEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         User user=new User();
         user.setDepartmentId(121);
         user.setFirstName("xyz");
         user.setLastName("abc");
         user.setStartDate(null);
         user.setUserId(112);
         user.setUserType("silver");
        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(user);
        		
        User responseEntity =userController.addEmployee(user);
        	
        assertThat(responseEntity.getUserId()).isEqualTo(112);
        
    }
     
    @Test
    public void testFindAll() 
    {
    	
         List<User> user= new ArrayList<User>();
         User user1=new User();
         user1.setDepartmentId(121);
         user1.setFirstName("xyz");
         user1.setLastName("abc");
         user1.setStartDate(null);
         user1.setUserId(112);
         user1.setUserType("silver");
         
         User user2=new User();
         user2.setDepartmentId(131);
         user2.setFirstName("xyzk");
         user2.setLastName("abck");
         user2.setStartDate(null);
         user2.setUserId(1121);
         user2.setUserType("silver");
         user.add(user2);
         user.add(user1);
 
      Mockito.when(userService.getAllUsers()).thenReturn(user);
      
     List<User> userRes = userController.getAllUsers();
     assertThat(userRes.size()).isEqualTo(2);
         
    }
	
	@Test
    public void testGetUserById() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         User user=new User();
         user.setDepartmentId(121);
         user.setFirstName("xyz");
         user.setLastName("abc");
         user.setStartDate(null);
         user.setUserId(112);
         user.setUserType("silver");
        Mockito.when(userService.getUserById(Mockito.anyInt())).thenReturn(user);
        		
        User responseEntity =userController.getUserById(112);
        	
        assertThat(responseEntity.getUserId()).isEqualTo(112);
        
    }

	
	@Test
    public void testGetEmployeeWithDepartment() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        ResponseTemplateVO vo = new ResponseTemplateVO();
        
        Department dept = new Department();
        dept.setDepartmentAddress("asdf");
        dept.setDepartmentCode("asdf");
        dept.setDepartmentId(3);
        dept.setDepartmentName("radlk");
        
         User user=new User();
         user.setDepartmentId(121);
         user.setFirstName("xyz");
         user.setLastName("abc");
         user.setStartDate(null);
         user.setUserId(112);
         user.setUserType("silver");
         
         vo.setDepartment(dept);
         vo.setUser(user);
         
         
        Mockito.when(userService.getEmployeeWithDepartment(Mockito.anyInt())).thenReturn(vo);
        		
        ResponseTemplateVO responseEntity =userController.getEmployeeWithDepartment(112);
        	
        assertThat(responseEntity.getDepartment().getDepartmentId()).isEqualTo(3);
        
    }
	
	@Test
    public void testUpdateUser() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         User user=new User();
         user.setDepartmentId(121);
         user.setFirstName("xyz");
         user.setLastName("abc");
         user.setStartDate(null);
         user.setUserId(112);
         user.setUserType("silver");
        Mockito.doThrow(new NoSuchElementException()).when(userService).updateUser(user);
        		
        ResponseEntity<String> s =userController.updateUser(user);
        	
        assertThat(s.getStatusCodeValue()).isEqualTo(404);
        
    }
	
	@Test
    public void testUpdateUserIf() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         User user=new User();
         user.setDepartmentId(121);
         user.setFirstName("xyz");
         user.setLastName("abc");
         user.setStartDate(null);
         user.setUserId(112);
         user.setUserType("silver");
        Mockito.doNothing().when(userService).updateUser(user);
        		
        ResponseEntity<String> s =userController.updateUser(user);
        	
        assertThat(s.getStatusCodeValue()).isEqualTo(200);
        
    }
	
	@Test
    public void testDeleteUser() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         Mockito.doThrow(new RuntimeException()).when(userService).deleteUserById(Mockito.anyInt());
        		
         ResponseEntity<String> s =userController.deleteUser(112);
        	
         assertThat(s.getStatusCodeValue()).isEqualTo(404);
        
    }
	
	@Test
    public void testDeleteUserIf() 
    {
		 MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         Mockito.doNothing().when(userService).deleteUserById(Mockito.anyInt());
	        		
	         ResponseEntity<String> s =userController.deleteUser(112);
	        	
	         assertThat(s.getStatusCodeValue()).isEqualTo(200);
        
    }

}
