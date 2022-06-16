package com.Project.Task1.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "Id")
	  private int userId;
	  @Column(name="FIRST_NAME")
	  private String firstName;
	  @Column(name="LAST_NAME")
	  private String lastName;
	  @Column(name="USER_TYPE")
	  private String userType;
	  @Column(name="START_DATE")
	  private LocalDate startDate;
	  
	  
	  
	  public int getUserId() {
		    return userId;
		  }
		  public void setUserId(int userId) {
		    this.userId = userId;
		  }
		  public String getFirstName() {
		    return firstName;
		  }
		  public void setFirstName(String firstName) {
		    this.firstName = firstName;
		  }
		  public String getLastName() {
		    return lastName;
		  }
		  public void setLastName(String lastName) {
		    this.lastName = lastName;
		  }
		  public String getUserType() {
		    return userType;
		  }
		  public void setUserType(String userType) {
		    this.userType = userType;
		  }
		  public LocalDate getStartDate() {
		    return startDate;
		  }
		  public void setStartDate(LocalDate startDate) {
		    this.startDate = startDate;
		  }
		  @Override
		  public String toString() {
		    return "UserId= " + getUserId() + " First Name= " + 
		        getFirstName() + " Last Name= " + getLastName() + 
		        " Type= "+ getUserType() + 
		        " StartDate= " + getStartDate();
		  }

}
