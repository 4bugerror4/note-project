package com.bug.note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@GetMapping("/auth/login")
	public String login(@RequestParam(value = "exception", required = false)String exception,
						Model model) {
		
		model.addAttribute("exception", exception);
		
		return "user/login";
	}

	@GetMapping("/auth/join")
	public String join() {
		return "user/join";
	}

}
