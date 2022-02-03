package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movie;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.InvalidTypeException;
import com.zee.zee5app.repository.EpisodesRepository;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodesService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  SpringApplication.run(Zee5appspringbootApplication.class, args);
		UserService userservice = applicationContext.getBean(UserService.class);

		EpisodesService episervice = applicationContext.getBean(EpisodesService.class);
		RoleService roleservice = applicationContext.getBean(RoleService.class);
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
		UserRepository repository = applicationContext.getBean(UserRepository.class);
		MovieRepository movierepository = applicationContext.getBean(MovieRepository.class);
		
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		SubscriptionService subservice = applicationContext.getBean(SubscriptionService.class);
		MovieService movieservice = applicationContext.getBean(MovieService.class);
		SeriesService seriesservice = applicationContext.getBean(SeriesService.class);
		LoginService loginservice = applicationContext.getBean(LoginService.class);
		
		Series series = new Series("ser00002","originals","supernatural","12-03-2016","youtube.com",20,"english","ian",18,null);
		Series series2 = new Series("ser00003","original","supernatural","12-03-2016","youtube.com",20,"english","ian s",18,null);
		
		
		
		Episodes episode = new Episodes("epi00002","meeting",10,"us",series);
		
		System.out.println(seriesservice.addSeries(series));
		System.out.println(episervice.addEpisodes(episode));
		
		
		
		
		
		
		
//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_USER);
//		Role role2 = new Role();
//		role2.setRoleName(EROLE.ROLE_USER);
//		String res = roleservice.addRole(role);
//		System.out.println(res);
		
		
		//System.out.println(repository.existsByEmailAndContactNumber("surya02@gmail.com", new BigDecimal("9491612222")));
		
		
		
//		Register register = null;
//		
//		Register register = new Register("sc000013", "surya_varma3", "kalidindi", "surya013@gmail.com","suryasury", new BigDecimal("94916122252"),null);
//		Set<Role> roles = new HashSet<>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register.setRoles(roles);
//		
//		try {
//			System.out.println(userservice.addUser(register));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			System.out.println("exception raised");
//		}
//		
//		try {
//			Optional<Register> optional = userservice.getUserById("sc00005");
//			System.out.println(optional.get());
//		} catch (IdNotFoundException | InvalidPasswordException | InvalidIdLengthException | InvalidNameException
//				| InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Optional<List<Register>> optional;
//		try {
//			optional = userservice.getAllUserDetails();
//			if(optional.isEmpty()) {
//				System.out.println("there are no records");
//			}
//			else {
//				optional.get().forEach(e->System.out.println(e));
//			}
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
//				| InvalidPasswordException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		Subscription subscription = new Subscription("sub00002","annual","01-01-2022","india","upi","true","as","active",1000,"9491612222","sc00003");
//		
//		System.out.println(subservice.addSubscription(subscription));
//		
//		Optional<List<Subscription>> optional1;
//		
//			try {
//				optional1 = subservice.getAllSubscriptionsDetails();
//				if(optional1.isEmpty()) {
//					System.out.println("there are no records");
//				}
//				else {
//					optional1.get().forEach(e->System.out.println(e));
//				}
//			} catch (InvalidAmountException | InvalidTypeException | InvalidIdLengthException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//		try {
//			String res = subservice.deleteSubscriptionById("sub00002");
//			System.out.println("deletion is" + res);
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		
//		Movie movie = new Movie("mov00003","rrr","ntr,rc",150,"13-3-2022","youtube.com","telugu",17,"action");
//		System.out.println(movieservice.addMovie(movie));
//		
//		Optional<List<Movie>> optional2 = movieservice.getAllMovieDetails();
//		if(optional2.isEmpty()) {
//			System.out.println("no movies");
//		}
//		else {
//			optional2.get().forEach(e->System.out.println(e));
//		}
//		
//		
//		
//		Series series = new Series("ser00002","originals","supernatural","12-03-2016","youtube.com",20,"english","ian",18);
//		System.out.println(seriesservice.addSeries(series));
//		
//		Optional<List<Series>> optional3 = seriesservice.getAllSeriesDetails();
//		if(optional3.isEmpty()) {
//			System.out.println("no movies");
//		}
//		else {
//			optional3.get().forEach(e->System.out.println(e));
//		}
//		
//		try {
//			Optional<Series> optional12 = seriesservice.getSeriesById("ser00002");
//			System.out.println(optional12.get());
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		Login login = new Login("suryavamsi01@gmail.com","12345678","sc00005",ROLE.ROLE_ADMIN);
//		
//		System.out.println(loginservice.addCredentials(login));
//		
//		
//		
//		Episodes episode = new Episodes("epi00002","meeting","ser00002",10,"us");
//		episervice.addEpisodes(episode);
//		
//		Optional<List<Episodes>> optional4 = episervice.getAllEpisodesDetails();
//		if(optional4.isEmpty()) {
//			System.out.println("no episodes found");
//		}
//		else {
//			optional4.get().forEach(e->System.out.println(e));
//		}
//		
		
		applicationContext.close();
	}

}
