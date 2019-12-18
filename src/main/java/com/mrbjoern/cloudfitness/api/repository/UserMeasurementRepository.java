package com.mrbjoern.cloudfitness.api.repository;

import com.mrbjoern.cloudfitness.api.domain.User;
import com.mrbjoern.cloudfitness.api.domain.UserMeasurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMeasurementRepository extends JpaRepository<UserMeasurement, Long> {

    Page<UserMeasurement> findAllByUser(User user, Pageable pageable);


}
