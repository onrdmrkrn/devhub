package com.devhub.auth.service;

import com.devhub.auth.entities.User;

import com.devhub.auth.entities.UserDetails;
import com.devhub.auth.repository.UserDetailsRepository;
import com.devhub.auth.repository.UserRepository;
import com.devhub.common.dtos.UserDetailsDto;
import com.devhub.common.dtos.UserDto;
import com.devhub.common.response.Meta;
import com.devhub.common.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    UserDetailsRepository userDetailsRepository;


    public ResponseEntity<UserResponse> register(UserDto userDto) {
        User existUser = userRepository.findUserByUserMail(userDto.userMail);
        if(existUser != null){
            System.out.println("Böyle bir kullanıcı bulunmaktadır. ");
        }
        UserDetails userDetails = new UserDetails();
        User user = User.fromResource(userDto);
        user.setUserDetails(userDetails);
        user = userRepository.save(user);
        userDto.userId = user.getUserId();
        return createdUser(User.toResource(user));
    }

    private ResponseEntity<UserResponse> createdUser(UserDto toEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.meta = new Meta();
        userResponse.meta.errorCode = 200;
        userResponse.userDto = toEntity;
        return ResponseEntity.ok(userResponse);

    }

    public UserResponse findUser(int userId) {
        UserDto userDto = new UserDto();
        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByUserId(userId);
        if (user == null){
            userResponse.meta.errorCode = 4000;
            userResponse.meta.errorDesc = userId + " numaralı kullanıcı bulunamamıştır.";
            userResponse.userDto = userDto;
        }
        return foundUser(User.toResource(user));
    }

    private UserResponse foundUser(UserDto toResource) {
        UserResponse userResponse = new UserResponse();
        userResponse.meta = new Meta();
        userResponse.meta.errorCode = 200;
        userResponse.meta.errorDesc = "Kullanıcı bulma işlemi başarılı.";
        userResponse.userDto = toResource;
        return userResponse;
    }


}
