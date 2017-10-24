package personajes;

/**
 * Esta es la clase padre de los elementos que no pueden caer.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public abstract class QueNoCaen extends Animados{
	
		
	public QueNoCaen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor que setea coordenadas.
	 * 
	 * @param i Coordenada X
	 * @param j Coordenada Y
	 */
	public QueNoCaen(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es un elemento que no cae");
	}
	
}
