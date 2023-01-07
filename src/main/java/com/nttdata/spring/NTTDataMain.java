package com.nttdata.spring;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepositoryI;
import com.nttdata.spring.restcontrollers.CustomerRestController;

/**
 * Spring - Taller practico 3 y Taller practico 5 - Spring Data y Spring REST
 * 
 * Clase Main
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {

	// Logger
	private static final Logger LOG = LoggerFactory.getLogger(NTTDataMain.class);

	// Creacion del repositorio para Customer
	@Autowired
	private CustomerRepositoryI customerRepository;

	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creacion y seteo de datos de Customer
		// Cliente 1
		Customer c1 = new Customer();
		c1.setName("Gabriel");
		c1.setSurname("Rodriguez Felix");
		c1.setBirthDate(LocalDate.of(1999, 7, 1));
		c1.setIdentityDocument("11111111A");
		// Cliente 2
		Customer c2 = new Customer();
		c2.setName("Gabriel");
		c2.setSurname("Perez Perez");
		c2.setBirthDate(LocalDate.of(1989, 2, 13));
		c2.setIdentityDocument("22222222B");

		// Guardado en la BBDD
		customerRepository.save(c1);
		customerRepository.save(c2);

		LOG.info("Numero de registros en la base de datos -> {}", customerRepository.count());
		LOG.info("Cliente con documento de identidad 11111111A -> {}",
				customerRepository.findByIdentityDocument("11111111A"));

		CustomerRestController controller = new CustomerRestController(customerRepository);

	}

}
