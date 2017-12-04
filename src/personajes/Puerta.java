package personajes;

import Juego.Juego;
import Juego.Mapa;

/**
 * Clase que instancia la puerta. Mientras no se hayan recolectados los diamantes necesarios
 * en el nivel que se esta jugando, esta permanece cerrada.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public class Puerta extends Inanimados{
	
	private boolean abierta;  
	private static Puerta puerta;
	
	private Puerta(int i, int j){
		this.x = i;
		this.y = j;
		this.setAbierta(false);
	}
	
	public static Puerta getInstance(){
		if (puerta == null)
			puerta = new Puerta(0,0);
			
		return puerta;
	}
	
	public static Puerta getInstanceSetPosition(int i, int j){
		if (puerta == null){
			puerta = new Puerta(i,j);
		}
		else{
			puerta.setX(i);
			puerta.setY(j);
		}
		return puerta;
	}	
	

	public void informar(){
		if (abierta){
			System.out.print("Es una puerta abierta");
		}
		else System.out.print("Es una puerta cerrada");
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
	
	
	public boolean isPuerta() {
		return true;
	}
	
	public void explotar(){
		
	}	
	
	public String toStringPos() {
		return ("Puerta");

	}
}
