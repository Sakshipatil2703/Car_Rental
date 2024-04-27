package com.car_rent.BookCar.FeignClient;

import java.util.Optional;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.car_rent.BookCar.Entity.Users;



@CrossOrigin("*")
@FeignClient(name="UserService", url="http://localhost:8081/api/signup")
public interface UserFeignClient {
	@GetMapping(value="/{userId}")
	Optional<Users> getUserById(@PathVariable("userId") long userId);
}
