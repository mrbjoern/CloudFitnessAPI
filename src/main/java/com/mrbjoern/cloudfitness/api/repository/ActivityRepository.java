package com.mrbjoern.cloudfitness.api.repository;

import com.mrbjoern.cloudfitness.api.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
