package com.mop.registration.service;

import org.springframework.stereotype.Service;

@Service
public interface ForgetPasswordService  {
	public String userNameValidate(String user_name);
//	public void callMobileVerification(String user_name);

	public void otpValidation(String user_name, String otp);

}