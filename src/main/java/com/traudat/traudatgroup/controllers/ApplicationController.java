package com.traudat.traudatgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.traudat.traudatgroup.jwt.JwtTokenProvider;
import com.traudat.traudatgroup.models.LoginRequest;

@Controller
public class ApplicationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@GetMapping("/index")
	public String goHomePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateJwtToken(authentication);
		
		return "redirect:/index";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
