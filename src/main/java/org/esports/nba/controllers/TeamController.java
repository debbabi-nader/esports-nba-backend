package org.esports.nba.controllers;

import java.util.Collection;

import org.esports.nba.entities.TeamEntity;
import org.esports.nba.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/teams")
public class TeamController {

	private final TeamService teamService;

	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection<TeamEntity> getAllTeams() {	
		return this.teamService.getAllTeams();
	}

}
