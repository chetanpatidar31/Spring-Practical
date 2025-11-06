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

//		test.testAdd();
		test.testUpdate();
//		test.testDelete();
	}

	private void testAdd() {
		UserDTO dto = new UserDTO();

		dto.setFirstName("Aditya");
		dto.setLastName("Sharma");
		dto.setLogin("aditya@gmail.com");
		dto.setPassword("Pass@123");

		long pk = service.add(dto);
		System.out.println("Data added Successfully : " + pk);

	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();

		dto.setFirstName("Aastik");
		dto.setLastName("Sahu");
		dto.setLogin("aastik@gmail.com");
		dto.setPassword("pass123");
		dto.setId(1);

		service.update(dto);
		System.out.println("Data Updated Successfully");

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
	}
}
