package com.mrbjoern.cloudfitness.api.controller;

import com.mrbjoern.cloudfitness.api.domain.User;
import com.mrbjoern.cloudfitness.api.domain.UserMeasurement;
import com.mrbjoern.cloudfitness.api.repository.UserMeasurementRepository;
import com.mrbjoern.cloudfitness.api.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final UserMeasurementRepository userMeasurementRepository;
    private final UserRepository userRepository;

    public MeasurementController(final UserMeasurementRepository userMeasurementRepository, final UserRepository userRepository) {
        this.userMeasurementRepository = userMeasurementRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{userId}")
    public List<UserMeasurement> getMeasurementsForUser(@PathVariable("userId") Long userId, Pageable pageable) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));
        return userMeasurementRepository.findAllByUser(user, pageable).getContent();
    }

    @PostMapping("/user/{userId}")
    public UserMeasurement postUserMeasurement(@PathVariable("userId") Long userId, @RequestBody UserMeasurement userMeasurement) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));
        userMeasurement.setUser(user);
        userMeasurement.setRegistrationDate(new Date());
        return userMeasurementRepository.save(userMeasurement);
    }

    @DeleteMapping("/{measurementId}")
    public UserMeasurement deleteMeasurement(@PathVariable("measurementId") Long measurementId) {
        UserMeasurement userMeasurement = userMeasurementRepository.findById(measurementId).orElseThrow(() -> new EntityNotFoundException(measurementId.toString()));
        userMeasurementRepository.delete(userMeasurement);
        return userMeasurement;
    }
}
