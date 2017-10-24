package personajes;

/**
* Clase padre de todos los elementos que pueden explotar en el mapa del juego.
* 
* @author Ezequiel Humar - Sebastián Sauer Rosas
* 
*/
public abstract class Explosivos extends QueNoCaen{
	
	public Explosivos() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public Explosivos(int i, int j) {
		super(i, j);
		
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es explosivo");
	}
}
