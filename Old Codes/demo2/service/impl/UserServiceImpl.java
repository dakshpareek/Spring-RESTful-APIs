package com.example.demo2.service.impl;

import com.example.demo2.UserRepository;
import com.example.demo2.io.entity.UserEntity;
import com.example.demo2.service.UserService;
import com.example.demo2.shared.UserDto;
import com.example.demo2.shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto createUser(UserDto user) {

        UserEntity savedUserDetails = userRepository.findByEmail(user.getEmail());
        if (savedUserDetails != null)
        {
            throw new RuntimeException("User Exists");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(utils.generateUserId(30));

        UserDto returnValue = new UserDto();

        savedUserDetails = userRepository.save(userEntity);
        BeanUtils.copyProperties(savedUserDetails,returnValue);


        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
