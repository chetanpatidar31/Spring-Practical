package com.rays.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping
	public String display() {
		return "in diplay method";
	}

	@GetMapping("display1")
	public TestDTO display1() {

		TestDTO dto = new TestDTO();

		dto.setId(1l);
		dto.setFirstName("Chetan");
		dto.setLastName("Patidar");
		dto.setLogin("chetan@gmail.com");
		dto.setPassword("Pass@123");
		dto.setDob("12-05-2025");

		return dto;
	}

	@GetMapping("display2")
	public ORSResponse display2() {

		ORSResponse resp = new ORSResponse();

		return resp;

	}

	@GetMapping("dispaly3")
	public ORSResponse display3() {
		ORSResponse resp = new ORSResponse();

		Map<String, String> errors = new HashMap<String, String>();

		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("login", "login id is required");
		errors.put("password", "password is required");
		errors.put("dob", "dob is required");

		resp.addInputError(errors);

		return resp;
	}

	@GetMapping("dispaly4")
	public ORSResponse display4() {
		ORSResponse resp = new ORSResponse();

		TestDTO dto = new TestDTO();
		dto.setId(1l);
		dto.setFirstName("Shubham");
		dto.setLastName("Patidar");
		dto.setLogin("shubham@gmail.com");
		dto.setPassword("Pass@123");
		dto.setDob("09-05-2025");

		resp.setSuccess(true);
		resp.addData(dto);

		return resp;
	}

	@GetMapping("dsiplay5")
	public ORSResponse display5() {

		ORSResponse resp = new ORSResponse();

		TestDTO dto1 = new TestDTO();
		dto1.setId(1L);
		dto1.setFirstName("abc");
		dto1.setLastName("abc");
		dto1.setLogin("abc@gmail.com");
		dto1.setPassword("123");
		dto1.setDob("01-06-2025");

		TestDTO dto2 = new TestDTO();
		dto2.setId(2L);
		dto2.setFirstName("xyz");
		dto2.setLastName("xyz");
		dto2.setLogin("xyz@gmail.com");
		dto2.setPassword("123");
		dto2.setDob("02-06-2025");

		List<TestDTO> list = new ArrayList<TestDTO>();

		resp.setSuccess(true);
		list.add(dto1);
		list.add(dto2);

		resp.addData(list);

		return resp;
	}

	@GetMapping("display6")
	public ORSResponse display6() {

		ORSResponse resp = new ORSResponse();

		resp.setSuccess(false);
		resp.addMessage("invalid loginid or password");

		return resp;
	}

	@GetMapping("display7")
	public ORSResponse display7() {

		ORSResponse res = new ORSResponse();

		res.setSuccess(false);
		res.addResult("preload", "preloaded data");

		return res;
	}

	@PostMapping
	public String submit() {
		return "in submit method";
	}

}
