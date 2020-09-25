package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args) -> {
			repository.save(new Customer("DemoCustomer", "1"));
			repository.save(new Customer("DemoCustomer", "2"));
			repository.save(new Customer("DemoCustomer", "3"));
			repository.save(new Customer("DemoCustomer", "4"));
			repository.save(new Customer("DemoCustomer", "5"));

			//Hent alle
			log.info("Customers found with findAll():");
			log.info("--------------------");
			for(Customer customer : repository.findAll()){
				log.info(customer.toString());
			}
			log.info("");

			//Hent 1 med id
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("-------------------------------");
			log.info(customer.toString());
			log.info("");

			//Hent 1 med lastName
			log.info("Customer found with findByLastName('1'):");
			log.info("----------------------------");
			repository.findByLastName("1").forEach(c -> {
				log.info(c.toString());
			});
			log.info("");

		};
	}

}
