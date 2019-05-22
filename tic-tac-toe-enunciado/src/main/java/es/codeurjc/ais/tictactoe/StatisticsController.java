package es.codeurjc.ais.tictactoe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StatisticsController {
	@Autowired
	StadisticsService estructuraDatos;

	@RequestMapping("/stats")
	public String crear(Model model) {

		List<Player> jugadores = estructuraDatos.getPlayers();
		
		model.addAttribute("jugadores",jugadores);

		return ("stats");
	}

}
