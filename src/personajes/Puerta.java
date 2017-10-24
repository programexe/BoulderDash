package personajes;

import Juego.Mapa;

/**
 * Clase que instancia la puerta. Mientras no se hayan recolectados los diamantes necesarios
 * en el nivel que se esta jugando, esta permanece cerrada.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class Puerta extends Inanimados{
	
	private boolean abierta;  
	
	public Puerta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public Puerta(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
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
	
	/**
	 * Evalua si se recolectaros todos los diamantes. De ser asi se abre la puerta para pasar
	 * al siguiente nivel.
	 * 
	 * @param m Mapa
	 */
	public void actualizar(Mapa m){		
		if(m.getTotalDiamantes()-m.getDiamantesRecolectados()==0){
			this.setAbierta(true);
		}
	}
}
