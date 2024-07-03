package com.ms.user.service;

import com.ms.user.model.dto.UserDto;
import com.ms.user.model.entity.User;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User saveUser(UserDto userDto) {
        var user = new User();

        user.setName(userDto.name());
        user.setEmail(userDto.email());

        var savedUser = userRepository.save(user);

        userProducer.publishMessageEmail(savedUser);

        return savedUser;
    }
}
