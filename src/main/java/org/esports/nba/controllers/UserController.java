package org.esports.nba.controllers;

import org.esports.nba.entities.UserEntity;
import org.esports.nba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/authenticated", method = RequestMethod.GET)
	public UserEntity getAuthenticatedUser() {
		return this.userService.getAuthenticatedUser();
	}
	
}
