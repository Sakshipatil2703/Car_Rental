package com.car_rent.Car;

import java.util.List;




import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
 

import com.car_rent.Car.controller.AdminController;

import com.car_rent.Car.dto.CarDto;
import com.car_rent.Car.entity.Car;

import junit.framework.Assert;





@SpringBootTest
public class AppTest 
{   
	@Autowired
	private AdminController cont;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return (Test) new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
//    
    
    @Test
    public void test() {
    	List<CarDto> res = this.cont.getAllCars();
    	 Assert.assertEquals(4,res.size());
    }
    
//    public void test1() {
//    	ResponseEntity<Car> res1 = this.cont.getCarById();
//    	
//    }
}
