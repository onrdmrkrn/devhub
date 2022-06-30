package com.devhub.auth.controller;

import com.devhub.auth.service.UserService;
import com.devhub.common.dtos.UserDetailsDto;
import com.devhub.common.dtos.UserDto;
import com.devhub.common.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> userRegister(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }

    @GetMapping("/find/{userId}")
    public UserResponse userFind(@PathVariable (value = "userId")String userId){
        return userService.findUser(Integer.parseInt(userId));
    }
}
