package com.mphasis.userApplication.dAO;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.mphasis.userApplication.model.User;

@DataJpaTest
public class UserRepositoryTests {
	 private static final LocalDate LocalDate = null;

	@Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private  UserRepository userRepository;
	    
	    @Autowired User user;
	    
	/*  @Test
	    public void saveTest() {

	    	User user= new User();
	    	user.setUserId(1191);
	    	user.setFirstName("xyz");
	    	user.setLastName("abc");
	    	user.setStartDate(LocalDate);
	    	userRepository.save(user);
	    	assertThat(user.getUserId()).isEqualTo(1191); 
	    }*/
	    
	    	
	    	  
	
}
