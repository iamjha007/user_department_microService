package com.springLearn.userService.service;

import com.springLearn.userService.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User saveUser(User user);
    public User getUserById(Long id);
}
