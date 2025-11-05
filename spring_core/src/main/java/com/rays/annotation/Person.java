package com.rays.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {

	@Value("Ajaj")
	private String name;

	@Value("Mandsaur")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
