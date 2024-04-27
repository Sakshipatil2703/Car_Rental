package com.car_rent.BookCar.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_rent.BookCar.Service.CustomerServiceImpl;
import com.car_rent.BookCar.dto.BookACarDto;



@RestController
@RequestMapping("/api/customer")
public class CustomerController {
@Autowired(required = false)
CustomerServiceImpl customerService;


@PostMapping("/car/book")
public ResponseEntity<Void> bookCar(@RequestBody BookACarDto bookACarDto) {
	System.out.println(bookACarDto);
    boolean success = customerService.bookACar(bookACarDto);
    if (success) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

@GetMapping("/car/bookings/{userId}/{carid}")
public ResponseEntity<List<BookACarDto>> getBookingsById(@PathVariable Long userId){
	return ResponseEntity.ok(customerService.getBookingsByUserId(userId));
}

}

