package com.mop.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mop.registration.entity.Registration;
import com.mop.registration.repository.RegistrationRepository;
import com.mop.registration.response.RegistrationResponse;

@Service
public class RegistrationService {
	
	private static final Logger
	LOGGER=LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	private RegistrationRepository registrationRepository;

	
	public RegistrationResponse createRegistration(Registration registration) {
		LOGGER.info("Inside createRegistration method in RegistrationService");
		registration = registrationRepository.save(registration);
		return new RegistrationResponse(registration);
	}

	public Registration findRegistrationById(Long rId) {
		LOGGER.info("Inside findRegistrationById method in RegistrationService");
		return registrationRepository.findByRId(rId);
	}

	public boolean isValid(Registration registration) {
		LOGGER.info("Inside isValid method in RegistrationService");
		return !registration.getAddress().isEmpty() && !registration.getCity().isEmpty()
				&& !registration.getDOB().isEmpty() && !registration.getEmail().isEmpty()
				&& !registration.getName().isEmpty() && !registration.getPhone().isEmpty() && !registration.getState().isEmpty();
	}
}

