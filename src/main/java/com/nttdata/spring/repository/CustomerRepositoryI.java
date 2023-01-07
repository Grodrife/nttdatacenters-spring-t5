package com.nttdata.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring - Taller practico 3 - Spring Data
 * 
 * Repositorio de entidad Customer
 * 
 * @author Gabriel Rodriguez Felix
 *
 */

@Repository
public interface CustomerRepositoryI extends JpaRepository<Customer, Long> {

	/**
	 * Consulta por nombre de Customer
	 * 
	 * @param name
	 * @return
	 */
	public List<Customer> findByName(final String name);

	/**
	 * Consulta por apellidos de Customer
	 * 
	 * @param name
	 * @return
	 */
	public List<Customer> findBySurname(final String name);

	/**
	 * Consulta por fecha de nacimiento de Customer
	 * 
	 * @param birthDate
	 * @return
	 */
	public List<Customer> findByBirthDate(final LocalDate birthDate);

	/**
	 * Consulta por documento de identidad de Customer
	 * 
	 * @param identityDocument
	 * @return
	 */
	public List<Customer> findByIdentityDocument(final String identityDocument);

	/**
	 * Consulta por nombre y apellidos de Customer
	 * 
	 * @param name
	 * @param surname
	 * @return
	 */
	public List<Customer> findByNameAndSurname(final String name, final String surname);
}
