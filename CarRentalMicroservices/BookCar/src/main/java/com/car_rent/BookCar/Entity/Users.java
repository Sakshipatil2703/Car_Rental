package com.car_rent.BookCar.Entity;



import com.car_rent.BookCar.Enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserrole() {
		return userrole;
	}
	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}
	 @Enumerated(EnumType.STRING)
	    @Column(name = "user_role")
	private UserRole userrole;
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	public Users(Long id, String name, String email, String password, UserRole userrole) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userrole = userrole;
	}
	public Users() {
		super();
	}

}
