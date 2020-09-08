package com.in28Minutes.jpa.hibernate.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
  public class PartTimeEmployee extends Employee{


	//Default constructor
	protected PartTimeEmployee()
	{
		
	}
	
	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage=hourlyWage;
	}


	private BigDecimal hourlyWage;
}
