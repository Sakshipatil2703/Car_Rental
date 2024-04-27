package com.car_rent.BookCar.Entity;

import jakarta.persistence.Entity;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.car_rent.BookCar.Enums.BookCarStatus;
import com.car_rent.BookCar.dto.BookACarDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BookCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fromDate;
	private Date toDate;
	private Long days;
	private Long price;
	@Enumerated(EnumType.STRING)
	 private BookCarStatus bookCarStatus;
	    

		public BookACarDto getBookACarDto() {
	        BookACarDto bookACarDto = new BookACarDto();
	        bookACarDto.setId(id);
	        bookACarDto.setDays(days);
	        bookACarDto.setBookCarStatus(bookCarStatus);
	        bookACarDto.setPrice(price);
	        bookACarDto.setToDate(toDate);
	        bookACarDto.setFromDate(fromDate);
	        
	        return bookACarDto;
	    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public BookCarStatus getBookCarStatus() {
		return bookCarStatus;
	}
	public void setBookCarStatus(BookCarStatus bookCarStatus) {
		this.bookCarStatus = bookCarStatus;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", FromDate=" + fromDate + ", toDate=" + toDate + ", days=" + days + ", price=" + price + ", bookCarStatus="
				+ bookCarStatus + "]";
	}

	public void setUser(Users users) {
		// TODO Auto-generated method stub
		
	}

	public void setCar(Car existingCar) {
		// TODO Auto-generated method stub
		
	}
}
