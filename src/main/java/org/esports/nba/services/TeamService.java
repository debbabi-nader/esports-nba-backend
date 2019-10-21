package org.esports.nba.services;

import java.util.Collection;

import org.esports.nba.entities.TeamEntity;


public interface TeamService {

	public Collection<TeamEntity> getAllTeams();
	
}
