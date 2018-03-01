package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner loadData(HealthyChoiceRepository repository) {
		return (args) -> {
			// save a couple of Diets
			/*			
			repository.save(new HealthyChoice(1L,"Gluten-Free"));
			repository.save(new HealthyChoice(2L,"Vegan"));
			repository.save(new HealthyChoice(3L,"Vegetarian"));
			repository.save(new HealthyChoice(4L,"Non-GMO"));
			repository.save(new HealthyChoice(5L,"Alkaline"));
			repository.save(new HealthyChoice(6L,"Organic"));
			repository.save(new HealthyChoice(7L,"Raw"));
			*/
			
			
			// fetch all Diets
			log.info("Healthy_Choices found with findAll():");
			log.info("-------------------------------");
			for (HealthyChoice choices_tbl : repository.findAll()) {
				log.info(choices_tbl.toString());
			}
			log.info("");

			// fetch an individual diet by ID
			/*HealthyChoice choices_tbl = repository.findOne(1L);
			log.info("Healthy_Choices found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");*/

			/*// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (Healthy_Choices Vegan : repository
					.findBydescriptionStartsWithIgnoreCase("Vegan")) {
				log.info(bauer.toString());
			}*/
			log.info("");
		};
	}

}
