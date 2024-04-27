package com.car_rent.Car.controller;
import java.io.IOException;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car_rent.Car.Service.AdminService;
import com.car_rent.Car.dto.BookACarDto;
import com.car_rent.Car.dto.CarDto;
import com.car_rent.Car.dto.SearchCarDto;
import com.car_rent.Car.entity.Car;
import com.car_rent.Car.repository.CarRepository;






@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	@Autowired
	CarRepository carrepository;
	
	
	@PostMapping("/car")
	public Car postCar(@RequestBody CarDto carDto) throws IOException{
		return adminservice.postCar(carDto);
		
	}
	@GetMapping("/cars")
	public List<CarDto> getAllCars(){
		return this.adminservice.getAllCar();
	}
	@DeleteMapping("/car/{id}")
	public ResponseEntity<Void>deleteCar(@PathVariable Long id){
		adminservice.deleteCar(id);
		return ResponseEntity.ok(null);
	}
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id){
		Car car = adminservice.getCarById(id);
		return ResponseEntity.ok(car);
	}

	@PutMapping("/car/{carId}")
	public Car updateCar(@PathVariable Long carId, @RequestBody CarDto carDto) {
	    Car updated = adminservice.updateCar(carId, carDto);
	    return updated;
	} 
	
	
	@PostMapping("/car/search")
	public ResponseEntity<?>searchCar(@RequestBody SearchCarDto searchCarDto){
		return ResponseEntity.ok(adminservice.searchCar(searchCarDto));
		
	}
	 @GetMapping("/search")
	    public ResponseEntity<List<Car>> searchCars(@RequestParam(required = false) String brand,
	                                                @RequestParam(required = false) String type,
	                                                @RequestParam(required = false) String transmission,
	                                                @RequestParam(required = false) String color) {
	        List<Car> cars = adminservice.searchCars(brand, type, transmission, color);
	        return ResponseEntity.ok(cars);
	    }
}