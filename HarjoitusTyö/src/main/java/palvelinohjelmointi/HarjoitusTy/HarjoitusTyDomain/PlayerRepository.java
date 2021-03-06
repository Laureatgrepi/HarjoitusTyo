package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	List<Player> findByLastName(String lastName);
	List<Player> findByTeam(Team team);
}
