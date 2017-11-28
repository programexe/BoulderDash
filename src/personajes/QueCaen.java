package personajes;

import Juego.Mapa;
import personajes.direccionAnimados;

/**
 * Esta es la clase padre de los elementos que pueden caer como la roca o el diamante.
 * 
 * @author Ezequiel Humar - Sebasti�n Sauer Rosas
 *
 */
public abstract class QueCaen extends Animados{


	
	private boolean cayendo; /* Indica si el elemento debe caer */

	
	public QueCaen(int i, int j){
		this.x = i;
		this.y = j;
	}
	
	/**
	 * Contructor del elemento que indica la posicion y si es un elemento que debe caer
	 * desde un principio o no.
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 * @param cayendo Indica si el elemento debe caer
	 */
	public QueCaen(int i, int j, boolean cayendo) {
		super(i, j);
		this.cayendo = cayendo;
		// TODO Auto-generated constructor stub
	}
	
	public void informar(){
		System.out.print("Es un elemento animado");
	}

	public boolean isCayendo() {
		return cayendo;
	}

	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
	}
	
	public void informarCaida(){
		System.out.println("La roca de la posicion " + this.getX() + "," + (this.getY()-1) + " cayo a " + this.getX() + "," + this.getY());
	}
	
	public boolean isQueCaen() {
		return true;
	}

}
