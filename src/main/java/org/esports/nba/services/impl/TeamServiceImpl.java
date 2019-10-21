package org.esports.nba.services.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.esports.nba.entities.TeamEntity;
import org.esports.nba.repositories.TeamRepository;
import org.esports.nba.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TeamServiceImpl implements TeamService {

	private final static Log LOGGER = LogFactory.getLog(TeamService.class);
	
	private final TeamRepository teamRepository;
	
	@Autowired
	public TeamServiceImpl(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	@Override
	public Collection<TeamEntity> getAllTeams() {
		
		LOGGER.info("TeamServiceImpl's getAllTeams method is running...");
		
		return this.teamRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	
	}
	
}
