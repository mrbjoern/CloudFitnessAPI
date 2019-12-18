package com.mrbjoern.cloudfitness.api.controller;

import com.mrbjoern.cloudfitness.api.domain.WeightliftingType;
import com.mrbjoern.cloudfitness.api.repository.WeightliftingTypeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    private final WeightliftingTypeRepository weightliftingTypeRepository;

    public ActivityTypeController(final WeightliftingTypeRepository weightliftingTypeRepository) {
        this.weightliftingTypeRepository = weightliftingTypeRepository;

        WeightliftingType weightliftingType = new WeightliftingType();
        weightliftingType.setName("Deadlift");
        weightliftingTypeRepository.save(weightliftingType);
    }

    @GetMapping("/weightlifting")
    public List<WeightliftingType> getWeightliftingTypes(final Pageable pageable) {
        return weightliftingTypeRepository.findAll(pageable).getContent();
    }

    @PostMapping("/weightlifting")
    public WeightliftingType postWeightliftingType(@RequestBody final WeightliftingType weightliftingType) {
        return weightliftingTypeRepository.save(weightliftingType);
    }
}
