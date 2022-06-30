package com.devhub.auth.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userDetailsId;

    private String profilePictureUrl;

    private String bio;

    private String birthDay;

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public UserDetails() {
    }

    public UserDetails(int userDetailsId, String profilePictureUrl, String bio, String birthDay) {
        this.userDetailsId = userDetailsId;
        this.profilePictureUrl = profilePictureUrl;
        this.bio = bio;
        this.birthDay = birthDay;
    }
}
