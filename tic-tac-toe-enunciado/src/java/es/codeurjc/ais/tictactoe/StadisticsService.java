package es.codeurjc.ais.tictactoe;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
	
@Component
public class StadisticsService {

	private ArrayList<Player> bucket;

	public StadisticsService() {
		bucket = new ArrayList<Player>();
	}
	public void addPlayer(Player player) {
		bucket.add(player);
	}

	public ArrayList<Player> getPlayers () {
		return bucket;
	}
}
