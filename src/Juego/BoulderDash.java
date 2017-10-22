package Juego;
import personajes.*;

public class BoulderDash {
	
	private Mapa m=new Mapa();
	private Rockford personaje=new Rockford();
	private int recolectados=0;

	public Mapa getM() {
		return m;
	}

	public void setM(Mapa m) {
		this.m = m;
	}

	public Rockford getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Rockford personaje) {
		this.personaje = personaje;
	}

	public int getRecolectados() {
		return recolectados;
	}

	public void setRecolectados(int recolectados) {
		this.recolectados = recolectados;
	}

}
