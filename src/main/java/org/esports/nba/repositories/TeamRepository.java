package org.esports.nba.repositories;

import org.esports.nba.entities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {

}
