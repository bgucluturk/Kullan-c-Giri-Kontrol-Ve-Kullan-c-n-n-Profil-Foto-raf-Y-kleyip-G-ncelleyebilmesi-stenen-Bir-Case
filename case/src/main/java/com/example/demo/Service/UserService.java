package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserDto.UserDto;
import com.example.demo.Repository.UserRepo;


@Service
public class UserService {

        @Autowired
        private UserRepo userRepository;
    
        public User saveUser(User user) {
            return userRepository.save(user);
        }

        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }

        @Transactional
        public Integer updateUser(User user){
            return userRepository.updateUserById(user);
        }

        public List<UserDto> getAllUsers() {
            List<User> users = userRepository.findAllUsers();
            List<UserDto> userDTOs = new ArrayList<>();
            for (User user : users) {
                UserDto userDTO = new UserDto();
                userDTO.setUsername(user.getUsername());
                userDTO.setEmail(user.getEmail());
                userDTOs.add(userDTO);
            }
            return userDTOs;
        }
        
        

    }
    

