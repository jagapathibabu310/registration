package com.mop.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mop.registration.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	Registration findByRId(Long rId);
}
