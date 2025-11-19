package com.rays.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping
	public String display() {
		return "in diplay method";
	}

	@PostMapping
	public String submit() {
		return "in submit method";
	}

}
