package com.rays.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("order11.xml");

		Order1 order = (Order1) context.getBean("order11");

		order.bookATicket(6);
	}
}
