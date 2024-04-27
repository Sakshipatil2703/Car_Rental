package com.car_rent.BookCar.FeignClient;

import java.util.Optional;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.car_rent.BookCar.Entity.Car;



@CrossOrigin("*")
@FeignClient(name="car", url="http://localhost:8083/api/admin/car")
public interface CarFeignClient {
	@GetMapping(value ="/{carId}")
	Optional<Car> getCarById(@PathVariable("carId") long carId);

}
