package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = context.getBean(TestUserService.class);

		test.testAdd();

	}

	private void testAdd() {
		UserDTO dto = new UserDTO();

		dto.setFirstName("Nirmal");
		dto.setLastName("Sen");
		dto.setLogin("nirmal@gmail.com");
		dto.setPassword("Nirmal@123");

		long pk = service.add(dto);
		System.out.println("Data added Successful : " + pk);
	}
}
