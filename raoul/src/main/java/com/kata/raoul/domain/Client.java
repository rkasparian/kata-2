package com.kata.raoul.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Client implements Serializable
{
   /** Default value included to remove warning. Remove or modify at will. **/
   private static final long serialVersionUID = 1L;
   
   public Client() {
	   
   }

   public Client(Long id)
   {
	   this.id = id;
   }

   public Client(Long id, String firstName, String lastName, String phoneNumber, String email)
   {
	   this.id = id;
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.phoneNumber = phoneNumber;
	   this.email = email;
   }

   public Client(String firstName, String lastName, String phoneNumber, String email)
   {
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.phoneNumber = phoneNumber;
	   this.email = email;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String firstName;

   @Column(nullable = false)
   private String lastName;

   @Column(unique = true)
   private String email;

   @Column(nullable = false)
   private String phoneNumber; 

   @Column(nullable = false)
   private BigDecimal currentBalance = BigDecimal.ZERO;
   
   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "id")
   private Set<Operation> operations = new HashSet<Operation>();

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
   
}
