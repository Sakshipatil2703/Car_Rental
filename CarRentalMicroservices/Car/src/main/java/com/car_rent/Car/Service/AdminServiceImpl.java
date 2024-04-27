package com.car_rent.Car.Service;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.car_rent.Car.dto.BookACarDto;
import com.car_rent.Car.dto.CarDto;
import com.car_rent.Car.dto.CarDtoListDto;
import com.car_rent.Car.dto.SearchCarDto;
import com.car_rent.Car.entity.Car;
import com.car_rent.Car.repository.CarRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AdminServiceImpl implements AdminService{
	 private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
	 
@Autowired
CarRepository carrepository;

@Override

public Car postCar(CarDto carDto) throws IOException{

	Car car =new Car();
	car.setName(carDto.getName());
	car.setBrand(carDto.getBrand());
	car.setColor(carDto.getColor());
	car.setPrice(carDto.getPrice());
	car.setYear(carDto.getYear());
	car.setType(carDto.getType());
	car.setDescription(carDto.getDescription());
	car.setTransmission(carDto.getTransmission());
	
	Car c=carrepository.save(car);
	return c;
	
	

}

@Override
public List<CarDto> getAllCar() {
	
	return carrepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
}

@Override
public void deleteCar(Long id) {
	
	carrepository.deleteById(id);
	
}

@Override
public Car getCarById(Long id) {
	// TODO Auto-generated method stub
	Car optionalCar=carrepository.findById(id).get();
//	return optionalCar.map(Car::getCarDto).orElse(null);
	return optionalCar;
	
}

@Override
public Car updateCar(long carId, CarDto carDto){
	Optional<Car>optionalCar = carrepository.findById(carId);
	if(optionalCar.isPresent()) {
		Car existingCar =optionalCar.get();
		existingCar.setPrice(carDto.getPrice());
		existingCar.setYear(carDto.getYear());
		existingCar.setType(carDto.getType());
		existingCar.setDescription(carDto.getDescription());
		existingCar.setTransmission(carDto.getTransmission());
		existingCar.setColor(carDto.getColor());
		existingCar.setName(carDto.getName());
		existingCar.setBrand(carDto.getBrand());
		
	
	carrepository.save(existingCar);
	}
	return (Car) carrepository;
	
}


public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
    if (searchCarDto == null) {
        throw new IllegalArgumentException("Search criteria cannot be null");
    }

    try {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Car> carExample = Example.of(car, exampleMatcher);

        // Log the generated query
        log.info("Generated query: {}", carExample);

        List<Car> carList = carrepository.findAll(carExample);

        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));

        return carDtoListDto;
    } catch (Exception e) {
        log.error("Error occurred while searching for cars", e);
        throw new RuntimeException("Error occurred while searching for cars", e);
    }
}
public List<Car> searchCars(String brand, String type, String transmission, String color) {
    return carrepository.searchCars(brand, type, transmission, color);
}

@Override
public List<BookACarDto> getBookings() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean changeBookingStatus(Long bookingId, String status) {
	// TODO Auto-generated method stub
	return false;
}


}
