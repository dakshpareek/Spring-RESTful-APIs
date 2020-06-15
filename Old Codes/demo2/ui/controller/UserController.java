package com.example.demo2.ui.controller;

import com.example.demo2.service.UserService;
import com.example.demo2.shared.UserDto;
import com.example.demo2.ui.model.request.UserDetailsRequestModel;
import com.example.demo2.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser()
    {
        return "getUser called";
    }
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
    {

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }
    @DeleteMapping
    public String deleteUser()
    {
        return "deleteUser called";
    }
}
