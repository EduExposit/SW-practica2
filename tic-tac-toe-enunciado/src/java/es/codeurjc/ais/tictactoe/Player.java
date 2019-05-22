package es.codeurjc.ais.tictactoe;

public class Player {

	private String label;
	private String name;
	private int id;
	
	private int ganadas;
	private int perdidas;
	private int empatadas;

	public Player(int id, String label, String name) {
		this.id = id;
		this.label = label;
		this.name = name;
		this.ganadas=0;
		this.perdidas=0;
		this.empatadas=0;
	}

	public String getLabel() {
		return label;
	}

	public int getId() {
		return id;
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
	
	
}
