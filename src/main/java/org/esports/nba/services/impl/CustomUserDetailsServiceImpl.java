package org.esports.nba.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.esports.nba.entities.UserEntity;
import org.esports.nba.services.CustomUserDetailsService;
import org.esports.nba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	private static final Log LOGGER = LogFactory.getLog(CustomUserDetailsService.class);
	
	private final UserService userService;
	
	@Autowired
	public CustomUserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOGGER.info("CustomUserDetailsServiceImpl's loadUserByUsername method is running...");
		
		UserEntity userEntity = this.userService.findUserByEmail(username);
		if (userEntity == null)
			throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), "", userEntity.getIsActive(), true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
		
	}

}
