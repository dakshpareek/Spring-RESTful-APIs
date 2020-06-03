package com.example.demo2.service;

import com.example.demo2.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService
{
    UserDto createUser(UserDto user);
}
