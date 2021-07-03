package com.mop.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mop.registration.entity.Login;
import com.mop.registration.entity.Registration;
import com.mop.registration.exception.RegistrationNotFoundException;
import com.mop.registration.exception.ResourceNotFoundException;
import com.mop.registration.request.RegistrationRequest;
import com.mop.registration.response.RegistrationResponse;
import com.mop.registration.service.ForgetPasswordService;
import com.mop.registration.service.LoginService;
import com.mop.registration.service.RegistrationService;



@RestController
@RequestMapping("/login/")
public class RegistrationController {
	
	private static final Logger
	LOGGER=LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	ForgetPasswordService forgetPasswordService;
	
	@PostMapping("/save")
    public String saveLoginData(@RequestBody Login login) {
		LOGGER.info(" Inside saveLoginData method in RegistrationController");
        return loginService.saveLoginData(login);
        
    }

	@PostMapping("/saveRegistration")
	public RegistrationResponse createRegistration(@RequestBody RegistrationRequest registrationRequest)
			throws ResourceNotFoundException, Exception {
		LOGGER.info(" Inside createRegistration method in RegistrationController");
		Registration registration = new Registration(registrationRequest);
		boolean isValid = registrationService.isValid(registration);
		if (isValid) {
			return registrationService.createRegistration(registration);
		} else {
			throw new ResourceNotFoundException("Missing Data Exception");
			
		}
		
	}
	
	@GetMapping("/registration/{id}")
	public Registration findRegistrationById(@PathVariable("id") Long rId) throws RegistrationNotFoundException {
		LOGGER.info(" Inside findRegistrationById method in RegistrationController");
		Registration registration = registrationService.findRegistrationById(rId);
		if(registration == null)
			throw new RegistrationNotFoundException("id: "+ rId);
		return registration;
	}
	
	@PostMapping("/forgetPassword")
	public String validate(@RequestParam String user_name)
	{
		LOGGER.info("Inside validate method in RegistrationController ");
		if(user_name!=null && !(user_name.isEmpty()))
		{
			return forgetPasswordService.userNameValidate(user_name);
		}
		else
		{
			return "user name is empty or null";
		}
	}
	
	@PostMapping("/otpValidation")
	public void otpValidation(@RequestParam String user_name,String otp) {
		LOGGER.info("Inside otpValidation method in RegistrationController");
		forgetPasswordService.otpValidation(user_name,otp);
		
	}
}
