package com.car_rent.BookCar.Entity;

import java.sql.Date;


import com.car_rent.BookCar.dto.CarDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String brand;
	
	private String color;
	
	private String name;
	 
	private String type;
	
	private String transmission;
	
	private String description;
	
	private long price;
	 
	private Date year;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	
	public CarDto getCarDto() {
		CarDto carDto = new CarDto();
		carDto.setId(id);
		carDto.setName(name);
		carDto.setBrand(brand);
		carDto.setColor(color);
		carDto.setPrice(price);
		carDto.setDescription(description);
		carDto.setType(type);
		carDto.setTransmission(transmission);
		carDto.setYear(year);
		
		return carDto;
	}
	
	public Car() {
		super();
	}
	public Car(String brand, String color, String name, String type, String transmission, String description,
			long price, Date year) {
		super();
		this.brand = brand;
		this.color = color;
		this.name = name;
		this.type = type;
		this.transmission = transmission;
		this.description = description;
		this.price = price;
		this.year = year;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", color=" + color + ", name=" + name + ", type=" + type
				+ ", transmission=" + transmission + ", description=" + description + ", price=" + price + ", year="
				+ year + "]";
	}

	
}
