package es.codeurjc.ais.tictactoe;

public class Player {

	private String label;
	private String name;
	private int id;

	private int jugadas;
	private int ganadas;
	private int perdidas;
	private int empatadas;

	public Player(int id, String label, String name) {
		this.id = id;
		this.label = label;
		this.name = name;
		this.jugadas = 0;
		this.ganadas=0;
		this.perdidas=0;
		this.empatadas=0;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getGanadas() {
		return ganadas;
	}

	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}

	public int getJugadas() {
		return jugadas;
	}

	public void setJugadas(int jugadas) {
		this.jugadas = jugadas;
	}

	public int getPerdidas() {
		return perdidas;
	}

	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}

	public int getEmpatadas() {
		return empatadas;
	}

	public void setEmpatadas(int empatadas) {
		this.empatadas = empatadas;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null) { // Comprobación de null
			if (o == this) { // Comprobación de this
				return true;
			} else if (o instanceof Player) { // Comprobación de objeto de la clase
				Player p = (Player) o; // Casting a Player
				return this.name.equals(p.name); // Compara por el nombre (identificador)
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
