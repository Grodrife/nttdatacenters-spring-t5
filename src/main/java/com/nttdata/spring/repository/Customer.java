package com.nttdata.spring.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Spring - Taller practico 3 - Spring Data
 * 
 * Entidad Customer - Cliente
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@Entity
@Table(name = "NTTDATA_ST3_CUSTOMER")
public class Customer implements Serializable {

	// Id Serial
	private static final long serialVersionUID = 1L;

	// Id de Customer
	private Long id;

	// Nombre de Customer
	private String name;

	// Apellidos de Customer
	private String surname;

	// Fecha de nacimiento de Customer
	private LocalDate birthDate;

	// Documento de identidad de Customer
	private String identityDocument;

	/**
	 * Metodo Get de Id de Customer
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSequence")
	@SequenceGenerator(name = "customerSequence", sequenceName = "NTTDATA_ST3_CUSTOMER_SEQUENCE")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	/**
	 * Metodo Set de Id de Customer
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo Get de nombre de Customer
	 * 
	 * @return
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Metodo Set de nombre de Customer
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo Get de apellidos de Customer
	 * 
	 * @return
	 */
	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	/**
	 * Metodo Set de apellidos de Customer
	 * 
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Metodo Get de fecha de nacimiento de Customer
	 * 
	 * @return
	 */
	@Column(name = "BIRTH_DATE")
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Metodo Set de fecha de nacimiento de Customer
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Metodo Get de documento de identidad de Customer
	 * 
	 * @return
	 */
	@Column(name = "IDENTITY_DOCUMENT")
	public String getIdentityDocument() {
		return identityDocument;
	}

	/**
	 * Metodo Set de documento de identidad de Customer
	 * 
	 * @param identityDocument
	 */
	public void setIdentityDocument(String identityDocument) {
		this.identityDocument = identityDocument;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate
				+ ", identityDocument=" + identityDocument + "]";
	}

}
