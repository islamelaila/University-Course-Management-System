package com.spring.boot.service.impl;

import com.spring.boot.model.UserDetails;
import com.spring.boot.repo.UserRepo;
import com.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<UserDetails> getAllUsers() {
        return userRepo.findAll();

    }

    @Override
    public UserDetails getTeacherByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
