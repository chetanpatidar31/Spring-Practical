package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {

	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("person.xml"));
		
		Person p = (Person) factory.getBean("person");
		
		System.out.println("Person's Name : "+p.getName());
		System.out.println("Person's Address : "+p.getAddress());
	}

}
