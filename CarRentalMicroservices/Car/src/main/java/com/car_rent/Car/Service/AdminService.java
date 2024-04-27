package com.car_rent.Car.Service;

import java.io.IOException;



import java.util.List;

import com.car_rent.Car.dto.BookACarDto;
import com.car_rent.Car.dto.CarDto;
import com.car_rent.Car.dto.CarDtoListDto;
import com.car_rent.Car.dto.SearchCarDto;
import com.car_rent.Car.entity.Car;

public interface AdminService {
	
Car postCar(CarDto carDto ) throws IOException;

List<CarDto>getAllCar();

void deleteCar(Long id);

Car getCarById(Long id);

Car updateCar(long carId,CarDto carDto);

List<BookACarDto> getBookings();

boolean changeBookingStatus(Long bookingId, String status);

CarDtoListDto searchCar(SearchCarDto searchCarDto);

List<Car> searchCars(String brand, String type, String transmission, String color);


}
