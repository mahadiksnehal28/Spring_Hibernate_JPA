package com.in28Minutes.jpa.hibernate.demo.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
  public abstract class Employee {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	

	//Default constructor
	protected Employee(){};
	
	public Employee(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Employee [" + name + "]";
	}

	
	
	
}
