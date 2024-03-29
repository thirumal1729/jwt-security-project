package com.ty.jwt.security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.jwt.security.entity.User;
import com.ty.jwt.security.service.UserService;

@RestController
@RequestMapping("/home")
public class JwtSecurityController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getUser() {
		
		System.out.println("getting users");
		return this.userService.getUsers();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

}
