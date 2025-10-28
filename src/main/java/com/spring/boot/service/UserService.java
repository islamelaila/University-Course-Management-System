package com.spring.boot.service;

import com.spring.boot.model.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDetails> getAllUsers();

    UserDetails getTeacherByUsername(String username);

}
