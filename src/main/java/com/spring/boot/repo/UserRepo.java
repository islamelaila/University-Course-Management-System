package com.spring.boot.repo;

import com.spring.boot.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

    public UserDetails findByUsername(String username);
}
