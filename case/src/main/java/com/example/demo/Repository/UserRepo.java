package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {    
    @Modifying
    @Query("UPDATE User u SET u.username = :#{#user.username}, u.password = :#{#user.password}, u.email = :#{#user.email} WHERE u.id = :#{#user.id}")
    Integer updateUserById(@Param("user") User user);
    
    @Query("SELECT u FROM User u")
    List<User> findAllUsers();
    
    User findByUsernameAndPassword(String username, String password);
 
}




