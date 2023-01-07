package com.nttdata.spring.restcontrollers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepositoryI;

/**
 * Spring - Taller practico 5 - Spring REST
 * 
 * Controlador REST de Customer
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@RestController
@RequestMapping("/home")
public class CustomerRestController {

	// Repositorio
	private CustomerRepositoryI customerRepository;

	// Map auxiliar para guardar los Customers existentes
	private static Map<String, Customer> customerList = new HashMap<>();

	/**
	 * Metodo constructor para inicializar el repositorio y el Map
	 * 
	 * @param customerRepository
	 */
	public CustomerRestController(CustomerRepositoryI customerRepository) {
		this.customerRepository = customerRepository;
		List<Customer> customers = this.customerRepository.findAll();
		for (Customer c : customers) {
			customerList.put(c.getId().toString(), c);
		}
	}

	/**
	 * Metodo para mostrar todos los Customers
	 * 
	 * (POSTMAN) -> GET - localhost:8081/home/customers
	 *  
	 * @return
	 */
	@RequestMapping("/customers")
	public Map<String, Customer> showCustomers() {
		return customerList;
	}

	/**
	 * Metodo para anyadir Customer
	 * 
	 * (POSTMAN) -> POST - localhost:8081/home + body
	 * 
	 * @param customer
	 */
	@PostMapping
	public void addCustomer(final @RequestBody Customer customer) {
		customerList.put(customer.getId().toString(), customer);
	}

	/**
	 * Metodo para borrar un Customer
	 * 
	 * (POSTMAN) -> DEL - localhost:8081/home/{id de Customer}
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteCustomer(final @PathVariable String id) {
		customerList.remove(id);
	}

	/**
	 * Metodo para buscar segun el nombre de Customer
	 * 
	 * (POSTMAN) -> GET - localhost:8081/home/customer + body
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(path = "/customer", method = RequestMethod.GET, consumes = "application/json")
	public List<Customer> searchByName(@RequestBody Customer customer) {
		// Lista para almacenar los Customers que tengan el mismo nombre solicitado
		List<Customer> customerListByName = new ArrayList<>();

		for (Customer c : customerList.values()) {
			if (c.getName().equals(customer.getName())) {
				customerListByName.add(c);
			}
		}

		return customerListByName;
	}
}
