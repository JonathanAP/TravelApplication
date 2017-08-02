package fi.hh.finalproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*import org.springframework.jdbc.core.JdbcTemplate;*/

import fi.hh.finalproject.domain.User;
import fi.hh.finalproject.domain.Category;
import fi.hh.finalproject.TravelAppApplication;
import fi.hh.finalproject.domain.CategoryRepository;
import fi.hh.finalproject.domain.Destination;
import fi.hh.finalproject.domain.DestinationRepository;
import fi.hh.finalproject.domain.UserRepository;

@SpringBootApplication
public class TravelAppApplication {
	private static final Logger log = LoggerFactory.getLogger(TravelAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DestinationRepository drepository, CategoryRepository crepository, UserRepository urepository /*JdbcTemplate jdbcTemplate*/) {
		return (args) -> {
			log.info("saving test data");
			
			//creating categories
			crepository.save(new Category("City"));
			crepository.save(new Category("Island"));
			crepository.save(new Category("Natural park"));
			
			//creating travel destination data
			drepository.save(new Destination("Bangkok","Bangkok","shopping, temples, markets, thaiboxing", 3, crepository.findByName("City").get(0)));
			drepository.save(new Destination("Pattaya","Chonburi","buddha mountain, beach, water park, night life, seafood", 5, crepository.findByName("City").get(0)));
			drepository.save(new Destination("Koh Tao","Surat Thani","diving, snorkling, beach, nature", 4, crepository.findByName("Island").get(0)));
			drepository.save(new Destination("Khao Sok National Park", "Surat Thani", "jungle, elephants, safari, camping, lake", 5, crepository.findByName("Natural park").get(0)));
			drepository.save(new Destination("Chiang Mai", "Chiang Mai", "tempels, markets, shopping, landscapes, nature", 4, crepository.findByName("City").get(0)));
			/*
			//inserting demo data, example of using mariaDB
			jdbcTemplate.update("insert into destination(destinationName,province,mainAttraction,rating,category) values (?,?,?,?,?)","Bangkok","Bangkok","shopping,temples, markets, thaiboxing",3,crepository.findByName("City").get(0));
			*/
			
			
			//creating users User/Password, Administrator/Password1
			User user1 = new User("User","$2a$10$X5QadUovgPqtE73C3Q.MXeQw1jNnntBIo7vIRYNb511WwQZq31gBW","USER"); 
			User user2 = new User("Administrator","$2a$10$8JeLplYw.sD6NxZyc2ylUO6es4T/Ldke0llODCWYI3YuH4Qj/Bw9a","ADMIN"); 
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all data from destinations");
			for (Destination destination : drepository.findAll()) {
				log.info(destination.toString());
			}
		};
	}
}
