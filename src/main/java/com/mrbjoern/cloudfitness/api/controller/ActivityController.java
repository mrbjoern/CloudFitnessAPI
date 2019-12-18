package com.mrbjoern.cloudfitness.api.controller;

import com.mrbjoern.cloudfitness.api.domain.Activity;
import com.mrbjoern.cloudfitness.api.repository.ActivityRepository;
import com.mrbjoern.cloudfitness.api.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityController(final ActivityRepository activityRepository, final UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public Activity postActivity(@RequestBody Activity activity) {
        activity.setRegistrationDate(new Date());
        return activityRepository.save(activity);
    }
}
