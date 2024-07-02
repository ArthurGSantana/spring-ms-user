package com.ms.user.service;

import com.ms.user.model.dto.UserDto;
import com.ms.user.model.entity.User;
import com.ms.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDto userDto) {
        var user = new User();

        user.setName(userDto.name());
        user.setEmail(userDto.email());

        return userRepository.save(user);
    }
}
