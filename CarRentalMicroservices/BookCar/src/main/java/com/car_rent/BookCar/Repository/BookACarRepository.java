package com.car_rent.BookCar.Repository;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.car_rent.BookCar.Entity.BookCar;


@Repository
@EnableJpaRepositories
public interface BookACarRepository extends JpaRepository<BookCar, Long>{

	List<BookCar> findBookByUserId(Long userId);
	

}
