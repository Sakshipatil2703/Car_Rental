package com.car_rent.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_rent.user.Entity.Users;
import com.car_rent.user.Service.Auth;
import com.car_rent.user.dto.LoginRequest;
import com.car_rent.user.dto.SignupRequest;
import com.car_rent.user.dto.UserDto;


@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired 
	Auth auth;
	
	@PostMapping("/signup")
	public Users signupCustomer(@RequestBody SignupRequest signupRequest){
		
		Users createdCustomerDto = auth.createCustomer(signupRequest);
		return createdCustomerDto;
	
	}
	@PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        UserDto loggedInUser = auth.loginUser(loginRequest);

        if (loggedInUser != null) {
        	return "Login_Success";
        } else {
            return "fails";
        }
    }
	
	 
}
