package com.mphasis.userApplication.dAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.userApplication.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
