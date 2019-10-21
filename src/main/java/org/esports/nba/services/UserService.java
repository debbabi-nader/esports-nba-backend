package org.esports.nba.services;

import org.esports.nba.entities.UserEntity;


public interface UserService {
	
	public UserEntity findUserByEmail(String email);
	
	public UserEntity getAuthenticatedUser();
		
}
