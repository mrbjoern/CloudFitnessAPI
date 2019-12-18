package com.mrbjoern.cloudfitness.api.repository;

import com.mrbjoern.cloudfitness.api.domain.WeightliftingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightliftingTypeRepository extends JpaRepository<WeightliftingType, Long> {
}
