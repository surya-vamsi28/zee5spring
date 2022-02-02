package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.InvalidTypeException;
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
			Optional<Register> optional = userservice.getUserById("sc00005");
			System.out.println(optional.get());
		} catch (IdNotFoundException | InvalidPasswordException | InvalidIdLengthException | InvalidNameException
				| InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Optional<List<Register>> optional;
		try {
			optional = userservice.getAllUserDetails();
			if(optional.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional.get().forEach(e->System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Subscription subscription = new Subscription("sub00001","annual","01-01-2022","india","upi","true","as","active",1000,"9491612222","sc00003");
		
		System.out.println(subservice.addSubscription(subscription));
		
		Optional<List<Subscription>> optional1;
		
			try {
				optional1 = subservice.getAllSubscriptionsDetails();
				if(optional1.isEmpty()) {
					System.out.println("there are no records");
				}
				else {
					optional1.get().forEach(e->System.out.println(e));
				}
			} catch (InvalidAmountException | InvalidTypeException | InvalidIdLengthException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		
		
		Movie movie = new Movie("mov00002","rrr","ntr,rc",150,"13-3-2022","youtube.com","telugu",17,"action");
		System.out.println(movieservice.addMovie(movie));
		
		Optional<List<Movie>> optional2 = movieservice.getAllMovieDetails();
		if(optional2.isEmpty()) {
			System.out.println("no movies");
		}
		else {
			optional2.get().forEach(e->System.out.println(e));
		}
		Series series = new Series("ser00001","tvd","supernatural","12-03-2016","youtube.com",20,"english","ian",18);
		System.out.println(seriesservice.addSeries(series));
		
		Optional<List<Series>> optional3 = seriesservice.getAllSeriesDetails();
		if(optional3.isEmpty()) {
			System.out.println("no movies");
		}
		else {
			optional3.get().forEach(e->System.out.println(e));
		}
		
		
		Login login = new Login("suryavamsi@gmail.com","12345678","sc00005",ROLE.ROLE_ADMIN);
		
		System.out.println(loginservice.addCredentials(login));
		
		
		
		Episodes episode = new Episodes("epi00001","pilot","ser00001",50,"us");
		episervice.addEpisodes(episode);
		
		Optional<List<Episodes>> optional4 = episervice.getAllEpisodesDetails();
		if(optional4.isEmpty()) {
			System.out.println("no episodes found");
		}
		else {
			optional4.get().forEach(e->System.out.println(e));
		}
		
		
		applicationContext.close();
	}

}
