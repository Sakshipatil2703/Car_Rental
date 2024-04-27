package com.car_rent.user.Repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car_rent.user.Entity.Users;
import com.car_rent.user.Enums.UserRole;


@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

	Users findByEmailAndPassword(String email, String password);
	List<Users> findByUserrole(UserRole userrole);
	
	 Users findByEmail(String email);
	


		

}
