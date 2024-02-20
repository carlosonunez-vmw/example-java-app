package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Hello, and welcome to the Rocky Mountain Cyberspace Symposium 2024! Thanks for coming to this super-late talk!";
	}

}
