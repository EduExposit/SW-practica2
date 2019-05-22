package es.codeurjc.ais.tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StadisticsService {

	private HashSet<Player> bucket;

	public StadisticsService() {
		bucket = new HashSet<Player>();
	}
	public void addPlayer(Player player) {
		bucket.add(player);
	}

	public List<Player> getPlayers () {
		List<Player> listaOrdenada = new ArrayList<>();
		// Copiamos el conjunto a una lista para manipularla
		listaOrdenada.addAll(bucket);
		return listaOrdenada;
	}
	public Player getPlayer(String name) {
		if (!exists(name)) {
			return null;
		}

		boolean encontrado = false;
		Player aux = null;
		Iterator<Player> i = bucket.iterator();
		while (i.hasNext() && !encontrado) {
			Player p = (Player) i.next();
			if (p.getName().equals(name)) { // Case Sensitive!
				encontrado = true;
				aux = p;
			}
		}
		return aux;
	}
	public boolean exists(String name) {
		return bucket.contains(new Player(0, "", name));
	}

}
