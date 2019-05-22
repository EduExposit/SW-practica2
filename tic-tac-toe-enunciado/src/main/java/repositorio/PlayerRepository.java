package repositorio;
import java.sql.Date; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.ais.tictactoe.Player;



public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	Player findByName(String name);
}

