package org.esports.nba.repositories;

import org.esports.nba.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query("SELECT user FROM UserEntity AS user WHERE user.email LIKE :email")
	public UserEntity findUserByEmail(@Param("email") String email);
	
}
