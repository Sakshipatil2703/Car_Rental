package com.car_rent.user.Service;



import com.car_rent.user.Entity.Users;
import com.car_rent.user.dto.LoginRequest;
import com.car_rent.user.dto.SignupRequest;
import com.car_rent.user.dto.UserDto;





public interface Auth {
	Users createCustomer(SignupRequest signuprequest);
    UserDto loginUser(LoginRequest loginRequest);
	


	

}
