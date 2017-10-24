package personajes;

/**
 * Clase para instancia diamantes. Un diamante pude caer o no.
 * 
 * @author Ezequiel Humar - Sebastián Sauer Rosas
 *
 */
public class Diamante extends QueCaen {

	public Diamante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Costructor que setea coordenadas y el estado de que si debe caer o no.
	 * 
	 * @param i        Coordenada X
	 * @param j        Coordenada Y
	 * @param cayendo  Indica si el diamante debe caer
	 */
	public Diamante(int i, int j, boolean cayendo) {
		super(i, j, cayendo);
		// TODO Auto-generated constructor stub
	}

	public void informar(){
		System.out.print("Es diamante");
	}
}
