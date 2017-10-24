package personajes;

/**
* Clase padre de todos los elementos que no explota en el mapa del juego.
* 
* @author Ezequiel Humar - Sebastián Sauer Rosas
* 
*/
public abstract class NoExplosivos extends QueNoCaen{

	public NoExplosivos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public NoExplosivos(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un elemento explosivo");
	}
	
	public void expandirse(){
		
	}
}
