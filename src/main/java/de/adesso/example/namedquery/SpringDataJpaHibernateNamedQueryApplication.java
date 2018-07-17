package de.adesso.example.SpringDataJPAHibernateNamedQuery;

import de.adesso.example.SpringDataJPAHibernateNamedQuery.dtos.SimpleUserDTO;
import de.adesso.example.SpringDataJPAHibernateNamedQuery.entities.User;
import de.adesso.example.SpringDataJPAHibernateNamedQuery.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


@SpringBootApplication
public class SpringDataJpaHibernateNamedQueryApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(SpringDataJpaHibernateNamedQueryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaHibernateNamedQueryApplication.class, args);
	}

	/*
	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactory() {
		LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
		localEntityManagerFactoryBean.setPersistenceUnitName("persistence");
		return localEntityManagerFactoryBean;
	}
	*/

	@Bean
	public CommandLineRunner run(UserService userService) {
		return (args -> {

			User max = userService.createUser("Max", "Meier");
			User ben = userService.createUser("Ben", "Bauer");

			LOGGER.info("-- greet user ---");
			userService.findAllUser().forEach(user -> LOGGER.info("Hello {}, {} your new username is {}", user.getLastname(), user.getFirstname(), user.getUsername()));

			LOGGER.info("-- test NamedQuery ---");
			SimpleUserDTO userDTOMax = userService.findByUsername(max.getUsername());
			LOGGER.info("User '{}' got the mail-adress {}", userDTOMax.getUsername(), userDTOMax.getMail());

			LOGGER.info("-- test NamedQuery ORM XML ---");
			SimpleUserDTO userDTOBen = userService.findByUsernameOrmXML(ben.getUsername());
			LOGGER.info("User '{}' got the mail-adress {}", userDTOBen.getUsername(), userDTOBen.getMail());
		});
	}
}
