package com.example.blogv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("/40X")
	public String ex40x() {
		return "/error/ex40x";
	}
}
