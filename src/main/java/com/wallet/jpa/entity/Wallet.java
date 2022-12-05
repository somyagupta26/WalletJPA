package com.wallet.jpa.entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table
public class Wallet {
	@Id
	   @Column
	Integer id;

	String username;
	String firstname;
	String lastname;
	Double balance;
	Date date;
	
	public Wallet(){
		super();
	}

	public Wallet(Integer id, String username, String firstname, String lastname, Double balance) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.balance = balance;
		
	}




	@Override
	public String toString() {
		return "Wallet [id=" + id + ", username=" + username + ", balance=" + balance + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
	
	
}

