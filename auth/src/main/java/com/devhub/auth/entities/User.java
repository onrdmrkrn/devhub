package com.devhub.auth.entities;

import com.devhub.common.dtos.UserDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;
    private String userLastName;
    private String password;


    @Column(unique = true)
    private String userMail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private UserDetails userDetails;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public User() {
    }

    public User(int userId, String userName, String userLastName, String password, String userMail, UserDetails userDetails) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.password = password;
        this.userMail = userMail;
        this.userDetails = userDetails;
    }

    public static User fromResource(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.userId);
        user.setUserName(userDto.userName);
        user.setUserLastName(userDto.userLastName);
        user.setUserMail(userDto.userMail);
        user.setPassword(userDto.password);

        return user;
    }

    public static UserDto toResource(User user) {
        UserDto userDto = new UserDto();
        userDto.userId = user.getUserId();
        userDto.userName = user.getUserName();
        userDto.userLastName = user.getUserLastName();
        userDto.userMail = user.getUserMail();
        userDto.password = user.getPassword();

        return userDto;
    }

}
