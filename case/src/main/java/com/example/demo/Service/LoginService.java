package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserDto.LoginDto;
import com.example.demo.Repository.UserRepo;

@Service
public class LoginService {
    @Autowired
    private UserRepo userRepository;

    public List<LoginDto> login(LoginDto loginDto) {
        User user = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (user != null) {
            List<LoginDto> list = new ArrayList<>();
            // Kullanıcı bilgilerini LoginDto'ya dönüştür
            LoginDto userDto = new LoginDto();
            userDto.setUsername(loginDto.getUsername());
            list.add(userDto);
            return list;
        } else {
            throw new RuntimeException("User not found");
        }
    }

}
