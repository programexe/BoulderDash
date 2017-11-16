package personajes;

/**
* Clase padre de todos los elementos que son no son capaces de cambiar su ubicacion en el mapa del juego..
* 
* @author Ezequiel Humar - Sebasti�n Sauer Rosas
* 
*/
public abstract class Inanimados extends Elementos{
	
	public Inanimados(){
		super();	
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */	
	public Inanimados(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un elemento inanimado");
	}
	
	public boolean isInanimados() {
		return true;
	}
	
}
