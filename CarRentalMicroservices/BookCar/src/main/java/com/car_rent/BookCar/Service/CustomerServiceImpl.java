package com.car_rent.BookCar.Service;

import java.util.List;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car_rent.BookCar.Entity.BookCar;
import com.car_rent.BookCar.Entity.Car;
import com.car_rent.BookCar.Entity.Users;
import com.car_rent.BookCar.Enums.BookCarStatus;
import com.car_rent.BookCar.FeignClient.CarFeignClient;
import com.car_rent.BookCar.FeignClient.UserFeignClient;
import com.car_rent.BookCar.Repository.BookACarRepository;

import com.car_rent.BookCar.dto.BookACarDto;
import com.car_rent.BookCar.dto.CarDto;



@Service
public class CustomerServiceImpl implements CustomerService{	
	
@Autowired(required = false)
CarFeignClient carRepository;
@Autowired
UserFeignClient userRepository;

@Autowired(required = false)
BookACarRepository bookACarRepository;



@Override
public boolean bookACar(BookACarDto bookACarDto) {
	  
System.out.println(bookACarDto.getDays());

	Optional<Car> optionalCar = carRepository.getCarById(bookACarDto.getCarId());
	Optional<Users> optionalUser = userRepository.getUserById(bookACarDto.getUserId());
 
     Long carId = bookACarDto.getCarId();
     Long userId = bookACarDto.getUserId();
     System.out.println("Car ID: " + carId + ", User ID: " + userId); 
     if (optionalCar.isPresent() && optionalUser.isPresent()) {
         Car existingCar = optionalCar.get(); 
         BookCar bookCar = new BookCar();
        
        
         bookCar.setUser(optionalUser.get());
         bookCar.setCar(existingCar);
         bookCar.setFromDate(bookACarDto.getFromDate());
         bookCar.setToDate(bookACarDto.getToDate());
         bookCar.setBookCarStatus(BookCarStatus.PENDING);
         long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
         long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds); 
         bookCar.setDays(days);
         bookCar.setPrice(existingCar.getPrice() * days);
         bookACarRepository.save(bookCar);
         return true;
     }
     else {
         return false;
     }
}


@Override
public List<BookACarDto> getBookingsByUserId(Long userId) {
    return bookACarRepository.findBookByUserId(userId)
                              .stream()
                              .map(BookCar::getBookACarDto)
                              .collect(Collectors.toList());
}


@Override
public CarDto getcarById(Long carId) {
	// TODO Auto-generated method stub
	return null;
}








}
