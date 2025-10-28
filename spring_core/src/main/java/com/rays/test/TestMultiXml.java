package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMultiXml {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("multi.xml"));

		Person p = factory.getBean("person", Person.class);

		System.out.println("Name : " + p.getName());
		System.out.println("Address : " + p.getAddress());

		System.out.println("---------------------");

		Employee e = (Employee) factory.getBean("employee");

		System.out.println("Emp Name : " + e.getEmpName());
		System.out.println("Salary : " + e.getSalary());

	}
}
