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
//		test.testUpdate();
//		test.testDelete();
//		test.testFindByPk();
//		test.testFindByLogin();
		test.TestAuthenticate();
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

		dto.setFirstName("Amit");
		dto.setLastName("Kirar");
		dto.setLogin("amit@gmail.com");
		dto.setPassword("Pass@123");
		dto.setId(3);

		service.update(dto);
		System.out.println("Data Updated Successfully");

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		service.delete(dto);
		System.out.println("Data Deleted Successfully");
	}

	private void testFindByPk() {
		UserDTO dto = service.findByPk(3);

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("No Record found");
		}

	}

	private void testFindByLogin() {
		UserDTO dto = service.findByLogin("amit@gmail.com");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("No Record found");
		}
	}

	private void TestAuthenticate() {
		UserDTO dto = service.authenticate("amit@gmail.com", "Pass@123");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("No Record found");
		}

	}
}
