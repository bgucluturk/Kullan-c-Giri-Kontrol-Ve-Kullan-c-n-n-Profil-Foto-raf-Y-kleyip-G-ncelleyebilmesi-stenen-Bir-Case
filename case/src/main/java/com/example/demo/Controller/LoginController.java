package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserDto.LoginDto;
import com.example.demo.Service.LoginService;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<List<LoginDto>> loginUser(@RequestBody LoginDto loginDto) {
      List<LoginDto> user = loginService.login(loginDto);
      return ResponseEntity.ok(user); 

    }
}
