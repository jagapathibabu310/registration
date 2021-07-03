package com.mop.registration.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.mop.registration.repository.UserRepository;




@Component
@ComponentScan("com.mop.repository")
public class ForgetPasswordServiceImp implements ForgetPasswordService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ForgetPasswordServiceImp.class);
	
	public UserRepository userRepository;


	public String userNameValidate(String user_name) {
		 try {
			 	LOGGER.info("Entry to userNameValidate method in ForgetPasswordServiceImp class");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "jaanu@123");
		        Statement statement = connection.createStatement();
				String query = "SELECT * FROM login WHERE user_name = " + user_name;
				 ResultSet resultSet = statement.executeQuery(query);
				 if (resultSet.next()) {
					 
					 return oneTimePassword();
				 }
				 else
				 {
					 return "user does not exist";
				 }
				 }       
				 catch (SQLException throwables) {
			            throwables.printStackTrace();
			        }
				 return "";

			}

	public String oneTimePassword() {
		LOGGER.info("inside oneTimePassword method in ForgetPasswordServiceImp class");
		return "123456";

	}

	public void otpValidation(String user_name, String otp) {
		
		if(otp.equals(oneTimePassword())) {
			LOGGER.info("OTP valid");
			updatePassword();     //calling Jagapathi API
		}
		else {
			LOGGER.info("OTP not valid");
		}
		
	}
	public void updatePassword() {
		
		
	}

//	@Override
//	public void callMobileVerification(String user_name) {
//		// TODO Auto-generated method stub
//		
//	}

}