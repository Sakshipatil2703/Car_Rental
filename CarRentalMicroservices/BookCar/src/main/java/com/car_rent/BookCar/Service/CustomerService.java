package com.car_rent.BookCar.Service;

import java.util.List;

import com.car_rent.BookCar.dto.BookACarDto;
import com.car_rent.BookCar.dto.CarDto;





public interface CustomerService {
	
//    List<CarDto> getAllCars();

    boolean bookACar(BookACarDto bookACarDto);
    
	CarDto getcarById(Long carId);
	
	
    List<BookACarDto> getBookingsByUserId(Long userId);

//	CarDto getCarById(Long carId);	
    
//  List<Car> searchCars(String brand, String type, String transmission, String color);
	
	
	
	
	
}
