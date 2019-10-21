package org.esports.nba.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.esports.nba.entities.UserEntity;
import org.esports.nba.repositories.UserRepository;
import org.esports.nba.services.UserService;
import org.esports.nba.exceptions.CustomAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	private final static Log LOGGER = LogFactory.getLog(UserService.class);
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		
		LOGGER.info("UserServiceImpl's findUserByEmail method is running...");
		
		return this.userRepository.findUserByEmail(email);
	
	}
	
	@Override
	public UserEntity getAuthenticatedUser() {
		
		LOGGER.info("UserServiceImpl's getAuthenticatedUser method is running...");
		
		UserEntity userEntity = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null && authentication.getPrincipal() != null && authentication.getPrincipal() instanceof UserDetails)
			userEntity = this.userRepository.findUserByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
		
	    if (userEntity == null)
	    	throw new CustomAuthenticationException();
	    
		return userEntity;
	
	}

}
