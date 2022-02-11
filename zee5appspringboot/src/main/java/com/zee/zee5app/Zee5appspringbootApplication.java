package com.zee.zee5app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movie;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.IdNotValidException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.InvalidTypeException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.UserServiceImpl;
import com.zee.zee5app.utils.FileUtils;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  SpringApplication.run(Zee5appspringbootApplication.class, args);
//		UserService userservice = applicationContext.getBean(UserService.class);
//		EpisodesService episervice = applicationContext.getBean(EpisodesService.class);
//		RoleService roleservice = applicationContext.getBean(RoleService.class);
//		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		UserRepository repository = applicationContext.getBean(UserRepository.class);
//		MovieRepository movierepository = applicationContext.getBean(MovieRepository.class);
//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//		SubscriptionService subservice = applicationContext.getBean(SubscriptionService.class);
//		MovieService movieservice = applicationContext.getBean(MovieService.class);
//		SeriesService seriesservice = applicationContext.getBean(SeriesService.class);
//		LoginService loginservice = applicationContext.getBean(LoginService.class);
//		FileUtils fileutils = applicationContext.getBean(FileUtils.class);
//

//
//		Series series = new Series("ser00002","originals","supernatural","12-03-2016","youtube.com",20,"english","ian",18,null);
//		Movie movie = new Movie("mov00003","rrr","ntr,rc",150,"13-3-2022",null,"telugu",17,"action");
//		Episodes episode = new Episodes("epi00001","pilot",null,10,"us",series);
//		
//		FileInputStream fileinputstream = null;
//		FileOutputStream fileoutputstream = null;
//		
//		
//		try {
//			fileinputstream = new FileInputStream("C:\\movies\\RRR.mp4");
//			File file = new File("C:\\movies\\RRR.mp4");
//			
//			byte[] allbytes = fileutils.readFile(file);
//			episode.setTrailer("C:\\movies\\seriesstore\\" + file.getName());
//			
//			String result = (movieservice.addMovie(movie));
//			if(result.equals("add Success")) {
//				String res1 = fileutils.writeFile(allbytes,file.getName() );
//				System.out.println(res1);
//				
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			fileinputstream = new FileInputStream("C:\\movies\\RRR.mp4");
//			File file = new File("C:\\movies\\RRR.mp4");
//			long filesize = file.length();
//			byte[] allbytes = new byte[(int) filesize];
//			fileinputstream.read(allbytes);
//			episode.setTrailer("C:\\movies\\seriesstore\\" + file.getName());
//			
//			String result = (movieservice.addMovie(movie));
//			if(result.equals("add Success")) {
//				fileoutputstream = new FileOutputStream("C:\\movies\\seriesstore\\" + file.getName());
//				fileoutputstream.write(allbytes);
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		FileInputStream fileinputstream = null;
//		FileOutputStream fileoutputstream = null;
//		
//		try {
//			fileinputstream = new FileInputStream("C:\\movies\\RRR.mp4");
//			File file = new File("C:\\movies\\RRR.mp4");
//			long filesize = file.length();
//			byte[] allbytes = new byte[(int) filesize];
//			fileinputstream.read(allbytes);
//			movie.setTrailer("C:\\movies\\moviestore\\" + file.getName());
//			
//			String result = (movieservice.addMovie(movie));
//			if(result.equals("add Success")) {
//				fileoutputstream = new FileOutputStream("C:\\movies\\moviestore\\" + file.getName());
//				fileoutputstream.write(allbytes);
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		
//		FileOutputStream fileoutputStream = null;
//		try {
//			Optional<Movie> optional = movieservice.getMovieById("mov00003");
//			if(optional.isEmpty()) {
//				System.out.println("record not found");
//			}
//			else {
//				// print info and copy file to other location with name rrr
//				Movie movie = optional.get();
//				fileoutputStream = new FileOutputStream("C:\\movies\\read\\rrr.mp4");
//				fileoutputStream.write(movie.getTrailer());
//			}
//		} catch (IdNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				fileoutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		Series series = new Series("ser00002","originals","supernatural","12-03-2016","youtube.com",20,"english","ian",18,null);
//		Series series2 = new Series("ser00003","original","supernatural","12-03-2016","youtube.com",20,"english","ian s",18,null);
//		
//		
//		
//		Episodes episode = new Episodes("epi00002","meeting",10,"us",series);
//		
//		System.out.println(seriesservice.addSeries(series));
//		System.out.println(episervice.addEpisodes(episode));
//		
//		Register register = new Register("sc000013", "surya_varma3", "kalidindi", "surya013@gmail.com","suryasury", new BigDecimal("94916122252"),null,null,null);
//		try {
//			System.out.println(userservice.addUser(register));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Subscription subscription = new Subscription("sub00002","annual","01-01-2022","india","upi","true","as","active",1000,"9491612222",register);
//		
//		System.out.println(subservice.addSubscription(subscription));
//		
//		Login login = new Login("suryavamsi01@gmail.com","12345678","sc00005",register);
//		System.out.println( "login success " + loginservice.addCredentials(login));
//		
//		
//		
//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_USER);
//		Role role2 = new Role();
//		role2.setRoleName(EROLE.ROLE_USER);
//		String res = roleservice.addRole(role);
//		String res1 = roleservice.addRole(role2);
//		System.out.println(res);
//		
//		
//		//System.out.println(repository.existsByEmailAndContactNumber("surya02@gmail.com", new BigDecimal("9491612222")));
//		
//		
//		
//
//		Register register6 = new Register("sc000016", "surya_varma4", "kalidindi4", "surya014@gmail.com","suryasury4", new BigDecimal("94916122254"),null,null,null);
//		Set<Role> roles = new HashSet<>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register6.setRoles(roles);
//		
//		try {
//			System.out.println(userservice.addUser(register6));
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
//		
//		applicationContext.close();
	}

}
