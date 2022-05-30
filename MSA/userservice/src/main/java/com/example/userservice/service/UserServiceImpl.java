package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        return null;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return null;
    }

    @Override
    public UserDto getUserDetailsByEmail(String userName) {
        return null;
    }
}
