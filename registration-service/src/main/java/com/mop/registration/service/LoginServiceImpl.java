package com.mop.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mop.registration.entity.Login;
import com.mop.registration.repository.LoginRepository;

import java.sql.*;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger
	LOGGER=LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public String saveLoginData(Login login) {
    	LOGGER.info("Inside saveLoginData method in LoginServiceImpl");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "jaanu@123");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM login WHERE user_name = " + login.getUserName() ;

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                return "user name already exists, please try again with correct username";
            else {
                loginRepository.save(login);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "login data saved successfully";
    }
}
