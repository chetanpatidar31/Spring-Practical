package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("multi.xml");

		Person p = (Person) context.getBean("person");

		System.out.println("Name : " + p.getName());
		System.out.println("Address : " + p.getAddress());

		System.out.println("---------------------");

		Employee e = context.getBean("employee", Employee.class);

		System.out.println("Emp Name : " + e.getEmpName());
		System.out.println("Salary : " + e.getSalary());
	}

}
