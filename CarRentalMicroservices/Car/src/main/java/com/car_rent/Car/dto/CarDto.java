
package com.car_rent.Car.dto;

import java.sql.Date;



public class CarDto {
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
	    

}