package com.devhub.auth.repository;

import com.devhub.auth.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
}
