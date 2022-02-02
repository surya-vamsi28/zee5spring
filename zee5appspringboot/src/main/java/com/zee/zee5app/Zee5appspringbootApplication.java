package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.EpisodesRepository;
import com.zee.zee5app.service.EpisodesService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  SpringApplication.run(Zee5appspringbootApplication.class, args);
		UserService userservice = applicationContext.getBean(UserService.class);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		SubscriptionService subservice = applicationContext.getBean(SubscriptionService.class);
		MovieService movieservice = applicationContext.getBean(MovieService.class);
		SeriesService seriesservice = applicationContext.getBean(SeriesService.class);
		LoginService loginservice = applicationContext.getBean(LoginService.class);
		EpisodesService episervice = applicationContext.getBean(EpisodesService.class);
		
		
		
		Register register = null;
		
		register = new Register("sc00005", "surya_vamsi", "kalidindi", "surya01@gmail.com","suryasurya", new BigDecimal("9491612222"));
		
		System.out.println(userservice.addUser(register));
		
		try {
			Optional<Register> optional = userservice.getUserById("sc00004");
			System.out.println(optional.get());
		} catch (IdNotFoundException | InvalidPasswordException | InvalidIdLengthException | InvalidNameException
				| InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		applicationContext.close();
	}

}
