package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = 
		SpringApplication.run(Zee5appspringbootApplication.class, args);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		
		System.out.println(dataSource!=null);
		
		Register register = null;
		
		try {
			register = new Register("ZEE0000017", "Ramesh123", "Mahendran", "ramesh11@gmail.com","suryasurya", new BigDecimal("9441612222"));
		} catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException
				| InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userRepository.addUser(register));
		
		applicationContext.close();
	}

}
