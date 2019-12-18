package com.mrbjoern.cloudfitness.api.controller;

import com.mrbjoern.cloudfitness.api.domain.User;
import com.mrbjoern.cloudfitness.api.domain.UserMeasurement;
import com.mrbjoern.cloudfitness.api.repository.UserMeasurementRepository;
import com.mrbjoern.cloudfitness.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;

        User user = new User();
        user.setRegistrationDate(new Date());
        user.setName("Test User");
        user.setEmail("user@example.com");
        userRepository.save(user);

        User user2 = new User();
        user2.setRegistrationDate(new Date());
        user2.setName("Other User");
        user2.setEmail("other@example.com");
        userRepository.save(user2);
    }

    @GetMapping("/")
    public List<User> getUsers(Pageable pageRequest) {
        return userRepository.findAll(pageRequest).getContent();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));
    }
}
